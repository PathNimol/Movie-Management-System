package OOP;

public class Oop {
    public static void main(String[] args) {
        User user1 = new User();
        user1.Register("Red Red", "redred@gmail.com", "Student", "redred123");
        user1.GetInfo();

        System.out.println("\n============================================================\n");

        User user2 = new User();
        user2.Register("Bee Bee", "beebee@gmail.com", "Student", "beebee123");
        user2.GetInfo();
    }
}

class User {
    String name;
    String email;
    String role;
    String password;

    public void Register(String name, String email, String role, String password) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public void GetInfo() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Role: " + role);
        System.out.println("Password: " + password);
    }
}
