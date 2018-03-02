package Lession5;

import Lession4.Employee;

import java.io.File;
import java.lang.reflect.*;

/**
 * Created by MMNJ005 on 2018/3/2.
 */
public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        getClassNameByObject();

        getClassByString();

        getClassInfo("Lession4.Employee");
    }

    private static void getClassInfo(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> classs = Class.forName(className);
        System.out.println("=根据字符串可以实例化对象======================");
        System.out.println("全名" + classs.getName());
        System.out.println("类名" + classs.getSimpleName());
        printConstructor(classs);
        printMethod(classs);
        printField(classs);
        System.out.println("============================================");
    }

    private static void printField(Class<?> classs) {
        Field[] fields = classs.getDeclaredFields();
        for (Field field : fields){
            String modifier = Modifier.toString(classs.getModifiers());
            if (modifier.length() > 0) System.out.print(modifier + " ");
            System.out.println(field.getType().getName() + " " + field.getName());
        }
    }

    private static void printMethod(Class<?> classs) {
        Method[] methods = classs.getDeclaredMethods();
        for (Method method: methods){
            Class retType = method.getReturnType();
            String modifier = Modifier.toString(classs.getModifiers());
            if (modifier.length() > 0) System.out.print(modifier + " ");
            System.out.println(retType.getName() + " " + method.getName() + "(" + getParamaters(method.getParameterTypes()) + ")");
        }
    }

    private static void printConstructor(Class<?> classs) {
        Constructor[] constructors = classs.getDeclaredConstructors();
        for (Constructor constructor: constructors){
            String modifier = Modifier.toString(classs.getModifiers());
            if (modifier.length() > 0) System.out.print(modifier + " ");
            System.out.println(constructor.getName() + "(" + getParamaters(constructor.getParameterTypes()) + ")");
        }
    }

    private static String getParamaters(Class[] paramTypes) {
        String paramaters = "";
        for (int i = 0; i < paramTypes.length; i ++){
            if (i > 0) paramaters = paramaters + ", ";
            paramaters = paramaters + paramTypes[i].getName();
        }
        return paramaters;
    }

    //根据字符串可以实例化对象
    private static void getClassByString() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println("=根据字符串可以实例化对象======================");
        String className = "Lession5.Manager";
        Class<?> cls = Class.forName(className);
        System.out.println("全名:" + cls.getName());
        System.out.println("类名:" + cls.getSimpleName());
        System.out.println(cls);

        //构造函数有参数的，必须使用构造器
        Constructor<?> constructor = cls.getConstructor(String.class, double.class, int.class, int.class, int.class);
        Manager manager = (Manager) constructor.newInstance("Manager", 10, 2018,1,1);
        System.out.println(manager.toString());
        System.out.println("===============================================");

        //该类无参的构造函数创建对象,必须有一个无参的构造函数才可以这样使用
        Class<?> clsD = Class.forName("Lession4.Employee");
        Employee employee = (Employee) clsD.newInstance();
        System.out.println(employee.toString());
    }

    //根据对象得到类名
    //必须有明确的实例化对象以后才可以调用
    private static void getClassNameByObject() {
        System.out.println("=根据对象得到类名================================");
        Employee employee = new Employee("employee", 10, 2018,1,1);
        System.out.println("全名:" + employee.getClass().getName());
        System.out.println("类名:" + employee.getClass().getSimpleName());
        System.out.println("===============================================");
    }
}