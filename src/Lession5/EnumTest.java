package Lession5;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Created by MMNJ005 on 2018/3/1.
 */
enum Size {
    //四个实例,切记
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    private String abbreviation;

    private Size(String abbreviation){
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation(){
        return abbreviation;
    }
}

public class EnumTest{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a size :(SMALL, MEDIUM, LARGE, EXTRA_LARGE");
        String input = scanner.next().toUpperCase();
        Size size = Size.valueOf(Size.class, input);
        System.out.println("abbreviation=" + size.getAbbreviation());
        if (size == Size.EXTRA_LARGE){
            System.out.println("Good job -- you paid attention to the .");
        }
    }
}