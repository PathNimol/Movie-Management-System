package BasicJava;

import java.util.Random;
import java.util.Scanner;
public class RandomIfelse {
    public static void main(String[] args) {
        boolean retry = true;
        do {
            System.out.print("Enter number between 0-100: ");
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            int number = scanner.nextInt();
            int randomNumber = random.nextInt(101);
            if(number == randomNumber){
                System.out.println("You got it!");
            }else{
                System.out.println("You lost!");
                System.out.println("Do you want to try again? (yes/no)");
                String answer = scanner.next();
                if(answer.equals("yes")|| answer.equals("y") || answer.equals("Yes") || answer.equals("Y") || answer.equals("YES")){
                    retry = false;
                }
                else if(answer.equals("no") || answer.equals("n") || answer.equals("No") || answer.equals("N") || answer.equals("NO")){
                    retry = true;
                    System.out.println("================|-EXIT PROGRAM-|================");
                }
                else{
                    System.out.println("Please enter only yes or no!");
                }
            }
        }while(!retry);

    }
}
