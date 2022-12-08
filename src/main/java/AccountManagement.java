import java.io.PrintStream;
import java.util.HashMap;

public class AccountManagement {

    private HashMap<Integer, Account> accounts;
    private int lastAccountNumber = 1;
    private PrintStream printStream;
    private LineReader reader;

    public AccountManagement(PrintStream printStream, LineReader reader) {
        this.printStream = printStream;
        this.reader = reader;
        this.accounts = new HashMap<>();
    }

    public Account create(String name) {
        this.lastAccountNumber += 1;
        Account account = new Account(0.0, name, this.lastAccountNumber);
        
        accounts.put(lastAccountNumber, account);

        return account;
    }
    
    public void submit() {
        this.printStream.println("Please enter account holder name:"); 
        String name = reader.readLine();    
        
        Account newAccount = this.create(name);

        printStream.println(String.format("Account for %s was created \n " + newAccount.showAccountInfo(), name));
    }

    public String getIndividualAccountInfo() {
        int accountNumber = reader.readInt();
        Account theAccount = accounts.get(accountNumber);
        return theAccount.showAccountInfo();
    }

    public void makeDeposit() {
        printStream.println("Enter account number:");
        String accountNumber = reader.readLine();
        printStream.println("Enter amount of deposit:");
        Double amount = reader.readDbl();

        Account account = accounts.get(Integer.parseInt(accountNumber));
        account.deposit(amount);
        printStream.println(account.showAccountInfo()); 
    }

    public void makeWithdraw() {
        printStream.println("Enter account number:");
        String accountNumber = reader.readLine();
        printStream.println("Enter amount of withdraw:");
        Double amount = reader.readDbl();

        Account account = accounts.get(Integer.parseInt(accountNumber));
        
        printStream.println(account.withdraw(amount));
        
        printStream.println(account.showAccountInfo()); 

        
    }
}
