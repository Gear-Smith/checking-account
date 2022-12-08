
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.when;

import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountManagmentTests {
    
    private PrintStream printStream;
    private LineReader reader;
    private Menu menu;
    private AccountManagement accountManagement;

    @BeforeEach
    void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(LineReader.class);
        //accountManagement = mock(AccountManagement.class);
        accountManagement = new AccountManagement(printStream, reader);
        menu = new Menu(printStream, reader, accountManagement);
    }

    @Test
    public void VerifyThatAccountCreationIsPrintedToConsole(){
        
        when(reader.readLine()).thenReturn("Bill");
        accountManagement.submit();
        verify(printStream).println(contains("Account for Bill was created"));
        verify(printStream).println(contains("0.0"));
        
    }

    @Test
    public void enteringAccountHolderNameReturnsAccount() {
        when(reader.readLine()).thenReturn("Bill");

        accountManagement.submit();
        // when(reader.readLine()).thenReturn("2");
        when(reader.readInt()).thenReturn(2);
        accountManagement.getIndividualAccount();
        // Account account = accountManagement.getIndividualAccount("#0002");

        // account.showAccountInfo();
        
        verify(printStream).println(contains("#0002"));
    }

    @Test
    public void menuOptionSelectCreateAccountStartsCreateAccountProcess() {
        when(reader.readLine()).thenReturn("q");
        
        menu.start();
        
        verify(printStream).println(contains("Create Account"));
        verify(printStream).println(contains("Quit"));
    }

    @Test
    public void whenAccountIsCreatedThenAccountNumberIsDisplayedInConfirmation() {
        when(reader.readLine()).thenReturn("Bill");

        accountManagement.submit();

        verify(printStream).println(contains("#000"));
    }
}