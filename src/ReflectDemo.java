import java.lang.reflect.*;
import java.util.Date;

/**
 * Created by windvalley on 2018/2/25.
 */

class Person4ReflectDemo{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person4ReflectDemo(){
        System.out.println("无参构造函数");
    }

    public Person4ReflectDemo(String name, int age){
        setName(name);
        setAge(age);
    }

    @Override
    public String toString() {
        return "name:" + getName() + " age:" + getAge();
    }

    private void print(){
        System.out.println("ABC");
    }
}

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Date dateA = new Date();
        System.out.println(dateA);

        //1.必须有明确的实例化对象以后才可以调用
        Class<?> clsA = dateA.getClass();
        System.out.println("全名:" + clsA.getName());
        System.out.println("类名:" + clsA.getSimpleName());

        Class<?> clsB = java.util.Date.class;
        System.out.println("全名:" + clsB.getName());
        System.out.println("类名:" + clsB.getSimpleName());


        //最为重用,根据字符串可以实例化对象
        Class<?> clsC = Class.forName("java.util.Date");
        Date dateB = (Date) clsC.newInstance();
        System.out.println("全名:" + clsC.getName());
        System.out.println("类名:" + clsC.getSimpleName());
        System.out.println(dateB);

        //该类无参的构造函数创建对象,必须有一个无参的构造函数才可以这样使用
        Class<?> clsD = Class.forName("Person4ReflectDemo");
        Person4ReflectDemo person4ReflectDemoA = (Person4ReflectDemo) clsD.newInstance();
        System.out.println(person4ReflectDemoA.toString());

        //该类没有无参的构造函数,只有有参构造函数创建对象
        Class<?> clsE = Class.forName("Person4ReflectDemo");
        Constructor<?> constructor = clsE.getConstructor(String.class, int.class);
        Person4ReflectDemo person4ReflectDemoB = (Person4ReflectDemo) constructor.newInstance("王健", 18);
        System.out.println(person4ReflectDemoB.toString());

        //调用类方法
        Class<?> clsF = Class.forName("Person4ReflectDemo");
        Object object = clsF.newInstance();
        Method method = clsF.getMethod("setAge", int.class);
        method.invoke(object, 28);

        //调用私有方法,要使用getDeclaredMethod,并且要调用setAccessible,取消私有权限才可以调用
        method = clsF.getDeclaredMethod("print");
        method.setAccessible(true);
        method.invoke(object);
        System.out.println(object.toString());

        //调用类成员
        Field field = clsF.getDeclaredField("name");
        //因为类成员基本上是私有的,必须取消封装才可以访问私有的类成员
        field.setAccessible(true);
        field.set(object, "玩具");
        System.out.println(object.toString());
    }
}
