
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.when;

import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountManagmentTests {
    
    private PrintStream printStream;
    private LineReader reader;
    private AccountManagement accountManagement;

    @BeforeEach
    void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(LineReader.class);
        //accountManagement = mock(AccountManagement.class);
        accountManagement = new AccountManagement(printStream, reader);
    }

    private void createAccountPattern(String name) {
        when(reader.readLine()).thenReturn(name);

        accountManagement.submit();
    }

    private void withdrawOrDepositInput(String string, double d) {
        when(reader.readLine()).thenReturn("2");
        when(reader.readDbl()).thenReturn(1.00);
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

        when(reader.readInt()).thenReturn(2);
        accountManagement.getIndividualAccountInfo();
            
        verify(printStream).println(contains("#0002"));
    }

    @Test
    public void whenAccountIsCreatedThenAccountNumberIsDisplayedInConfirmation() {
        when(reader.readLine()).thenReturn("Bill");

        accountManagement.submit();

        verify(printStream).println(contains("#000"));
    }

    @Test
    public void whenMakeDepositSelectedThenPromptForAccountNumberAndAmount() {
       String accountInfoString = "Account Number: #0002\nThe Current Balance is: 1.00";

       this.createAccountPattern("Bill");
    
       when(reader.readLine()).thenReturn("2");
       when(reader.readDbl()).thenReturn(1.00);

       accountManagement.makeDeposit();

       verify(printStream).println(contains("Enter account number:"));
       verify(printStream).println(contains("Enter amount of deposit:"));
       verify(printStream).println(accountInfoString);
    }

    @Test
    public void whenMakeWithdrawSelectedThenPromptForAccountNumberAndAmount() {
       String accountInfoString = "Account Number: #0002\nThe Current Balance is: 0.00";

       this.createAccountPattern("Bill");
      
       this.withdrawOrDepositInput("2", 1.00);
       accountManagement.makeDeposit();


       this.withdrawOrDepositInput("2", 1.00);
       accountManagement.makeWithdraw();

       verify(printStream, times(2)).println(contains("Enter account number:"));
       verify(printStream).println(contains("Enter amount of withdraw:"));
       verify(printStream).println(accountInfoString);
       verify(printStream).println(contains("Withdraw Successful"));
    }

    @Test
    public void whenWithdrawIsMoreThanAvailableBalanceThenPrintUnsuccessful() {
        String accountInfoString = "Account Number: #0002\nThe Current Balance is: 0.00";
        this.createAccountPattern("Bill");
      
        this.withdrawOrDepositInput("2", 1.00);
        accountManagement.makeWithdraw();

        verify(printStream).println(contains("Withdraw Unsuccessful"));
        verify(printStream).println(accountInfoString);

    }
}