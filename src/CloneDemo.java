/**
 * Created by windvalley on 2018/2/20.
 */

//Cloneable 表示本类对象可以克隆,是一个标识接口
class Person implements Cloneable{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "姓名:" + name + " 年龄:" + age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class CloneDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person("小刚", 12);
        Person person2 = (Person) person1.clone();
        System.out.println(person1);
        System.out.println(person2);
    }
}
