import Lession4.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by windvalley on 2018/3/6.
 */
public class ListDemo {
    public static void main(String[] args){
        baseOperate();
        extOperate();
    }

    private static void extOperate() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("张三", 1000, 1990, 1, 13));
        list.add(new Employee("李四", 2000, 1991, 2, 13));
        list.add(new Employee("王五", 3000, 1992, 3, 13));
        //remove会调用equals方法检测列表中是否存在第一个符合的对象
        list.remove(new Employee("李四", 2000, 1991, 2, 13));
        for (int i = 0; i < list.size(); i ++){
            Employee employee = list.get(i);
            System.out.println(employee.toString());
        }
    }

    private static void baseOperate() {
        List<String> list = new ArrayList<>();
        System.out.println(list.isEmpty());
        list.add("hello");
        list.add("hello");
        list.add("hello");
        System.out.println(list.isEmpty());
        System.out.println(list);
        for (int i = 0; i < list.size(); i ++){
            System.out.println((String) list.get(i));
        }
        System.out.println("长度:" + list.size());

        //由于Collection类没有get方法，get方法是List类实现的，所以只可以导入到数组里操作
        Collection<String> collection = new ArrayList<>();
        collection.add("hello");
        collection.add("hello");
        collection.add("hello");
        Object objects[] = collection.toArray();
        for (int i = 0; i < objects.length; i ++){
            System.out.println((String) objects[i]);
        }
    }
}
