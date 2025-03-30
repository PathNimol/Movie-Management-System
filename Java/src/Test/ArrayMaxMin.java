package Test;

public class ArrayMaxMin {
    public static void main(String[] args) {
       int [][] myNum= {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

       for(int[] row: myNum){
           for (int i: row){
               System.out.println(i);
           }
       }
        int[] array = {10,90,23,2,20};
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        System.out.println("The maximum value is: "+ max);
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            min = Math.min(min, array[i]);
        }
        System.out.println("The minimum value is: "+ min);
    }
}