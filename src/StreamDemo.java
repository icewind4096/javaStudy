import java.io.*;

/**
 * Created by windvalley on 2018/3/1.
 */
public class StreamDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("d:" + File.separatorChar + "level" + File.separatorChar + "streamOutput.txt");

        writerTest(file);

//        streamOverWriteTest(file);
//        streamAppendTest(file);
        readTest(file);
    }

    private static void writerTest(File file) throws IOException {
        if (file.getParentFile().exists() == false){
            file.getParentFile().mkdirs();
        }

        Writer writer = new FileWriter(file);
        writer.write("ABC");
        writer.append("中国红");
        writer.close();
    }

    private static void readTest(File file) throws IOException {
        if (file.exists() == true) {
            InputStream inputStream = new FileInputStream(file);
            if (file.length() > 0) {
                int length = (int) file.length();
                byte[] bytes = new byte[length - 1];
                inputStream.read(bytes);
                String text = new String(bytes);
                System.out.println(text);
            }
            inputStream.close();
        }
    }

    private static void streamAppendTest(File file) throws IOException {
        //判断目录是否存在,必须
        if (file.getParentFile().exists() == false){
            file.getParentFile().mkdirs();
        }

        OutputStream outputStream = new FileOutputStream(file, true);
        String msg = "12345";
        outputStream.write(msg.getBytes());
        outputStream.close();
    }

    private static void streamOverWriteTest(File file) throws IOException {
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
