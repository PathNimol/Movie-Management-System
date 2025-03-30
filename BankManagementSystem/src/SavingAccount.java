public class SavingAccount extends Account {
    private double interestRate = 0.1;

    public SavingAccount (int accountId, String accountName, double balance, int pin){
        super(accountId, accountName, balance, pin);
        System.out.println("Saving Account Created!");
    }

    //Override Deposit method
    boolean deposit(double amount){
        //Validate amount
        double totalAmount = amount +(amount * interestRate);
        return super.deposit(totalAmount);
    }
}
