package AUB_Java_I;

import java.util.Scanner;// *Java Program to print pattern *Square hollow pattern

public class MoneyChanging {
    public static void main(String args[] )
    {
        //Money changing from given amount to smaller monetary units
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amounts: ");
        int amount = sc.nextInt();

        int hundred = amount / 100;
        amount = amount % 100;

        int fifty = amount / 50;
        amount = amount % 50;

        int twenty = amount / 20;
        amount = amount % 20;

        int ten = amount / 10;
        amount = amount % 10;

        int two = amount / 2;
        amount = amount % 2;


        int one = amount;

        System.out.println(
                "100 dollars =: " + hundred +
                "\n50 dollars =: " + fifty +
                "\n20 dollars =: " + twenty +
                "\n10 dollars =: " + ten +
                "\n2 dollars =: " + two +
                "\n1 dollars =: " + one
        );
    }
}