package state.structural;

public class GoldenState extends SilverState {
    GoldenState() {
        name = "gold";
    }

    @Override
    public void handle(Account account) {
        account.setState(new RedState());
    }
}
