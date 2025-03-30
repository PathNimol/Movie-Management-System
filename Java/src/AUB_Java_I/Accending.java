package AUB_Java_I;
import java.util.Scanner;

public class Accending {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value1: ");
        int val1 = sc.nextInt();
        System.out.println("Enter value2: ");
        int val2 = sc.nextInt();
        System.out.println("Enter value3: ");
        int val3 = sc.nextInt();

        System.out.println("Before sort: " + val1 + " " + val2 + " " + val3);
        if (val1 > val2) {
            int temp = val1;
            val1 = val2;
            val2 = temp;
        }
        if (val2 > val3) {
            int temp = val2;
            val2 = val3;
            val3 = temp;
        }
        if (val1 > val2) {
            int temp = val1;
            val1 = val2;
            val2 = temp;
        }

        System.out.println("After sort: " + val1 + " " + val2 + " " + val3);

    }
}
