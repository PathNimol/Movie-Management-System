import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    Scanner sc = new Scanner(System.in);
    private String bankName;

    private ArrayList<Account> accounts;
    private String password = "admin1234";

    public ATM() {};

    public ATM(String bankName){
        this.bankName = bankName;
    }

    //Add account
    public void addAccount(Account account){
        accounts.add(account);
    }

    //Display Menu
    public void displayMenu(int option){
        System.out.println("Welcome to " + bankName);
        System.out.println("1. Create Account");
        System.out.println("2. Display Account");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Transfer");
        System.out.println("6. Display All Accounts");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");


        option = sc.nextInt();
    }

    //Get Name
    public String getBankName(){
        return bankName;
    }

    //Display each account
    public void displayAccount(int accountId){
        System.out.print("Enter pin: ");
        int pin = sc.nextInt();
        for(Account account : accounts){
            if(account.getAccountId() == accountId && account.getPin() == pin){
                account.displayAccountInfo();
                return;
            }
        }
        System.out.println("Invalid Account ID or pin");
    }

    //Deposit  Money
    public void deposit(int accountId){
        System.out.print("Enter pin: ");
        int pin = sc.nextInt();
        for(Account account: accounts){
            if(account.getAccountId() == accountId && account.getPin() == pin){
                System.out.print("Enter Amount: $");
                double amounts = sc.nextDouble();
                if(account.deposit(amounts)){
                    System.out.println("Amount " + amounts + " deposited Successful!");
                }else {
                    System.out.println("Insufficient Amount");
                }
                return;
            }
        }
        System.out.println("Invalid Account Number or Pin");
    }

    //Withdraw Money
    public void withdraw(int accountId){
        
    }

}
