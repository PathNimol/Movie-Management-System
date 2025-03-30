package BasicJava;

import java.util.ArrayList;

public class forEachLoop {
    public static void main(String [] args){
        //String [] animals = {"Cat", "Dog", "Cow"};
        ArrayList<String> animals = new ArrayList<>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Rat");
        animals.add("Cow");
        for(String i: animals){
            System.out.println(i);
        }
    }
}
