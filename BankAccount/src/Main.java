import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount bankAccount = new BankAccount();
        double amount;
        int opt;

        System.out.print("Enter your account number: ");
        bankAccount.accountNumber = sc.nextLine();

        System.out.print("Enter your balance: ");
        bankAccount.balance = sc.nextDouble();

        System.out.println("=======================| Welcome to Bank Account |=======================");

        System.out.println("Account Number: " + bankAccount.accountNumber);
        System.out.println("Balance: $" + bankAccount.balance);
        System.out.println("-----------------------------------------------------\n");

        do {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("0. Exit");

            System.out.print("Please choose option: ");
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    System.out.println("==========| DEPOSIT MONEY |==========");
                    System.out.print("Enter amount to deposit: ");
                    amount = sc.nextDouble();
                    if(amount <= bankAccount.balance && amount > 0){
                        bankAccount.deposit(amount);
                    }
                    else {
                        System.out.println("Amounts to withdraw is not enough!");
                    }

                    bankAccount.displayBalance();

                    break;

                case 2:
                    System.out.println("==========| WITHDRAW MONEY |==========");
                    System.out.print("Enter amount to withdraw: ");
                    amount = sc.nextDouble();
                    bankAccount.withdraw(amount);

                    bankAccount.displayBalance();

                case 0:
                    System.out.println("Thank you!");
                default:
                    System.out.println("Invalid option!!!!1");
            }
        }while(opt != 0 );

    }
}