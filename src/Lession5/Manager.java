package Lession5;

import Lession4.Static.Employee;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Created by MMNJ005 on 2018/2/28.
 */
public class Manager extends Employee {
    private double bonus = 0;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getSalary() {
        //调用父类的getSaleary方法，要不程序会不断调用manager里的getSaleary方法，直至系统崩溃
        return super.getSalary() + getBonus();
    }

    @Override
    public String toString() {
        return super.toString() + " Bounds:" + getBonus();
    }

    public static void main(String[] args){
        Manager manager = new Manager( "李四",1000.00, 2000, 10, 11);
        Employee employeeA = new Employee( "张三",2000.00, 2010, 10, 11);
        Employee employeeB = manager;

        if (employeeA instanceof Manager){
            System.out.println("true");
        }

        System.out.println(manager.toString());
        System.out.println(employeeA.toString());
        System.out.println(employeeB.toString());
        manager.setBonus(100);
        System.out.println(manager.toString());
        System.out.println(employeeA.toString());
        System.out.println(employeeB.toString());
    }
}
