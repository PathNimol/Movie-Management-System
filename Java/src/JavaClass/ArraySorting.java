package JavaClass;

public class ArraySorting {
    public static void main(String[] args){
        //find the minimum and maximum
        int [] arr = {23, 11, 9, 18, 25};
        int temp = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - 1; j++){
                if(arr[j] < arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Min: " + temp);
        System.out.println("Maximum: " + arr[0]);
        System.out.println("Minimum: " + arr[4]);


        //. Finds the last positive number and the first negative number in given an array.
        double [] array = {5.7, 6.0, 2, -4.7, 6, 8.1, -4, 0};
        double positive =0, negative = 0;

        for (int i = array.length - 1; i >= 0; i--) { //-1 because we need the last one
            if (array[i] >= 0) {
                positive = array[i];
                break;
            }
        }

        for(int i = 0; i < array.length; i++){
            if(array[i] < 0){
                negative = array[i];
                break;
            }
        }

        System.out.println("The last Positive Number is " + positive);
        System.out.println("The first negative Number is " + negative);

    }
}