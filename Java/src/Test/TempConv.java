package Test;

import java.util.Scanner;

public class TempConv {
    public static void main(String[] args) {
        System.out.println("Temperature Converter");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("O. Exit");

        Scanner temp = new Scanner(System.in);
        System.out.print("Please choose option: ");
        byte option = temp.nextByte();

        float fahrenheit, celsius;
        switch(option){
            case 1:
                System.out.println("=========| Celsius to Fahrenheit |=========");
                System.out.print("Enter Celsius value: ");
                fahrenheit = temp.nextFloat();
                celsius = (fahrenheit - 32)/9;
                System.out.println("Fahrenheit: "+ fahrenheit +"°F" +" = " + "Celsius: " + celsius + "°C");
            break;
            case 2:
                System.out.println("=========| Celsius to Fahrenheit |=========");
                System.out.print("Enter Celsius value: ");
                celsius = temp.nextFloat();
                fahrenheit = (celsius * 9/5) + 32;
                System.out.println("Celsius: "+ celsius +"°C" +" = " + "Fahrenheit: " + fahrenheit + "°F");
            break;
            case 0:
                System.out.println("=========| EXIT |=========");
                System.exit(0);
            default:
                System.out.println("Invalid option");
                break;
        }
    }
}
