package Lession4;

/**
 * Created by MMNJ005 on 2018/2/27.
 */

public class StaticTest {
    public static void main(String[] args){
        Employee[] employees = new Employee[3];

        employees[0] = new Employee("张三", 1000, 1990, 12, 13);
        employees[1] = new Employee( "李四", 2000, 2000, 11,12);
        employees[2] = new Employee( "王五", 3000, 2010, 01,02);

        for (Employee employee: employees){
            employee.setId();
            System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getSalary() + " " + employee.getHireDay());
            System.out.println("Next available id = " + Employee.getNextId());
        }
    }
}
