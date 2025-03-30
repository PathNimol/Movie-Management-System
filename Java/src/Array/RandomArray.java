package Array;
import java.util.Random;
import java.util.Scanner;
public class RandomArray {
    public static void main(String[] args) {
        int a [][] = {{4, 2, 8, 5}, {9, 0, 3, 7}, {}, {}};
        Random random = new Random();
        for (int  i = 0; i < a.length; i++) {
            int maxRow = a[i][0];
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = (int)(Math.random() * 99);
                if (a[i][j] > maxRow) {
                    maxRow = a[i][j];
                }
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
            
        }
    }
}
