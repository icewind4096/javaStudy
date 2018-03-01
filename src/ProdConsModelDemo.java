import static java.lang.Thread.sleep;

/**
 * Created by mecwa on 2018/2/19.
 */

class Info {
    private String title;
    private String content;
    private boolean flag = true;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public synchronized void setInfo(String title, String content){
        if (flag == false){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        setTitle(title);
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setContent(content);
        flag = false;
        super.notify();
    }

    public synchronized void getInfo(){
        if (flag == true){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getTitle() + "-------->" + getContent());
        flag = true;
        super.notify();
    }
}

class Procedure implements Runnable{
    private Info info;

    public Procedure(Info info){
        this.info = info;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i ++){
            if (i % 2 == 0){
                info.setInfo("A", "偶数" + "----->" + i);
            }
            else {
                info.setInfo("B", "奇数" + "----->" + i);
            }
        }
    }
}

class Consumer implements Runnable{
    private Info info;

    public Consumer(Info info){
        this.info = info;
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i ++){
            info.getInfo();
        }
    }
}

public class ProdConsModelDemo {
    public static void main(String[] args){
        Info info = new Info();
        Procedure procedure = new Procedure(info);
        Consumer consumer = new Consumer(info);
        new Thread(procedure).start();
        new Thread(consumer).start();
    }
}
