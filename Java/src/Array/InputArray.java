package Array;

public class InputArray {
    public static void main(String[] args) {

        int [][] m = {
                {1,2,3,4},
                {5, 6, 7, 8},
                {9,10,11,12}
        };
        for(int i = 0; i < m[i].length; i++){
            int sum = 0;
            for(int j = 0; j < m.length; j++){
                sum += m[j][i];
            }
            System.out.println("Sum: " + sum);
        }

    }
}
