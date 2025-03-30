package AUB_Java_I;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loops {
    public static void main(String[] args) {
        //=====================| While Loop |================
        // 1. Sum numbers from 1 to 10
//        int n = 1, sum = 0;
//        while (n <= 10) {
//            sum += n;
//            n++;
//        }
//        System.out.println("Sum from 1 to 10: " + sum);

        // 2. Sum odd and even numbers
//        int n, sumEven = 0, sumOdd = 0, numberInput = 1;
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter a value of n: ");
//        n = scanner.nextInt();
//        while (numberInput <= n) {
//            if(numberInput % 2 == 0) {
//                sumEven += numberInput;
//            }
//            if(numberInput % 2 != 0) {
//                sumOdd += numberInput;
//            }
//            numberInput++;
//        }
//        System.out.println("Sum from 1 to " + n);
//        System.out.println("================================");
//        System.out.println("Sum of even numbers: " + sumEven);
//        System.out.println("Sum of odd numbers: " + sumOdd);
        //=====================| Do-While Loop |================
//        Scanner input = new Scanner(System.in);
//        int sum = 0;
//        int choice;
//        System.out.println("Enter number to sum: ");
//        do {
//            int num = input.nextInt();
//            sum += num;
//            System.out.println("Sum: " + sum);
//            System.out.println("If you want to break these sum type 0!");
//            choice = input.nextInt();
//        } while (choice == 0);
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"; // Simple email regex
        String email = "example@test.com";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            System.out.println(email + " is a valid email address.");
        } else {
            System.out.println(email + " is not a valid email address.");
        }
    }
}
