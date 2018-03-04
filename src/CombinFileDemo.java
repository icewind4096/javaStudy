import java.io.*;

/**
 * Created by windvalley on 2018/3/4.
 */
public class CombinFileDemo {
    public static void main(String[] args) throws IOException {
        String fileNameA = "D:" + File.separatorChar + "level" + File.separatorChar + "streamOutputA.txt";
        String fileNameB = "D:" + File.separatorChar + "level" + File.separatorChar + "streamOutputB.txt";
        String fileName = "D:" + File.separatorChar + "level" + File.separatorChar + "streamOutput.txt";
        combinFile(fileNameA, fileNameB, fileName);
    }

    private static int combinFile(String fileNameA, String fileNameB, String fileName) throws IOException {
        File fileA = new File(fileNameA);
        File fileB = new File(fileNameB);

        OutputStream outputStream = new FileOutputStream(new File(fileName));

        if (outFile(outputStream, fileA) == false || outFile(outputStream, fileB) == false){
            outputStream.close();
            return 0;
        }
        else {
            outputStream.close();
            return 1;
        }
    }

    private static boolean outFile(OutputStream targretFile, File sourceFile) throws IOException {
        byte[] bytes = new byte[1024];

        InputStream fileInputStream = new FileInputStream(sourceFile);

        while (true){
            int length = fileInputStream.read(bytes);
            if (length >= 0){
                targretFile.write(bytes);
            } else {
                break;
            }
        }

        fileInputStream.close();

        return true;
    }
}
