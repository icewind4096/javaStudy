import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by windvalley on 2018/2/28.
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        fileTest();
        directoryListTest("D:\\");
    }

    private static void directoryListTest(String Direcotry) {
        directorySearch(new File(Direcotry), 0);
    }

    private static void directorySearch(File file, int level) {
        System.out.println(file);
        if (file.isDirectory() == true) {
            File[] files = file.listFiles();
            if (files != null){
                for (int i = 0; i < files.length; i++) {
                    directorySearch(files[i], level + 1);
                }
            }
        }
    }

    //File 有2个构造方法
    //目录存在以后才可以建立文件
    private static void fileTest() throws IOException {
        File file = new File("d:" + File.separator + "level1" + File.separator + "level2" + File.separator + "1.txt");
        //父路径不存在, 用mkdirs建立多级目录, mkDir建立单级目录
        //getParentFile就是getDirectory
        if (file.exists() == true){
            System.out.println("file not exists");
            file.createNewFile();
        }

        if (file.getParentFile().exists() == false){
            file.getParentFile().mkdirs();
        }
        if (file.isDirectory() == true){
            System.out.println("file is directory");
        }

        System.out.println("文件长度:" + file.length());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss.SSS");
        System.out.println("文件修改日期:" + simpleDateFormat.format(new Date(file.lastModified())));
    }
}
