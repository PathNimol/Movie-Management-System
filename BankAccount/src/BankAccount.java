public class BankAccount
{
    String accountNumber;
    double balance;

    double withdraw(double amount){
        this.balance = this.balance - amount;
        return this.balance;
    }

    double deposit(double amount){

        this.balance = this.balance + amount;
        return this.balance;
    }

    void displayBalance(){
        System.out.println("Your balance is " + this.balance);
    }
}
