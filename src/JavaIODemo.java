import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by windvalley on 2018/3/2.
 */
public class JavaIODemo {
    public static void main(String[] args) throws IOException {
        copyFileDemo();
        //1.5以前实现方法
        //keyboardInputDemo();
        //1.5以后实现方法
        keyboardScannerDemo();
    }

    //默认用空格和换行默认是分隔符
    private static void keyboardScannerDemo() {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入:");
//        scanner.hasNext();
//        System.out.println(scanner.next());

        //要求输入生日 scanner支持正则表达式
        System.out.println("请输入日期:");
        if (scanner.hasNext("\\d{4}-\\d{2}-\\d{2}") == true){
            System.out.println(scanner.next("\\d{4}-\\d{2}-\\d{2}"));
        } else {
            System.out.println("失败");
        }
    }

    private static void keyboardInputDemo() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入:");
        String string = bufferedReader.readLine();
        System.out.print(string);
    }

    private static void copyFileDemo() throws IOException {
        int errCode = copyFile("D:" + File.separator + "level" + File.separator + "streamOutput.txt"
                              ,"D:" + File.separator + "level" + File.separator + "streamOutputBk1.txt");
        switch (errCode){
            case -1: System.out.println("源文件不存在");
                break;
            case -2: System.out.println("目标文件已存在");
                break;
            case  1: System.out.println("拷贝文件成功!");
        }
    }

    private static int copyFile(String fileNameS, String fileNameT) throws IOException {
        if(checkFileExists(fileNameS) == false) return -1;

        if (checkFileExists(fileNameT) == true) return -2;

        InputStream inputStream = new FileInputStream(fileNameS);
        OutputStream outputStream = new FileOutputStream(fileNameT);
        byte[] bytes = new byte[1024];
        while (true){
            int length = inputStream.read(bytes, 0, bytes.length);
            if (length >= 0){
                outputStream.write(bytes, 0, length);
            }
            else {
                break;
            }
        }
        return 1;
    }

    private static boolean checkFileExists(String fileName) {
        return new File(fileName).exists();
    }
}
