package JavaClass;

import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String operator1 = "1. ADDITION",
                operator2 = "2. SUBTRACTION",
                operator3 = "3. MULTIPLICATION",
                operator4 = "4. DIVISION",
                operator5 = "5. MODULUS",
                exit = "6. EXIT",
                goodbye = "Good bye!"
                        ;
        int opt;
        double num1, num2, result;
        do{
            System.out.println("\n==========================");
            System.out.println("||   Basic Calculator    ||");
            System.out.println("==========================");

            for(int i = 0; i < operator1.length(); i++ ) {
                System.out.print(operator1.charAt(i));

                try {
                    Thread.sleep(25);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            System.out.println();
            for(int i = 0; i < operator2.length(); i++ ) {
                System.out.print(operator2.charAt(i));

                try {
                    Thread.sleep(25);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            System.out.println();
            for(int i = 0; i < operator3.length(); i++ ) {
                System.out.print(operator3.charAt(i));

                try {
                    Thread.sleep(25);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            System.out.println();
            for(int i = 0; i < operator4.length(); i++ ) {
                System.out.print(operator4.charAt(i));

                try {
                    Thread.sleep(25);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            System.out.println();
            for(int i = 0; i < operator5.length(); i++ ) {
                System.out.print(operator5.charAt(i));

                try {
                    Thread.sleep(25);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            System.out.println();
            for(int i = 0; i < exit.length(); i++ ) {
                System.out.print(exit.charAt(i));

                try {
                    Thread.sleep(25);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println();

            System.out.print("Choose operator: ");
            opt = input.nextInt();

//_________________________________________________________________________________________________

            switch(opt){
                case 1:
                    System.out.println("||   ADDITION    ||");
                    System.out.print("Enter value 1: ");
                    num1 = input.nextDouble();

                    System.out.print("Enter value 2: ");
                    num2 = input.nextDouble();

                    result = num1 + num2;
                    if (result == (int) result) {  // Check if the result is an integer
                        System.out.println("Sum: " + (int) result);
                    } else {
                        System.out.println("Sum: " + result);
                    }
                break;

                case 2:
                    System.out.println("||   SUBTRACT    ||");

                    System.out.print("Enter value 1: ");
                    num1 = input.nextDouble();

                    System.out.print("Enter value 2: ");
                    num2 = input.nextDouble();


                    result = num1 - num2;
                    if (result == (int) result) {  // Check if the result is an integer
                        System.out.println("Sum: " + (int) result);
                    } else {
                        System.out.println("Sum: " + result);
                    }
                    break;

                case 3:
                    System.out.println("||   MULTIPLY    ||");

                    System.out.print("Enter value 1: ");
                    num1 = input.nextDouble();

                    System.out.print("Enter value 2: ");
                    num2 = input.nextDouble();

                    result = num1 - num2;
                    if (result == (int) result) {  // Check if the result is an integer
                        System.out.println("Sum: " + (int) result);
                    } else {
                        System.out.println("Sum: " + result);
                    }
                    break;

                case 4:
                    System.out.println("||   DIVISION    ||");

                    System.out.print("Enter value 1: ");
                    num1 = input.nextDouble();

                    System.out.print("Enter value 2: ");
                    num2 = input.nextDouble();

                    result = num1 / num2;
                    if (result == (int) result) {  // Check if the result is an integer
                        System.out.println("Sum: " + (int) result);
                    } else {
                        System.out.println("Sum: " + result);
                    }
                    break;

                case 5:
                    System.out.println("||   MODULUS    ||");

                    System.out.print("Enter value 1: ");
                    num1 = input.nextDouble();

                    System.out.print("Enter value 2: ");
                    num2 = input.nextDouble();

                    result = num1 % num2;
                    System.out.println("Sum: " + result);

                    break;

                case 6:
                    System.out.print("=================| ");
                    for(int i = 0; i < goodbye.length(); i++ ) {
                        System.out.print(goodbye.charAt(i));

                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(" |=================");
                    break;
                default:
                    System.out.println("Invalid option. Please select 1 to 6.");
                    break;
            }

        }while(opt !=6);

    }
}
