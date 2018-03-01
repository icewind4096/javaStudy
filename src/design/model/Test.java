package design.model;

import design.model.ObservableModel.House;
import design.model.ObservableModel.Person;
import design.model.SingletonModel.Singleton;

/**
 * Created by windvalley on 2018/2/26.
 */
public class Test {
    public static void main(String[] args){
        singletonDemo();
        observableModel();
    }

    private static void observableModel() {
        House house = new House(3000000.00);    //被观察者
        Person personA = new Person("张三");    //观察房价的人
        Person personB = new Person("李四");    //观察房价的人
        Person personC = new Person("王五");    //观察房价的人
        house.addObserver(personA);
        house.addObserver(personB);
        house.addObserver(personC);
        house.setPrice(50.0);
    }

    private static void singletonDemo() {
        Singleton singletonA = Singleton.getInstance();
        Singleton singletonB = Singleton.getInstance();
        if (singletonA == singletonB){
            System.out.println("same");
        }
        else {
            System.out.println("not same");
        }
    }
}
