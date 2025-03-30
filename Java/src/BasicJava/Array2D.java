package BasicJava;

public class Array2D {
    public static void main(String[] args) {
        //2D array : an array of arrays
        String [][] cars = new String[3][3];
        cars[0][0] = "BMW"; // row 0 column 0
        cars[0][1] = "Mercedes"; //row 0 column 1
        cars[0][2] = "Audi";//row 0 column 2
        cars[1][0] = "Volvo"; //row 1 column 0
        cars[1][1] = "Ford"; //row 1 column 1
        cars[1][2] = "Tesla"; //row 1 column 2
        cars[2][0] = "Toyota"; //row 2 column 0
        cars[2][1] = "Honda"; //row 2 column 1
        cars[2][2] = "Mazda"; //row 2 column 2

//

        for(int i = 0; i < cars.length; i++){ //loop the row of array
            for(int j = 0; j < cars[i].length; j++){ //nested loop the column of array
                System.out.print(cars[i][j] + "\t");
            }
            System.out.println("Row-"+ (i + 1));
        }
    }
}
