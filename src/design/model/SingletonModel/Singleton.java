package design.model.SingletonModel;

/**
 * Created by windvalley on 2018/2/26.
 * 有些对象只要有一个就足够了
 * 保证整个应用程序中某个实例有且只有一个
 * 饿汉式 -> 加载类时比较慢,但运行时获取对象的速度比较快,线程安全的
 * 懒汉式 -> 加载类时比较快,但运行时获取对象的速度比较慢,线程不安全的
 */
public class Singleton {
/*
懒汉式
    private static Singleton singleton;

    private Singleton(){

    }

    public synchronized static Singleton getInstance(){
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
*/

//饿汉式
    private static Singleton singleton = new Singleton();

    private Singleton(){

    }

    public static Singleton getInstance(){
        return singleton;
    }
}
