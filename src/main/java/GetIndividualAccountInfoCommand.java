
public class GetIndividualAccountInfoCommand implements Command {

    AccountManagement accountManagement;
    public GetIndividualAccountInfoCommand(AccountManagement accountManagement2) {
        this.accountManagement = accountManagement2;
    }

    @Override
    public void execute() {
        accountManagement.getIndividualAccountInfo();      
    }

}
