import jdk.internal.util.xml.impl.Input;

import java.io.*;

/**
 * Created by windvalley on 2018/3/2.
 */
public class JavaIODemo {
    public static void main(String[] args) throws IOException {
        String source = "D:" + File.separator + "level" + File.separator + "streamOutput.txt";
        String target = "D:" + File.separator + "level" + File.separator + "streamOutputBk1.txt";

        int errCode = copyFile(source, target);

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
