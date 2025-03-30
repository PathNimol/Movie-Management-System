package Test;

public class SortArray {
    public static void main(String[] args) {
        int [] array = {12,34,21,34,67,90,4,2,6,1};

        System.out.print("Before sort: {");
        for(int i= 0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("}");
        for(int i =0; i<array.length-1; i++){
            for(int j = 0; j <array.length-1-i; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.print("After sort: {");
        for(int i =0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.print("}");
    }
}

