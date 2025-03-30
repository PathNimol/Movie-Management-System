package Test;

import java.util.Scanner;

public class CountChar {
    public static void main(String[] args) {
        Scanner words = new Scanner(System.in);
        System.out.print("Enter words: ");
        String str = words.nextLine();

        Scanner countChar = new Scanner(System.in);
        System.out.print("What characters that you want to count? : ");
        String ch= countChar.nextLine();
        int count = 0;
        for(int i= 0; i<str.length(); i++){
           if(str.charAt(i)== ch.charAt(0)){
               count++;
           }
        }
        System.out.println("The length of "+ ch +" = "+count);
    }
}
