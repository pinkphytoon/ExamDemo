package cn.wolfcode.domain;

public class Employee {
    private Long id;
    private String username;
    private String password;
    private String realName;
    private double salary;
    private String email;
    private Long deptNo;
    public static final String SUFFIX = "@wolfcode.cn";

    public Employee() {
    }

    public Employee(Long id, String username, String password, String realName, double salary, Long deptNo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.salary = salary;
        this.email = username + SUFFIX;
        this.deptNo = deptNo;
    }

    public Employee(Long id, String username, String password, String realName, double salary, String email ,Long deptNo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.salary = salary;
        this.email = email;
        this.deptNo = deptNo;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = username + SUFFIX;
    }

    public Long getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Long deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                ", deptNo=" + deptNo +
                '}';
    }
}
