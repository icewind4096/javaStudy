/**
 * Created by mecwa on 2018/2/17.
 */

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10000; i ++){
            System.out.println(String.valueOf(i));
        }
    }
}
public class ThreadDemo {
    public static void main(String[] args){
        MyThread myThread = new MyThread();
        for (int i = 0; i < 10000; i ++){
            System.out.print("Main Process");
            if (i == 0){
                myThread.start();
            }
        }
    }
}
