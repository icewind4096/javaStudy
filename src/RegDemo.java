/**
 * Created by windvalley on 2018/2/25.
 * A -> 单字符
 * a    : 匹配指定的字母
 * \\   : 匹配"\"转义字符
 * \t   : 匹配"tab"
 * \n   : 匹配换行
 *
 * B -> 字符范围
 * [abc] : 表示是a,b,c中任意一个用[]
 * [^abc]: 表示不是a,b,c中任意一个用[]
 * [a-zA-Z]:表示由任意一位字母(大写或小写)组成
 * [0-9]:表示由任意一位数字组成
 *
 * C -> 简化表达式
 * .    : 任意一位字符
 * \d   : 任意一位数字,等价于[0-9];
 * \D   : 任意一位非数字,等价于[^0-9];
 * \w   : 任意一位字符,由字母 数字 "_" 组成,等价于[a-zA-Z0-9_];
 * \W   : 任意一位非字符,不是由字母 数字 "_" 组成,等价于[^a-zA-Z0-9_];
 * \s   : 任意一位空格, 可能是/t /n
 * \S   : 任意一位非空格
 *
 * D -> 边界匹配
 * ^    : 表示正则匹配开始 //java中用不到
 * $    : 表示正则匹配结束
 *
 * E -> 量词描述
 * 表达式?: 表示可以出现0次或1次
 * 表达式+: 表示可以出现1次或n次
 * 表达式*: 表示可以出现0, 1次或n次
 * 表达式{n}: 表示正好出现n次
 * 表达式{n,}: 表示正好出现n次以上(包含n次)
 * 表达式{n,m}: 表示正好出现n次-m次
 *
 * F -> 逻辑运算
 * X正则Y正则: 表示X正则后紧跟着验证Y正则
 * X正则｜Y正则: 表示X正则与Y正则选一个
 * (): 一组正则
 **/
public class RegDemo {
    public static void main(String[] args) {
        matchDouble();
        matchDate();
        matchPhone();
        matchEMail();
    }

    private static void matchEMail() {
        String string = "icewind4096@gmail.com";

        /** 复杂匹配
         * [a-zA-Z]
         * [a-zA-Z0-9_\\-\\.]{5,29}
         * @
         * [a-zA-Z0-9_\\-\\.]+
         * \\.
         * (com|cn|gov|edu)
         */


        /**
         * 简单匹配
         * \\w+
         * @
         * \\w+
         * \\.
         * \\w+
         */
        String simpRegx = "\\w+@\\w+\\.\\w+";
        if (string.matches(simpRegx) == true){
            System.out.println("email success");
        } else {
            System.out.println("email fail");
        }
    }

    private static void matchPhone() {
        String string = "62350411";     //010-62350411 (010)-62350411

        /**
         \\d{7,8})
         \\d{3,4}\\d{7,8}
         \\(d{3,4}-?)\\d{7,8}       "-"是依附于区号出现的,所以是?出现0次或1次 010-62350411
         \\(\\(d{3,4}\\)-?)\\d{7,8}
         **/

        //String regx = "(((\\d{3,4}-?)|(\\(\\d{3,4}\\)-?))\\d{7,8})|(\\d{7,8})";
        String regx = "((\\d{3,4}-?)|(\\(\\d{3,4}\\)-?))?\\d{7,8}";
        if (string.matches(regx) == true){
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
    }

    private static void matchDate() {
        String string = "2018-12-12";

        /**
        (?!0000)
         [0-9]{4}
         -
         (
         (0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-8]) //每月可以保证28天
         |
         (0[13-9]|1[0-2])-(29|30)               //30天的月
         |
         (0[13578]|1[02])-31                    //31天的月
         )

         **/

        String regx = "-?\\d+(\\.\\d+)?";
        if (string.matches(regx) == true){
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
    }

    private static void matchDouble() {
        String string = "-10.123";
        // 10-> \\d+
        // .2-> (\\.\\d+}?
        String regx = "-?\\d+(\\.\\d+)?";
        if (string.matches(regx) == true){
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
    }
}
