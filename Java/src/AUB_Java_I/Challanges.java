package AUB_Java_I;

import java.util.Scanner;

public class Challanges {
    public static void  main(String [] args){
        //Challenges 1 if statement
        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the numerator: ");
//        double num1 = sc.nextDouble();
//
//        System.out.println("Enter the denominator: ");
//        double num2 = sc.nextDouble();
//
//        while(num2 !=)
//        //1
//        System.out.print("Input the integer: ");
//        int input = sc.nextInt();
//
//        if(input % 5 == 0)
//            System.out.println("Hi Five!");
//        if(input % 2 == 0)
//            System.out.println("Hi Even!");
//
//        //2
//        int x= 0, y = 5;
//        if(y>0)
//            x+=1;
//        System.out.println("X = " + x);
//
//        //3
//        int pay = 100;
//        System.out.print("Enter your score: ");
//        int score = sc.nextInt();
//        if(score > 90)
//            pay *= 1.03;
//        System.out.println("Payment is: " + pay);
//
//
//        //Calculate the area of circle
//        System.out.print("Enter the radius of circle: ");
//        double radius = sc.nextDouble();
//
//        if (radius > 0.0){
//            double  a = radius * radius * Math.PI;
//        }
//        else {
//            System.out.println("Radius cannot be 0 or negative!");
//        }

        System.out.print("Enter numberator: ");
        double  num1 = sc.nextDouble();
        System.out.print("Enter denominator: ");
        double num2 = sc.nextDouble();

        while (num2 == 0){
            System.out.println("Division by zero is not possible!");
            System.out.println("Please input value of denominator again!");
            System.out.print("Denominator: ");
            num2 = sc.nextDouble();
        }
        double result = num1 / num2;
        System.out.println(num1 + " / " + num2 + " = " + result);
    }
}
