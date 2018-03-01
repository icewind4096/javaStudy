/**
 * Created by mecwa on 2018/2/17.
 */

class MyRunnAble implements Runnable{
    private String name;
    public MyRunnAble(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i ++){
            System.out.println("Name:" + name + "-" + String.valueOf(i));
        }
    }
}

public class RunnAbleDemo {
    public static void main(String[] args){
        Thread myRunnAbleA = new Thread(new MyRunnAble("A"));
        Thread myRunnAbleB = new Thread(new MyRunnAble("B"));
        Thread myRunnAbleC = new Thread(new MyRunnAble("C"));
        myRunnAbleA.start();
        myRunnAbleB.start();
        myRunnAbleC.start();
    }
}
