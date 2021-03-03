package designpattern.state.structural;

public class SilverState extends State {

    SilverState() {
        super();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void handle(Account account) {
        account.setState(new GoldenState());
    }
}
