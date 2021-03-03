package designpattern.state.structural;

class Account {

    private State state;

    Account(State state) {
        this.state = state;
    }

    String getState() {
        return state.getName();
    }

    void setState(State pState) {
        state = pState;
    }

    void request() {
        state.handle(this);
    }
}
