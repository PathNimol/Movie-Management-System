package OOP;

public class EmployeeMain{
    public static void  main(String[] args){
        //Create object OOP.Employee
        Employee emp = new Employee(1,"Navy","Vin", 200);
        System.out.println(emp + "\n");
        System.out.println("========================| Detail Information |========================");
        System.out.println("OOP.Employee 1");
        System.out.println("ID: " + emp.getId());
        System.out.println("Name: " + emp.getName());
        System.out.println("Salary: " + emp.getSalary());
        System.out.println("Annual Salary: " + emp.getAnnualSalary());
        System.out.println("Raise Salary: " + emp.raiseSalary(10));

        Employee emp2 = new Employee(2,"Nikola","Vin", 500);
        System.out.println("\nOOP.Employee 2");
        System.out.println("ID: " + emp2.getId());
        System.out.println("Name: " + emp2.getName());
        System.out.println("Salary: " + emp2.getSalary());
        System.out.println("Annual Salary: " + emp2.getAnnualSalary());
        System.out.println("Raise Salary: " + emp2.raiseSalary(15));
    }
}
