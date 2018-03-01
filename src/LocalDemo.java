import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by windvalley on 2018/2/26.
 */
public class LocalDemo {
    public static void main(String[] args){
        Locale localeA = new Locale("zh", "CN");
        System.out.println(localeA.toString());

        Locale localeB = Locale.getDefault();
        System.out.println(localeB.toString());

        Locale localeC = Locale.CANADA;
        System.out.println(localeC.toString());

        ResourceBundle resourceBundle = ResourceBundle.getBundle("Message");
        //带入形参,占位符在Message.properties中定义
        System.out.println(MessageFormat.format(resourceBundle.getString("fruit.cn"), 12));
        System.out.println(MessageFormat.format(resourceBundle.getString("fruit.en"), 34));
    }

}
