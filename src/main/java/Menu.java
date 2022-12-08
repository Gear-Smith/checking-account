import java.io.PrintStream;

public class Menu {
    private Boolean returnToMenu = true;
    private String selection = "";
    private PrintStream printStream;
    private LineReader reader;
    private AccountManagement accountManagement;

    private String menuOptions = """
            1. Create Account
            2. Search Balance
            3. Make Deposite
            4. Make Withdraw
            q. Quit

            Option: 
            """;

    public Menu(PrintStream printStream, LineReader reader, AccountManagement accountManagement) {
        this.printStream = printStream;
        this.reader = reader;
        this.accountManagement = accountManagement;
    }
    
    public void start() {
        returnToMenu = true;
        while(returnToMenu == true){
            printStream.println(menuOptions);

            this.selection = reader.readLine();

            switch (selection) {
                case "1": this.accountManagement.submit();
                    returnToMenu = true;
                    break;
                case "2":  printStream.println(accountManagement.getIndividualAccountInfo());
                    returnToMenu = true;
                    break;
                case "3":  accountManagement.makeDeposit();
                    returnToMenu = true;
                    break;
                case "4":  accountManagement.makeWithdraw();
                    returnToMenu = true;
                    break;
                case "q": printStream.println("Exiting Program");
                    returnToMenu = false;
                    break;
                default:
                    break;
            }
        }
    }
}
