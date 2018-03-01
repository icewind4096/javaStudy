import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by windvalley on 2018/2/22.
 */
public class DateTimeDemo {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        long num = date.getTime();
        System.out.println(num);
        System.out.println(new Date(num * 1));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String strDate = simpleDateFormat.format(date);
        System.out.println(strDate);

        strDate = "1976-11-14 13:14:15.160";
        date = simpleDateFormat.parse(strDate);
        System.out.println(date);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1976);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(calendar.get(Calendar.YEAR)).append("年");
        stringBuilder.append(calendar.get(Calendar.MONTH) + 1).append("月"); //以0开始
        stringBuilder.append(calendar.get(Calendar.DAY_OF_MONTH)).append("日");
        System.out.println(stringBuilder);
    }
}
