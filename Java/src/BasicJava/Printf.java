package BasicJava;

public class Printf {
    public static void main(String[] args){
        //printf: an optional method to control, format, and display text to the console window
        //two arguments = format string + (object/variable/value)
        //%[flag] [precision] [width] [conversion-character]
        System.out.printf("%d This is format string", 123);
        boolean myBoolean = true;
        int myInt = 30;
        double myDouble = 20.44d;
        String myStirng = "Nimol";
        char myChar = '$';
        System.out.printf("%b", myBoolean);
        System.out.printf("%c", myChar);
        System.out.printf("%s", myStirng);
        System.out.printf("%d", myInt);
        System.out.printf("%f", myDouble);
    }
}
