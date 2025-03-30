package Test;

import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {
        int i, num;
        do {
            System.out.println();
            Scanner input = new Scanner(System.in);
            System.out.println("☛ tEven or Odd Checker ☚");
            System.out.println("① Press 1 to check the number!");
            System.out.println("⓪ Press 0 to Exit!");
            i = input.nextInt();
            switch (i) {
                case 1:
                    System.out.print("Enter an integer: ");
                    num = input.nextInt();
                    if (num % 2 == 0) {
                        System.out.println(num + " is even");
                    }
                    else {
                        System.out.println(num + " is odd");
                    }
                    break;
               case 0:
                   System.out.println("Goodbye! See you next time!");
                   System.exit(0);
                   break;
               default:
                   System.out.println("Wrong input!");
                   break;
            }

        }while (i != 0);
    }
}
