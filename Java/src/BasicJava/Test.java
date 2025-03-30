package BasicJava;
public class Test {

    // Method that takes a variable number of integers as input
    public static void printNumbers(int... numbers) {
        // Inside the method, numbers is treated as an array
        System.out.println("Number of values passed: " +
                numbers.length);

        // Loop through the array and print each number
        for (int num : numbers) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        // Call the method with different numbers of arguments

        // Example 1: Passing multiple values
        printNumbers(1, 2, 3); // The compiler turns this into an array [1, 2, 3]

        // Example 2: Passing a single value
        printNumbers(5); // The compiler turns this into an array [5]

        // Example 3: Passing no values
        printNumbers(); // The compiler turns this into an empty array []
    }
}