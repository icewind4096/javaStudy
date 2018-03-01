import java.io.*;

/**
 * Created by windvalley on 2018/3/1.
 * 字节数出/输出 outputstream/inputstream
 * 字符输出/输出 fileReader/fileWriter
 * 转换流 InputStreamRead/OutputStreamWriter;
 */
public class StreamDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("d:" + File.separatorChar + "level" + File.separatorChar + "streamOutput.txt");

        writerTest(file);
        readerTest(file);

//        streamOverWriteTest(file);
//        streamAppendTest(file);
        readStreamTest(file);
    }

    private static void readerTest(File file) throws IOException {
        if (file.exists() == true){
            Reader reader = new FileReader(file);
            char[] buffer = new char[1024];
            while (true) {
                int count = reader.read(buffer);
                if (count >= 0){
                    System.out.println(new String(buffer, 0, count));
                }
                else {
                    break;
                }
            }
            reader.close();
        }
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

    private static void readStreamTest(File file) throws IOException {
        if (file.exists() == true) {
            InputStream inputStream = new FileInputStream(file);
            if (file.length() > 0) {
                int length = (int) file.length();
                byte[] bytes = new byte[length];
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
