package design.model.ObservableModel;

import java.util.Observable;

/**
 * Created by windvalley on 2018/2/27.
 */
public class House extends Observable {
    private double price;       //房价

    public House(double price){
        setPrice(price);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (this.price > price){            //价格改变,有人关注
            super.setChanged();             //价格已经发生改变
            super.notifyObservers(price);        //通知所有的观察者价格变动了
        }
        this.price = price;
    }
}
