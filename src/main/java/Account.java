
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
            The Current Balance is: %f """, this.getAccountNumberString(), this.balance);

        return accountInfo;
    }
    
    public String getAccountNumberString() {
        return "#000" + String.valueOf(accountNumber);
    }
    
    // public void setAccountNumber(int accountNumber) {
    //     this.accountNumber = accountNumber;
    // }
}
    