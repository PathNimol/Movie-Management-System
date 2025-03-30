package Test;
import java.util.Scanner;
import java.util.ArrayList;
public class Intrr {
    public static void main(String[] args) {
        int b = 0;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.print("Enter the size of array from 1-15: ");
            int size = scanner.nextInt();
            int sizeArray = 0;
            int a[] = new int[sizeArray];
            a[sizeArray] = size++;
            System.out.println(a[sizeArray]);

            if(size >5){
                break;
            }
            sizeArray++;
            b++;
        }while(b < 5);
    }
}