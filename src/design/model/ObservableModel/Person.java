package design.model.ObservableModel;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by windvalley on 2018/2/27.
 */
public class Person implements Observer {       //人们观测房价
    private String name;
    public Person(String name){
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof House){        //房子信息发生变化
            if (arg instanceof Double) {
                System.out.println("房价变化 =" + (double) arg);
            }
        }
        System.out.println(o.getClass() + this.name);
        System.out.println(arg.getClass());
    }
}
