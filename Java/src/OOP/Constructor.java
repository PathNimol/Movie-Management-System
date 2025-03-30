package OOP;

public class Constructor {
    public static void main(String[] args) {

        //OOP.Constructor with parameter
        Car car = new Car(1998,"BMW");
        System.out.println("OOP.Car year: " + car.carYear);
        System.out.println("OOP.Car Model: " + car.carModel);

        System.out.println("\n===============================\n");

        //OOP.Constructor with no parameter
        Car car1 = new Car();
        System.out.println("OOP.Car year: " + car1.carYear);
        System.out.println("OOP.Car Model: " + car1.carModel);
    }
}

class Car{
    public int carYear;
    public String carModel;

    public Car(int carYear, String carModel){
        this.carYear = carYear;
        this.carModel = carModel;
    }
    public Car(){
        carYear = 1999;
        carModel = "FORD";
    }
}
