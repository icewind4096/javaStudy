package Lession4.Static;

/**
 * Created by MMNJ005 on 2018/2/27.
 */
public class ParamTest {
    public static void main(String[] args){
        //演示基本数据类型参数调用以后不会被修改
        System.out.println( "Test tripleValue:");
        double percent = 10;
        System.out.println("Before: percent=" + percent);
        tripleValue(percent);
        System.out.println("After: percent=" + percent);

        //演示对象数据类型参数调用以后值会被修改
        System.out.println("\n Testing tripleSalary:");
        Employee harry = new Employee("张三", 1000, 1990, 21, 22);

        System.out.println("Before: address@" + harry.toString());
        System.out.println("Before: salary=" + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: address@" + harry.toString());
        System.out.println("After: salary=" + harry.getSalary());

        //JAVA的对象参数传递其实还是按值传递
        System.out.println("\n Testing swap object");
        Employee employeeA = new Employee("Employee-A", 5000, 1990, 21, 22);
        Employee employeeB = new Employee("Employee-B", 10000, 2000, 11, 12);
        System.out.println("After: address-A@" + employeeA.toString() + " address-B@" + employeeB.toString());
        System.out.println("Before: A Name:" + employeeA.getName());
        System.out.println("Before: B Name:" + employeeB.getName());
        swap(employeeA, employeeB);
        System.out.println("After: A Name:" + employeeA.getName());
        System.out.println("After: B Name:" + employeeB.getName());
        System.out.println("After: address-A@" + employeeA.toString() + " address-B@" + employeeB.toString());
    }

    private static void swap(Employee employeeA, Employee employeeB) {
        Employee temp = employeeA;
        employeeA = employeeB;
        employeeB = temp;
        System.out.println("Method: A Name:" + employeeA.getName());
        System.out.println("Method: B Name:" + employeeB.getName());
        System.out.println("Method: address-A@" + employeeA.toString() + " address-B@" + employeeB.toString());
    }

    private static void tripleSalary(Employee harry) {
        harry.raiseSalary(200);
        System.out.println("End of method: salary = " + harry.getSalary());
    }

    private static void tripleValue(double percent) {
        percent = percent * 3;
        System.out.println("End of method: percent = " + percent);
    }
}
