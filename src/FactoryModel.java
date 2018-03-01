/**
 * Created by windvalley on 2018/2/25.
 */
interface Fruit{
    public void eat();
}

class Apple implements Fruit{
    @Override
    public void eat() {
        System.out.println("========吃苹果========");
    }
}

class Balana implements Fruit{
    @Override
    public void eat() {
        System.out.println("========吃香蕉========");
    }
}

class OldFactory {
    public static Fruit getInstance(String className){
        if ("Apple".equals(className) == true){
            return new Apple();
        } else {
            if ("Balana".equals(className) == true){
                return new Balana();
            }
            return null;
        }
    }
}

class NewFactory{
    public static Fruit getInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> cls = Class.forName(className);
        if (cls != null){
            return (Fruit) cls.newInstance();
        }
        return null;
    }
}

public class FactoryModel {
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        conventionFunc();
        reflectFunc();
    }

    //反射工厂设计模式
    private static void reflectFunc() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Fruit apple = NewFactory.getInstance("Apple");
        apple.eat();;

        Fruit balana = NewFactory.getInstance("Balana");
        balana.eat();

        Fruit origin = NewFactory.getInstance("Origin");
        if (origin != null) {
            origin.eat();
        } else {
            System.out.println("没有orgin类");
        }
    }

    //传统工厂设计模式
    private static void conventionFunc() {
        Fruit apple = OldFactory.getInstance("Apple");
        apple.eat();

        Fruit balana = OldFactory.getInstance("Balana");
        balana.eat();
    }
}
