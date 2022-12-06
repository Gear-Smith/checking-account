import java.io.PrintStream;
import java.util.HashMap;

public class AccountManagement {

    private String name;
    private HashMap<String, Account> accounts;
    private PrintStream printStream;
    private LineReader reader;
    private boolean returnToMenu;
   

    public AccountManagement(PrintStream printStream, LineReader reader) {
        this.printStream = printStream;
        this.reader = reader;
        this.accounts = new HashMap<>();
    }

    public void submit() {
        this.printStream.println("Please enter account holder name:");
        this.name = reader.readLine();    

        Account account = new Account(0.0, name);
        accounts.put(name, account);

        printStream.printf(String.format("Account for %s was created", name));
    }

    public String getName() {
        return this.name;
    }

    public Account getIndividualAccount(String accountHolder) {
        return accounts.get(accountHolder);
    }

    public void menu() {
        returnToMenu = true;
        while(returnToMenu == true){
            printStream.println("""

                    1. Create Account
                    2. Quit

                    Option: """);

            int selection = reader.readInt();

            switch (selection) {
                case 1: this.submit();
                    returnToMenu = true;
                case 2: printStream.println("Exiting Program");
                    returnToMenu = false;
                default:
                    break;
            }
        }
    }
}
