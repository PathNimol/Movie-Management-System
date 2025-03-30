package AUB_Java_I;

import java.util.Scanner;

public class myString {
    public static void main(String[] args) {
        //Calculate the roots of square
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value a: ");
        double a = sc.nextDouble();
        System.out.print("Enter value b: ");
        double b = sc.nextDouble();
        System.out.print("Enter value c: ");
        double c = sc.nextDouble();

        double discriminant = (b * b) - (4 * a * c);
        System.out.println("Discriminant: " + discriminant);

        if(discriminant > 0){
            double r1 = (-b + (Math.sqrt(discriminant)) / 2*a);
            double r2 = (-b - (Math.sqrt(discriminant)) / 2*a);
            System.out.println("R1 = " + r1 + " R2 = " + r2);
        }
        else if(discriminant == 0){
            double r = -b/(2 * a);
            System.out.println("R = " + r);
        }
        else {
            System.out.println("The equation has no real roots!");
        }
    }
}