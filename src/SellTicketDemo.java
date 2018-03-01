import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by mecwa on 2018/2/18.
 */

class MySellTicketCallable implements Callable<String>{
    private int tickCount = 5;

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i ++){
            if (tickCount > 0) {
                tickCount = tickCount - 1;
                System.out.println(" 还有" + tickCount + "票");
            } else {
                System.out.println("没有票了");
            }
        }
        return "票买完了";
    }
}

class MySelllTicketRunnable implements Runnable{
    private int tickCount = 5;

    @Override
    public void run() {
        for (int i = 0; i < 10; i ++){
            if (tickCount > 0) {
                tickCount = tickCount - 1;
                System.out.println(Thread.currentThread().getName() +  " 还有" + tickCount + "票");
            } else {
                System.out.println("没有票了");
            }
        }
    }
}

class MySelllTicketThread extends Thread{
    private static int tickCount = 5;
    private String name;

    public MySelllTicketThread(String name){
        this.name = name;
    }

    @Override
    public void run(){
        for (int i = 0; i < 10; i ++){
            synchronized(this) {
                if (tickCount > 0) {
                    tickCount = tickCount - 1;
                    System.out.println(name + " 还有" + tickCount + "票");
                } else {
                    System.out.println("没有票了");
                }
            }
        }
    }
}

public class SellTicketDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MySelllTicketThread mySelllTicketThread1 = new MySelllTicketThread("A");
        MySelllTicketThread mySelllTicketThread2 = new MySelllTicketThread("B");
        MySelllTicketThread mySelllTicketThread3 = new MySelllTicketThread("C");
        mySelllTicketThread1.start();
        mySelllTicketThread2.start();
        mySelllTicketThread3.start();



        Callable<String> mySellTicketCallable = new MySellTicketCallable();
        FutureTask<String> futureTask = new FutureTask<String>(mySellTicketCallable);
        Thread myThreadCallable = new Thread(futureTask);
        myThreadCallable.start();
        System.out.println(futureTask.get());


        MySelllTicketRunnable mySelllTicketThread = new MySelllTicketRunnable();
        new Thread(mySelllTicketThread).start();
        new Thread(mySelllTicketThread).start();
        new Thread(mySelllTicketThread).start();
    }
}
