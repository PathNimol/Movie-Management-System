package Test;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;


public class Regex {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

//        String emailPattern =  "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
//        String emailPattern =  "HRD";
//        Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
//
//        String email = "testexample.com Hrd hrd";
//        Matcher matcher = pattern.matcher(email);
//
//        System.out.println(matcher.find());

        String chars = sc.nextLine();
        String change = chars.replaceAll("a", "A");
        System.out.println(change);

    }
}
