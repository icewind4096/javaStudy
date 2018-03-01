/**
 * Created by windvalley on 2018/2/22.
 */
class MyMath{
    public  static double round(double num, int scale){
        return Math.round(num * Math.pow(10.0, scale))/Math.pow(10.0, scale);
    }
}

public class MathDemo {
    public static void main(String[] args){
        System.out.println(Math.round(12345.6789));
        System.out.println(Math.round(15.51));
        System.out.println(Math.pow(10.00, 5));
        System.out.println(MyMath.round(10.9789, 2));
    }
}
