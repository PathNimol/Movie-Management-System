package Test;

public class StarPattern {
    public static void main(String[] args) {
        System.out.println("================| Star Pattern |================\n");
        //1
        // outer loop to handle number of rows
        for (int i = 0; i < 10; i++) {
            //inner loop to handle number of columns
            for (int j = 0; j < 10; j++) {
                // star will print only when  it is in first
                // row or last row or first column or last
                // column
                if (i == 0 || j == 0 || i == 9 || j == 9) {
                    System.out.print("* ");
                }
                // otherwise print space only.
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        //2
        for(int i = 1; i<=10; i++){

            for(int j = 1; j<=10-i; j++){

                System.out.print(" ");

            }
            for(int j = 1; j<=i; j++){

                System.out.print("* ");

            }
            System.out.println();
        }
        System.out.println("\t\t***");
        System.out.println("\t\t***");
        //4
        for(int i = 0; i<=10; i++){
            for(int j = 0; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        //5
        for(int i = 10; i>=1; i--){
            for(int j= 1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}
