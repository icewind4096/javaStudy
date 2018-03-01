/**
 * Created by windvalley on 2018/2/21.
 * Runtime是单例
 * -Xms 初始分配内存大小 为物理内存的1/64,最多不超过1G;
 * -Xmx 最大分配内存大小 为物理内存的1/4;
 * -Xmn 年轻代堆内存大小
 */

class PersonInfo {
    private String name;
    private int age;

    public PersonInfo(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println("Person 建立成功");
    }

    @Override
    protected void finalize() throws Throwable{
        System.out.println("Person 销毁成功");
        throw new Exception("abc");
    }

    @Override
    public String toString(){
        return "姓名:" + name + " 年龄:" + age;
    }
}

public class RuntimeDemo {
    public static void main(String[] args){
        Runtime runtime = Runtime.getRuntime();
        System.out.println("最大内存大小:" + runtime.maxMemory()/1024/1024);
        System.out.println("总共内存大小:" + runtime.totalMemory()/1024/1024);
        System.out.println("空闲内存大小:" + runtime.freeMemory()/1024/1024);

        String str = "";
        for (int i = 0; i < 1000; i ++){
            str = str + i;
        }

        System.out.println("================================================");
        System.out.println("最大内存大小:" + runtime.maxMemory()/1024/1024);
        System.out.println("总共内存大小:" + runtime.totalMemory()/1024/1024);
        System.out.println("空闲内存大小:" + runtime.freeMemory()/1024/1024);

        runtime.gc();
        System.out.println("================================================");
        System.out.println("最大内存大小:" + runtime.maxMemory()/1024/1024);
        System.out.println("总共内存大小:" + runtime.totalMemory()/1024/1024);
        System.out.println("空闲内存大小:" + runtime.freeMemory()/1024/1024);

        PersonInfo personInfo = new PersonInfo("张三", 123);
        personInfo = null;
        runtime.gc();
    }
}
