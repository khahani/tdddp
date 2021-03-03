package designpattern.state.structural;

public class RedState extends SilverState {
    RedState() {
        name = "red";
    }

    @Override
    public void handle(Account account) {
        account.setState(new SilverState());
    }
}
