import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintStream;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuTests {

    private LineReader reader;
    private PrintStream printStream;
    private AccountManagement accountManagement;
    private Menu menu;
    
    @BeforeEach
    void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(LineReader.class);
        accountManagement = mock(AccountManagement.class);
        
        menu = new Menu(printStream, reader, accountManagement, new HashMap<String, Command>());
    }

    @Test
    public void menuOptionSelectCreateAccountStartsCreateAccountProcess() {
        when(reader.readLine()).thenReturn("q");
        
        menu.start();
        
        verify(printStream).println(contains("Create Account"));
        verify(printStream).println(contains("Quit"));
    }

    @Test
    public void whenMenuStartsThenMenuPromptsForChoices() {
        when(reader.readLine()).thenReturn("q");
       
        menu.start();
        
        verify(printStream).println(contains("Option:"));
    }

    @Test
    public void whenOptionQIsSelectedThenNoOtherInteractions() {
        when(reader.readLine()).thenReturn("q");
       
        menu.start();

        verify(reader, times(1)).readLine();
    }

    @Test
    public void whenQuitOptionSelectedThenQuitConfirmationIsGiven() {
        when(reader.readLine()).thenReturn("q");
        
        menu.start();

        verify(printStream).println(contains("Exiting"));
    }
    
    @Test
    public void whenAnAccountIsCreatedThenTheMainLoopReturnsToTheMenuPrompt() {
        when(reader.readLine())
        .thenReturn("1")
        .thenReturn("Bill")
        .thenReturn("1")
        .thenReturn("Bill")
        .thenReturn("q");

        menu.start();
        
        verify(accountManagement, times(2)).submit();
    }

    @Test
    public void whenMenuPrintsThenAllOptionsArePresent() {
        String menuOptions = """
        1. Create Account
        2. Search Balance
        3. Make Deposite
        4. Make Withdraw
        q. Quit

        Option: 
        """;

        when(reader.readLine()).thenReturn("q");

        menu.start();

        verify(printStream).println(contains(menuOptions));
    }
    
    
}
