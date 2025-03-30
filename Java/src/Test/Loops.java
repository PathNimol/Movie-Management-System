package Test;

public class Loops {
    public static void main(String[] args) {

        Integer[] number = {1,2,3,4,5};

        System.out.println("Index and Value: ");
        for(int i = 0; i < number.length; i++){
            System.out.println("  " + i + "\t\t\t" + number[i]);
        }
    }
}
