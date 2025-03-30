package Test;

import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
     System.out.println("******______Calculator______******");
     System.out.println("1.  Addition");
     System.out.println("2.  Subtraction");
     System.out.println("3.  Multiplication");
     System.out.println("4.  Division");
     System.out.println("0.  Exit");

        Scanner inputNum = new Scanner(System.in);
        System.out.print("Please choose an option: ");
        int option = inputNum.nextInt();

        int num1, num2, result;
        switch(option){
            case 1:
                System.out.println("1. Addition");
                System.out.print("Number 1: " );
                num1 = inputNum.nextInt();
                System.out.print("Number 2: " );
                num2 = inputNum.nextInt();
                result = num1 + num2;
                System.out.println(num1 +" + " +num2 + " = "+ result);
                break;
            case 2:
                System.out.println("2. Subtraction");
                System.out.print("Number 1: ");
                num1 = inputNum.nextInt();
                System.out.print("Number 2: ");
                num2 = inputNum.nextInt();
                result = num1 - num2;
                System.out.println(num1 +" - " +num2 + " = "+ result);
                break;
            case 3:
                System.out.println("3. Multiplication");
                System.out.print("Number 1: ");
                num1 = inputNum.nextInt();
                System.out.print("Number 2: ");
                num2 = inputNum.nextInt();
                result = num1 * num2;
                System.out.println(num1 +" × " +num2 + " = "+ result);
                break;
            case 4:
                System.out.println("4. Division");
                System.out.print("Number 1: ");
                num1 = inputNum.nextInt();
                System.out.print("Number 2: ");
                num2 = inputNum.nextInt();
                result = num1 / num2;
                System.out.println(num1 +" ÷ " +num2 + " = "+ result);
                break;
            case 0:
                System.out.println("==============EXIT==============");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }
}
