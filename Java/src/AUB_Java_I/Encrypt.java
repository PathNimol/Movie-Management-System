package AUB_Java_I;

import java.util.Scanner;

public class Encrypt {
    public static String encryptString(String myString, int keyEncrypt){
        String encryptedString = "";
        for(char c: myString.toCharArray()){
            if(Character.isLetter(c)){
                char upLowCase = Character.isUpperCase(c)? 'A' : 'a';
                char newChar = (char) ((c - upLowCase + keyEncrypt) % 26 + upLowCase);
                encryptedString += newChar;
            }
            else {
                encryptedString += c;
            }
        }
        return encryptedString;
    }
    public static void main(String[] args) {
        //Encrypt and decrypt message

        int key = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String to encrypt: ");
        String stringInput = sc.nextLine();

        System.out.print("Enter the key to encrypt: ");
        key = sc.nextInt();
        String encrypted = encryptString(stringInput, key);
        System.out.println("Message: " + stringInput +
                "\nEncrypt key: " + key +
                "\nEncrypted Message: " + encrypted);
    }
}
