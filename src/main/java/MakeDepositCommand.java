public class MakeDepositCommand implements Command{

    private AccountManagement accountManagement;

    public MakeDepositCommand(AccountManagement accountManagement2) {
        this.accountManagement = accountManagement2;
    }

    @Override
    public void execute() {
        this.accountManagement.makeDeposit();
    }
}
