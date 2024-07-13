package cn.wolfcode.Service;

import cn.wolfcode.domain.Employee;
import cn.wolfcode.ui.MenuUI;
import cn.wolfcode.util.TimeFormatUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeService {
    private static ArrayList<Employee> employees;
    private static Scanner sc;

    static {
        sc = new Scanner(System.in);
        employees = new ArrayList<>();
        employees.add(new Employee(1L, "liuBei", "liuBei666", "刘备", 8754.36, "liuBei@wolfcode.cn", 1L));
        employees.add(new Employee(2L, "caoCao", "caoCao000", "曹操", 9630.25, "caoCao@wolfcode.cn", 2L));
        employees.add(new Employee(3L, "sunQuan", "sunQuan777", "孙权", 7777.36, "sunQuan@wolfcode.cn", 3L));
        employees.add(new Employee(4L, "guanYu", "guanYu666", "关羽", 6543.21, "guanYu@wolfcode.cn", 1L));
        employees.add(new Employee(5L, "zhaoYun", "zhaoYun999", "赵云", 8888.88, "zhaoYun@wolfcode.cn", 1L));
        employees.add(new Employee(6L, "sunShangXiang", "sunShangXiang555", "孙尚香", 6666.66, "sunShangXiang@wolfcode.cn", 1L));
        employees.add(new Employee(7L, "dianWei", "dianWei123", "典韦", 9456.33, "dianWei@wolfcode.cn", 2L));
        employees.add(new Employee(8L, "xuChu", "xuChu456", "许褚", 9000, "xuChu@wolfcode.cn", 2L));
        employees.add(new Employee(9L, "zhouYu", "zhouYu857", "周瑜", 7410, "zhouYu@wolfcode.cn", 3L));
        employees.add(new Employee(10L, "xiaoQiao", "xiaoQiao741", "小乔", 9999.63, "xiaoQiao@wolfcode.cn", 3L));
    }

    public void homePage() {
        System.out.println("================");
        System.out.println("=====" + TimeFormatUtils.timeFormat() + "====");
        System.out.println("================");

        a:
        while (true) {
            MenuUI.menu();
            System.out.print("请选择你要执行的操作：");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    edit();
                    break;
                case 4:
                    showAll(employees);
                    break;
                case 0:
                    sc.close();
                    System.out.println("欢迎下次光临~~~");
                    break a;
            }
        }
    }

    private void edit() {
        System.out.print("请输入你要编辑员工的ID:");
        Long id= sc.nextLong();
        Employee employee = selOneById(id);
        if(employee ==null){
            System.out.println("查无此人，编辑失败了");
        }else{
            System.out.println("编辑前："+employee.toString());
            while(true){
                System.out.print("请输入员工账户：");
                String username = sc.next();
                if(usernameIsExists(username)){
                    System.out.println("账户名已存在，请重新输入");
                }else{
                    employee.setUsername(username);
                    System.out.print("请输入员工的密码：");
                    employee.setPassword(sc.next());
                    System.out.print("请输入员工的真实姓名：");
                    employee.setRealName(sc.next());
                    System.out.print("请输入员工的薪资：");
                    employee.setSalary(sc.nextDouble());
                    employee.setEmail(username);

                    System.out.print("请输入员工的部门编号：");
                    employee.setDeptNo(sc.nextLong());
                    int index = (int)(id - 1);
                    employees.set(index,employee);
                    System.out.println("编辑成功！！！");
                    System.out.println(employee.toString());
                    break;
                }
            }
        }
    }

    private void delete() {
        System.out.print("请输入你要删除的员工的ID:");
        Long id = sc.nextLong();
        Employee employee = selOneById(id);
        if(employee  == null){
            System.out.println("查无此人，删除失败了");
        }else{
            employees.remove(employee);
            System.out.println("此人已成功删除，重新展示员工信息");
            showAll(employees);
        }
    }

    private Employee selOneById(Long id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    private void add() {
        while (true) {
            System.out.print("请输入员工的账户：");
            String username = sc.next();
            if (usernameIsExists(username)) {
                System.out.print("账户名以存在，请重新输入");
            } else {
                System.out.print("请输入员工的密码：");
                String password = sc.next();
                System.out.print("请输入员工的真实姓名：");
                String realName = sc.next();
                System.out.print("请输入员工的薪资：");
                double salary = sc.nextDouble();
                System.out.print("请输入员工的部门编号：");
                Long deptNo = sc.nextLong();
                long id = getId();
                Employee emp = new Employee(++id, username, password, realName, salary, deptNo);
                employees.add(emp);
                System.out.println("添加成功");
                showAll(employees);
                break;
            }
        }
    }

    private void showAll(ArrayList<Employee> employees) {
        for (Employee emp : employees) {
            System.out.println(emp.toString());
        }
    }

    private long getId() {
        return employees.get(employees.size() - 1).getId();
    }

    private boolean usernameIsExists(String username) {
        for (Employee emp : employees) {
            if (emp.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}