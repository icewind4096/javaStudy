import java.io.*;

/**
 * Created by windvalley on 2018/3/1.
 */
public class StreamDemo {
    public static void main(String[] args) throws IOException {
        streamOverWriteTest();
        streamAppendTest();
        charTest();
    }

    private static void charTest() {
    }

    private static void streamAppendTest() throws IOException {
        File file = new File("d:" + File.separatorChar + "level" + File.separatorChar + "streamOutput.txt");

        //判断目录是否存在,必须
        if (file.getParentFile().exists() == false){
            file.getParentFile().mkdirs();
        }

        OutputStream outputStream = new FileOutputStream(file, true);
        String msg = "12345";
        outputStream.write(msg.getBytes());
        outputStream.close();
    }

    private static void streamOverWriteTest() throws IOException {
        File file = new File("d:" + File.separatorChar + "level" + File.separatorChar + "streamOutput.txt");

        //判断目录是否存在,必须
        if (file.getParentFile().exists() == false){
            file.getParentFile().mkdirs();
        }

        OutputStream outputStream = new FileOutputStream(file);
        String msg = "abcdefg";
        outputStream.write(msg.getBytes(), 2, 3);
        outputStream.write(msg.getBytes());
        outputStream.close();
    }
}
