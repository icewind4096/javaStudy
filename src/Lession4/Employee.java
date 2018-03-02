package Lession4;

import java.time.LocalDate;

/**
 * Created by MMNJ005 on 2018/2/27.
 */
public class Employee{
    private static int nextId = 1;
    private int id;

    private String name;
    private double salary;
    private LocalDate hireDay;

    //static init block
    static {
        //和类成员变量一样只会被调用一次,所有类共享一次
        System.out.println("Call static Init block");
    }

    //object init block
    {
        System.out.println("Call Init block");
    }

    /*
    Employee构造器
    @paramater nexid  下一个ID
    @paramater name   名称
    @paramater salary 工资
     */
    public Employee(String name, double salary, int year, int month, int day){
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public Employee(){
        this.name = "Default";
        this.salary = 100;
        hireDay = LocalDate.of(1000, 1,1);
    }

    public static int getNextId() {
        return nextId;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = nextId;
        nextId = nextId + 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary = salary + raise;
    }

    @Override
    public String toString() {
        return "Address@" + super.toString() + "ID:" + getId() + "Name:" + getName() + " HireDay:" + getHireDay() + " Salary:" + getSalary();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null) return false;

        if (getClass() != obj.getClass()) return false;

        Employee employee = (Employee) obj;

        return getName().equals(employee.getName())
            && getSalary() == employee.getSalary()
            && getHireDay() == employee.getHireDay();
    }
}
