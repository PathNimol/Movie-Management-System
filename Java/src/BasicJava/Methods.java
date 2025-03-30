package BasicJava;

public class Methods {
    public static void main(String[] args){
        //method: is a block of code that will be excute whenever it is called upon
        //overload method: method that share the same name but have difference parameter\
        System.out.println(sum(3,5));
        System.out.println(sum(3,5,7));
        System.out.println(sum(3,5,9,8));

    }
    //Example of overload method:
    static int sum(int a, int b){
        return a+b;
    }
    static int sum(int a, int b, int c){
        return a + b + c;
    }
    static int sum(int a, int b, int c, int d){
        return a + b + c + d;
    }
}
