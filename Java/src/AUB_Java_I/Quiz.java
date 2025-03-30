package AUB_Java_I;

import java.util.Scanner;
public class Quiz {
    public static void main(String[] args) {
        //1. Calculate speed
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter distance to the school(Km): ");
        float d = sc.nextInt();
        System.out.print("Enter times spent(h): ");
        float t = sc.nextInt();
        float speed = d/t;
        System.out.println("The distance " + d + " times " + t + " the speed would be " + speed + "Km/h");

        //2. Calculate the cost of calls
        System.out.print("How many hours did you call?: ");
        int h = sc.nextInt();
        float totalCostInhours = (h * 60) * 30;
        System.out.println(h + " = " + totalCostInhours + "cents");

        System.out.print("How many minutes did you call?: ");
        int m = sc.nextInt();
        float totalCostInMinutes = m * 30;
        System.out.println(m + " = " + totalCostInMinutes + "cents");

        System.out.print("How many seconds did you call?: ");
        int s = sc.nextInt();
        float totalCostInSeconds = ((float) s / 60) * 30;
        System.out.println(s + " = " + totalCostInSeconds + "cents");

        float totalCostInCents = totalCostInhours + totalCostInMinutes + totalCostInSeconds;
        float total = totalCostInCents / 100;


        System.out.println("Your call for " + h + "h " + m + "m " + s + "s " + ", you need to charge " + total);

        //3.
        System.out.println("Enter the integer between 1 and 10,000: ");
        int integer = sc.nextInt();

        if(integer < 1 || integer > 10000){
            System.out.println("Invalid input, the number must be between 1 and 10,000");
            return;
        }

        int totalMul = 1;
        totalMul *= (integer % 10);
        totalMul *= (integer / 10 % 10);
        totalMul *= (integer / 100 % 10);
        totalMul *= (integer / 1000 % 10);

        System.out.println("If an integer is + " + integer + ", the multiplication of all its digits is " + totalMul);

        //4. Lucky digits
        System.out.print("Enter six-digit number: ");
        int num = sc.nextInt();

        if (num < 100000 || num > 999999) {
            System.out.println("Please enter six-digit number.");
        }else {
            int firstDigit = num/100000;
            int secondDigit = (num % 100000) / 10000;
            int thirdDigit = (num % 10000) / 1000;
            int fourthDigit = (num % 1000) / 100;
            int fifthDigit = (num % 100) / 10;
            int sixthDigit = num % 10;

            int first3digits = firstDigit + secondDigit + thirdDigit,
                    last3digits = fourthDigit + fifthDigit + sixthDigit;

            System.out.println("Sum of first 3 digits: " + first3digits);
            System.out.println("Sum of last 3 digits: " + last3digits);
            if (first3digits == last3digits) {
                System.out.println(num + " is lucky number!");
            } else {
                System.out.println(num + " is not lucky number:(");
            }
        }
        //5. Convert Minutes to Year Month Day
        //1 Year = 525,600minutes
        //1 Month = 43,200minutes
        //1 Day = 1,440minutes
        System.out.print("Enter numbers of Minutes: ");
        int minutes = sc.nextInt();

        int numOfYear = minutes / 525600;
        int numOfMonth = (minutes % 525600) / 43200;
        int numOfDay = (minutes % 43200) / 1440;
        System.out.println(minutes + " minutes is approximately " + numOfYear + "years " + numOfMonth + "months " + numOfDay + "days");

        //6. Swap the first and last digit
        System.out.println("Enter the five-digits number: ");
        int digits = sc.nextInt();

        if(digits < 10000 || digits > 99999) {
            System.out.println("Invalid input, Please input only 5 digits number!");
        }else {
            int firstDigit = digits/10000;
            int secondDigit = (digits % 10000) / 1000;
            int thirdDigit = (digits % 1000) / 100;
            int fourthDigit = (digits % 100) / 10;
            int fifthDigit = digits % 10;

            System.out.println("From " + digits + " to " + fifthDigit + firstDigit + secondDigit + thirdDigit + fourthDigit);
        }

        //7. Validate input digits
        int number, temp1, temp2;
        System.out.print("Enter 4 digits number: ");
        number = sc.nextInt();

        if(number < 1000 || number > 9999){
            System.out.println("Please enter only 4 digits number!");
        }else{
            int firstDigit = number/1000;
            int secondDigit = (number % 1000) / 100;
            int thirdDigit = (number % 100) / 10;
            int fourthDigit = number % 10;

            System.out.println("Before " + number);

            temp1 = firstDigit;
            firstDigit = secondDigit;
            secondDigit = temp1;

            temp2 = thirdDigit;
            thirdDigit = fourthDigit;
            fourthDigit = temp2;

            System.out.println("After: " + firstDigit + secondDigit  + thirdDigit + fourthDigit);
        }
    }
}
