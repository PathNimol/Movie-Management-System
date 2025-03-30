package Test;

public class NarrowingTypeCastingExample {
    public static void main(String[] args) {
        double d = 166.66;
        long l = (long)d;
        int i = (int)(short)d;
        System.out.println("Original Value: " + d);
        System.out.println("Narrowing Value: " + l);
        System.out.println(i);

    }
}
