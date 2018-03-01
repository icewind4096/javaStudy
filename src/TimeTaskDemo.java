import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by windvalley on 2018/2/27.
 */

class MyTask extends TimerTask{
    @Override
    public void run() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        System.out.println("当前时间" + simpleDateFormat.format(new Date()));
    }
}

public class TimeTaskDemo {
    public static void main(String[] args){
        Timer timer = new Timer();
        timer.schedule(new MyTask(), 1000, 5000); //延时一秒后执行,每5000执行一次
    }
}
