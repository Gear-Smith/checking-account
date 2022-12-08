
public class MakeWithdrawCommand implements Command{

    private AccountManagement accountManagement;

    public MakeWithdrawCommand(AccountManagement accountManagement2) {
        this.accountManagement = accountManagement2;
    }

    @Override
    public void execute() {
        accountManagement.makeWithdraw();
    }
}
