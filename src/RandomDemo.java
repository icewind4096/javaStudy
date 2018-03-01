import java.util.Random;

/**
 * Created by windvalley on 2018/2/23.
 */
public class RandomDemo {
    public static void ch(int temp[]){
        int index = 0;
        Random random = new Random();
        while (index < 7){
            int num = random.nextInt(37);
            if (num !=0 && isExist(num, temp) == false){
                temp[index] = num;
                index = index + 1;
            }
        }
    }

    private static boolean isExist(int num, int[] temp) {
        for (int i = 0; i < temp.length; i ++){
            if (temp[i] == num){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int data[] = new int[7];
        ch(data);
        java.util.Arrays.sort(data);
        for (int i = 0; i < data.length; i ++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();


        Random random = new Random();
        for (int i = 0; i < 10; i ++){
            System.out.println(random.nextInt(100));
        }

        random.setSeed(1);
        for (int i = 0; i < 10; i ++){
            System.out.println(random.nextInt(37));
        }
    }
}
