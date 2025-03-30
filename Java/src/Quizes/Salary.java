package Quizes;

public class Salary {
    int java;
    int mobileApp;
    boolean oop;

    int getSalary(int java, int mobileApp){
        this.java = java;
        this.mobileApp = mobileApp;
        this.oop = true;
        int salary = 0;

        if(java < 1 && mobileApp < 1 && !oop){
            salary = 500;
        }
        if(java > 1 && mobileApp < 1 && !oop ){
            salary = 650;
        }
        if (java > 1 && mobileApp > 1 && !oop) {
            salary = 700;
        }
        if(java > 1 && mobileApp > 1 && oop ){
            salary = 900;
        }
        return salary;
    }

    public static void main(String[] args) {
        Salary sal = new Salary();

        System.out.println("Salary employee 1: " + sal.getSalary(2, 2));
        System.out.println("Salary employee 2: " + sal.getSalary(1,1));
    }
}
