import java.io.PrintStream;
import java.util.HashMap;

public class Menu {
    private String selection = "";
    private PrintStream printStream;
    private LineReader reader;
    private AccountManagement accountManagement;
    private HashMap<String, Command> commandMap;

    private String menuOptions = """
            1. Create Account
            2. Search Balance
            3. Make Deposite
            4. Make Withdraw
            q. Quit

            Option: 
            """;

    public Menu(PrintStream printStream, LineReader reader, AccountManagement accountManagement, HashMap<String, Command> commandMap) {
        this.printStream = printStream;
        this.reader = reader;
        this.accountManagement = accountManagement;
        this.commandMap = commandMap;
    }
    
    public void start() {
        
        while(!this.selection.equals("q")){
            
            //this.prompt(menuOptions, String.class);
            printStream.println(menuOptions);

            this.selection = reader.readLine();
            
            commandMap.put("1", new SubmitApplicationCommand(accountManagement));
            commandMap.put("2", new GetIndividualAccountInfoCommand(accountManagement));
            commandMap.put("3", new MakeDepositCommand(accountManagement));
            commandMap.put("4", new MakeWithdrawCommand(accountManagement));
            commandMap.put("q", new QuitCommand(printStream));

            if (commandMap.containsKey(selection)) {
                commandMap.get(selection).execute();
            }   
        }
    }
}
