public class Account {
    private int accountId;
    private String accountName;
    private double balance;
    private int pin;

    public Account(int accountId, String accountName, double balance, int pin) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.balance = balance;
        this.pin = pin;
    }

    //Get Account Id
    int getAccountId() {
        return accountId;
    }

    //Get Account Name
    String getAccountName() {
        return accountName;
    }

    //Get Account Balance
    double getBalance() {
        return balance;
    }

    //Get pin
    int getPin() {
        return pin;
    }

    public void displayAccountInfo(){
        System.out.println("Account ID: " + accountId);
        System.out.println("Account Name: " + accountName);
        System.out.println("Balance: $" + balance);
    }


    //Deposit amount from account
    boolean deposit(double amount){
        if(amount > 0){
            balance += amount;
            return true;
        }
        return false;
    }

    //Withdraw amount from account
    boolean withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            return true;
        }
        return false;
    }
}
