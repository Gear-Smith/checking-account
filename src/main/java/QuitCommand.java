import java.io.PrintStream;

public class QuitCommand implements Command{

    private PrintStream printStream;

    public QuitCommand(PrintStream printStream2) {
        this.printStream = printStream2;
    }

    @Override
    public void execute() {
        printStream.println("Exiting Program");
        
    }

}
