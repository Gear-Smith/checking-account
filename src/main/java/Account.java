
public class Account {

    private int accountNumber;
    
    private double balance;
    private String name;
    
    public Account(double balance, String name, int accountNumber) {
        this.balance = balance;
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public String showAccountInfo() {
        String accountInfo = String.format("""
            Account Number: %s
            The Current Balance is: %.2f """, this.getAccountNumberString(), this.balance);

        return accountInfo;
    }
    
    public String getAccountNumberString() {
        return "#000" + String.valueOf(accountNumber);
    }

    public void deposit(Double amount) {
        this.balance += amount;
    }

    public String getName() {
        return this.name;
    }

    public String withdraw(Double amount) {
        if (this.balance - amount < 0.0) {return "Withdraw Unsuccessful";}
        
        this.balance -= amount;

        return "Withdraw Successful";
    }
}
    