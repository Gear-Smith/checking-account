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
        // this.lastAccountNumber = 1;
    }

    public Account create(String name) {
        this.lastAccountNumber += 1;
        Account account = new Account(0.0, name, this.lastAccountNumber);
        
        accounts.put(lastAccountNumber, account);

        return account;
    }

    public int submit() {
        this.printStream.println("Please enter account holder name:"); 
        String name = reader.readLine();    
        
        Account newAccount = this.create(name);

        printStream.println(String.format("Account for %s was created \n " + newAccount.showAccountInfo(), name));
        
        return 0;
    }

    public String getIndividualAccount() {
        int accountNumber = reader.readInt();

        System.out.println("*********"+accountNumber);
        System.out.println( accounts.toString());
        
        accounts.forEach((key, value)-> {System.out.println(key);});
        Account theAccount = accounts.get(accountNumber);

        return theAccount.showAccountInfo();
    }
}
