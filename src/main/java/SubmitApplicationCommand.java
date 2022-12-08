
public class SubmitApplicationCommand implements Command{
    private AccountManagement accountManagement;

    public SubmitApplicationCommand(AccountManagement accountManagement2) {
        this.accountManagement = accountManagement2;
    }

    @Override
    public void execute() {
        accountManagement.submit();
    }

}
