import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintStream;

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
        //accountManagement = mock(AccountManagement.class);
        accountManagement = new AccountManagement(printStream, reader);
        menu = new Menu(printStream, reader, accountManagement);
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


    
}
