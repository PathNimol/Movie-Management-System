package JavaClass;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Accounts {
    private int accountNumber;
    private String accountName;
    private double balance;

    //
    public Accounts(int accountNumber, String accountName, double balance){
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    //Display information
    public void displayAccount(){
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Name: " + accountName);
        System.out.println("Balance: $" + balance);
    }
    //Withdraw amount
    public void withdraw(double amount){
        this.balance -= amount;
    }

    //Deposit amount
    public void deposit(double amount){
        this.balance += amount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Accounts> acc = new ArrayList<Accounts>();

        System.out.println("Welcome to Bank Account!");

        //Function of the account
        int option = 0;
        do {
            System.out.println("\n1. Create a new account");
            System.out.println("2. Display account information");
            System.out.println("3. Withdraw");
            System.out.println("4. Deposit");
            System.out.println("0. Exit");
            System.out.print("Please select an option: ");
            option = sc.nextInt();

            switch (option){
                case 1:
                    // Create a new account
                    System.out.print("Enter Account Number: ");
                    int accountNumber = sc.nextInt();

                    sc.nextLine(); // Consume newline left-over

                    System.out.print("Enter Account Name: ");
                    String accountName = sc.nextLine();

                    System.out.print("Enter Balance: ");
                    double balance = sc.nextDouble();

                    acc.add(new Accounts(accountNumber, accountName, balance));
                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    // Display account information
                    System.out.println("\n=============================| Account Information |=============================");
                    Iterator<Accounts> accounts = acc.iterator(); //Use iterator to iterate over accounts
                    while (accounts.hasNext()){
                        accounts.next().displayAccount();
                        System.out.println();
                    }
                    break;

                case 3:
                    // Withdraw
                    //Search account to withdraw
                    System.out.println("Enter your account number: ");
                    int accNumberInput = sc.nextInt();

                    for(Accounts account: acc){
                        //Check if the account is found
                        if(account.accountNumber == accNumberInput){
                            account.displayAccount();

                            System.out.println("Enter amount to withdraw: ");
                            double withdrawAmount = sc.nextDouble();
                            double oldBalance = account.balance;

                            if(withdrawAmount <= account.balance){
                                account.withdraw(withdrawAmount);
                                System.out.println("Withdraw successful!");
                                System.out.println("Old balances: $" + oldBalance);
                                System.out.println("Withdraws: $" + withdrawAmount);
                                System.out.println("Remain balances: $" + account.balance);
                                break;
                            }
                            else{
                                System.out.println("Insufficient balance!");
                            }
                        }
                        else{
                            System.out.println("Account not found!");
                        }
                    }
                    break;
                case 4:
                    // Deposit
                    // Withdraw
                    //Search account to withdraw
                    System.out.println("Enter your account number: ");
                    int accountInput = sc.nextInt();

                    for(Accounts account: acc){
                        if(account.accountNumber == accountInput){
                            account.displayAccount();

                            System.out.println("Enter amount to withdraw: ");
                            double depositAmount = sc.nextDouble();
                            double oldBalance = account.balance;

                            if(depositAmount > 0){
                                account.withdraw(depositAmount);
                                System.out.println("Withdraw successful!");
                                System.out.println("Old balances: $" + oldBalance);
                                System.out.println("Deposits: $" + depositAmount);
                                System.out.println("Remain balances: $" + account.balance);
                                break;
                            }
                            else{
                                System.out.println("Cannot deposit! Balance must be greater than 0!");
                            }
                        }
                        else{
                            System.out.println("Account not found!");
                        }
                    }
                    break;
                case 0:
                    // Exit
                    System.out.println("Thank you for using our bank!");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }while(option !=0);

    }

}