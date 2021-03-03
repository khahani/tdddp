package designpattern.state.structural;

public abstract class State {
    String name;

    State() {
        name = "silver";
    }

    public abstract String getName();

    public abstract void handle(Account account);
}
