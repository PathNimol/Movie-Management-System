package Array;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest {
    public static void main(String[] args) {
        // * * * * *
        // * * * *
        // * * *
        // * *
        // *

        for(int i= 5; i >0; i--){
            for(int a = 0; a < i; a ++){
                System.out.print("* ");
            }
            System.out.println();
        }

        String m = "*";
        for(int r = 0; r < 5; r++) {
            for(int s = 5; s >r; s--){
                System.out.print(" ");
            }
            for (int i = 0; i < r+1; i++) {
                System.out.print("* ");
                m += "*";
            }
            System.out.println();
        }
        // *
        // * *
        // * * *
        // * * * *
        // * * * * *
        System.out.print("1. Pyramid pattern");
        System.out.print("2. Right Triangle Star Pattern");
        System.out.println("3. Left Triangle Star Pattern");
    }
}