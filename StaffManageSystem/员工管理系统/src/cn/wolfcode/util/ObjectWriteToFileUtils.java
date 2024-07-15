package cn.wolfcode.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ObjectWriteToFileUtils {

    //文件名固定不变,因此固定长度不变
    public static final String FILENAME = "employee.txt";

    //进行序列化操作
    public static <T> void write(List<T> list) throws IOException {
        ObjectOutputStream oos = null;
        oos = new ObjectOutputStream(new FileOutputStream(FILENAME));
        for (T t : list) {
            oos.writeObject(t);
            oos.flush();
        }
        if (oos != null) {
            oos.close();
        }
    }

    //反序列化操作
    public static <T> List<T> read() throws IOException {
        List<T> list = new ArrayList<>();
        ObjectInputStream ois = null;
        ois = new ObjectInputStream(new FileInputStream(FILENAME));
        Object obj = null;
        while ((t = (T)ois.readObject()) != null) {
            list.add(t);
        }
        return list;
    }
}
