package BasicJava;

public class Arrays {
    public static void main(String[] args) {
        //Array used to store multiple values in a single variable;

        //Simple method
        int[] numbers = {1,2,3,4,5};
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        //String method 1
        String[] names = {"John","Jane","Jacob"};
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        //String method 2
        String [] students = new String[5];
        students[0] = "John";
        students[1] = "Jane";
        students[2] = "Jacob";
        students[3] = "Jerry";
        students[4] = "Jessica";
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }
}
