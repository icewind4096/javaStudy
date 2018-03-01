import static java.lang.Thread.sleep;

/**
 * Created by mecwa on 2018/2/19.
 */

class SyncSellTicketBlock implements Runnable{
    private int tickCount = 5;

    @Override
    public void run() {
        for (int i = 0; i < 10; i ++){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (tickCount > 0) {
                    System.out.println(Thread.currentThread().getName() + " 剩余票数: " + tickCount);
                    tickCount = tickCount - 1;
                } else {
                    System.out.println(Thread.currentThread().getName() + " 没有票了 ");
                }
            }
        }
    }
}

class SyncSellTicketFunc implements Runnable{
    private int tickCount = 5;

    @Override
    public void run() {
        for (int i = 0; i < 10 ; i ++){
            sale();
        }
    }

    private synchronized void sale() {
        if (tickCount > 0) {
            System.out.println(Thread.currentThread().getName() + " 剩余票数: " + tickCount);
            tickCount = tickCount - 1;
        } else {
            System.out.println(Thread.currentThread().getName() + " 没有票了 ");
        }
    }
}

public class SyncDemo {
    public static void main(String[] args){
        SyncSellTicketBlock syncSellTicket = new SyncSellTicketBlock();
        new Thread(syncSellTicket).start();
        new Thread(syncSellTicket).start();
        new Thread(syncSellTicket).start();

        SyncSellTicketFunc syncSellTicketFunc = new SyncSellTicketFunc();
        new Thread(syncSellTicketFunc).start();
        new Thread(syncSellTicketFunc).start();
        new Thread(syncSellTicketFunc).start();
    }
}
