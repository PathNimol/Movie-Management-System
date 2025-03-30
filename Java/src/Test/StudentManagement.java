package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        List<Student> studentsList = new ArrayList<>();
        Student editStudent = null;
        int choice, id = 1;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("====================| STUDENT MANAGEMENT |====================");
            System.out.println("1. Add Test.Student");
            System.out.println("2. Delete Test.Student");
            System.out.println("3. Edit Test.Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Search Test.Student");
            System.out.println("0. Exit");
            System.out.print("Please select an option: ");
            choice = input.nextInt();
            input.nextLine(); // Consume the newline left-over

            switch (choice) {
                case 1:
                    System.out.println("====================| ADD STUDENT |====================");

                    // Get and validate student ID
                    System.out.println("ID: " + id);
                    // Get student Name
                    System.out.print("Enter student Full Name: ");
                    String name = input.nextLine();

                    // Get student Gender
                    System.out.print("Enter student Gender: ");
                    String gender = input.nextLine();

                    // Get and validate student Age
                    int age = 0;
                    while (true) {
                        System.out.print("Enter student Age: ");
                        String ageInput = input.nextLine();
                        if (!ageInput.trim().isEmpty()) {
                            try {
                                age = Integer.parseInt(ageInput);
                                break; // Exit loop if valid integer is entered
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a valid integer for the Age.");
                            }
                        } else {
                            System.out.println("Age cannot be empty. Please enter a valid Age.");
                        }
                    }

                    // Add the new Test.Student to the list
                    studentsList.add(new Student(id, name, gender, age));
                    System.out.println("Test.Student Added Successfully");
                    id++;
                    break;

                case 2:
                    System.out.println("====================| DELETE STUDENT |====================");
                    while (true) {
                        System.out.print("Enter student ID to delete: ");
                        String idInput = input.nextLine();
                        if (!idInput.trim().isEmpty()) {
                            try {
                                id = Integer.parseInt(idInput);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a valid integer for the ID.");
                            }
                        } else {
                            System.out.println("ID cannot be empty. Please enter a valid ID.");
                        }
                    }
                    for (int i = 0; i < studentsList.size(); i++) {
                        if (studentsList.get(i).getId() == id) {
                            studentsList.remove(i);
                        }
                    }
                    System.out.println("Test.Student Deleted! *You cannot revers this student!");
                    break;

                case 3:
                    System.out.println("====================| EDIT STUDENT |====================");
                    System.out.println("Note: Test.Student can change only Name, Gender, Age!");

                    while (true) {
                        System.out.print("Enter student ID to Edit: ");
                        String idInput = input.nextLine();
                        if (!idInput.trim().isEmpty()) {
                            try {
                                id = Integer.parseInt(idInput);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a valid integer for the ID.");
                            }
                        } else {
                            System.out.println("ID cannot be empty. Please enter a valid ID.");
                        }
                    }

                    // Find the student in the list
                    Student studentToEdit = null;
                    for (Student student : studentsList) {
                        if (student.getId() == id) {
                            studentToEdit = student;
                            System.out.println(student.toString());
                            break;
                        }
                    }

                    if (studentToEdit != null) {
                        // Initialize variables with current student values
                        name = studentToEdit.getName();
                        gender = studentToEdit.getGender();
                        age = studentToEdit.getAge();

                        System.out.print("Do you want to change student name? (Yes/No): ");
                        String confirm = input.nextLine();
                        if (confirm.equalsIgnoreCase("Yes")) {
                            System.out.print("Enter student Full Name: ");
                            name = input.nextLine();
                        }

                        System.out.print("Do you want to change student Gender? (Yes/No): ");
                        confirm = input.nextLine();
                        if (confirm.equalsIgnoreCase("Yes")) {
                            System.out.print("Enter student Gender: ");
                            gender = input.nextLine();
                        }

                        System.out.print("Do you want to change student Age? (Yes/No): ");
                        confirm = input.nextLine();
                        if (confirm.equalsIgnoreCase("Yes")) {
                            System.out.print("Enter student Age: ");
                            age = input.nextInt();
                        }

                        // Update the student in the list
                        studentsList.add(new Student(id, name, gender, age));
                        System.out.println("Test.Student Edited Successfully  ✔ ");
                    } else {
                        System.out.println("Test.Student with ID " + id + " not found.");
                    }
                    break;


                case 4:
                    System.out.println("====================| DISPLAY ALL STUDENTS |====================");
                    for (Student student : studentsList) {
                        System.out.println("ID\t" + "Name\t" + "Gender\t" + "Age");
                        System.out.println(student);
                    }
                    break;

                case 5:
                    System.out.println("====================| SEARCH STUDENT |====================");
                    while (true) {
                        System.out.print("Enter student ID to Find: ");
                        String idInput = input.nextLine();
                        if (!idInput.trim().isEmpty()) {
                            try {
                                id = Integer.parseInt(idInput);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a valid integer for the ID.");
                            }
                        } else {
                            System.out.println("ID cannot be empty. Please enter a valid ID.");
                        }
                    }

                    // Find the student in the list
                    for (Student student : studentsList) {
                        if (student.getId() == id) {
                            studentToEdit = student;
                            System.out.println(student.toString());
                            break;
                        }else {
                            System.out.println("Test.Student with ID " + id + " not found.");
                        }
                    }
                    break;

                case 0:
                    System.out.println("====================| EXIT |====================");
                    System.exit(0);
                    break;

                default:
                    System.out.println("⚠⚠⚠Invalid option⚠⚠⚠");
                    break;
            }
        } while (choice != 0);

        input.close();
    }
}

class Student {
    private int id;
    private String name;
    private String gender;
    private int age;

    public Student(int id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + gender + "\t" + age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}