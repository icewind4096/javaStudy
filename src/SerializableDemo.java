import Lession4.Employee;
import java.io.*;

/**
 * Created by windvalley on 2018/3/5.
 */
public class SerializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "D:" + File.separatorChar + "level" + File.separatorChar + "serial.txt";
        serializObject(fileName, new Employee("张三", 1000, 1990, 12, 13));
        unSerializObject(fileName);
    }

    private static void unSerializObject(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
        Object object = objectInputStream.readObject();
        //这里可以用反射操作数据，下面可以实现以下
        System.out.println(object);
        objectInputStream.close();
    }

    private static void serializObject(String fileName, Employee employee) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        objectOutputStream.writeObject(employee);
        objectOutputStream.close();
    }
}
