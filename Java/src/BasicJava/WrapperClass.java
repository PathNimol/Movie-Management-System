package BasicJava;
import java.util.Scanner;
import java.util.regex.Pattern;

public class WrapperClass {

    public static void main(String[] args) {
        //Wrapper class: provide a way to use primitive data type as reference data type
        //              reference data type contain useful methods can be used with collection(ex: ArrayList)
        //Primitive data type:      //Wrapper class:
            //int                       //Integer
            //boolean                   //Boolean
            //char                      //Character
            //double                    //Double
        //The main difference between primitive and wrapper class is nature usage and feature
        //Nature:
        //**Primitive: is a datatype that provide and stored directly to java while Wrapper just a class and stored a heap because they are obj
        //--Wrapper can use with arraylist, hashmap,.... while Primitive cannot

        //autoboxing: the automatic conversion that the JAVA compiler make between primitive type and their corresponding object wrapper class
        //unboxing: the reverse of autoboxing. Automatic conversion of wrapper class to primitive
//        int primitiveInt = 10;
//        Integer wrapperInt = primitiveInt; // Autoboxing
//        int primitiveAgain = wrapperInt;  // Unboxing
//
//
//        int value = Integer.parseInt("123"); // Parse String to int
//        String str = Integer.toString(123); // Convert int to String
//
//        Integer intt = null; // Valid
//        //int primitiveInt = null;   // Compilation error
//
//        //Example
//        Boolean b = true;
//        Integer i = 10;
//        Character c = 'a';
//        Double d = 10.5;
//        String s = "Hello";
        // Boxing: Converting int to Integer
        int primitiveInt = 42;
        Integer wrappedInt = Integer.valueOf(primitiveInt); // Explicit boxing
        System.out.println("Boxed Integer: " + wrappedInt);

        // Autoboxing: Automatically converting int to Integer
        Integer autoBoxedInt = primitiveInt; // Autoboxing
        System.out.println("Autoboxed Integer: " + autoBoxedInt);

        // Unboxing: Converting Integer to int
        int unboxedInt = wrappedInt.intValue(); // Explicit unboxing
        System.out.println("Unboxed int: " + unboxedInt);

        String emailRegex = "^[a-zA-Z0-9+_.-] + @[a-zA-Z0-9.-]+$";
        Scanner sd  = new Scanner(System.in);
        sd.next();


    }
}
