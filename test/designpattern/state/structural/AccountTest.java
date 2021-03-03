package designpattern.state.structural;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test
    public void new_account_is_silver_state_test() {
        Account a = new Account(new SilverState());
        Assert.assertEquals("silver", a.getState());
    }

    @Test
    public void when_first_request_comming_state_changes_to_gold_test() {
        Account a = new Account(new SilverState());
        a.request();
        Assert.assertEquals("gold", a.getState());
    }

    @Test
    public void when_third_request_comming_state_changes_to_red() {
        Account a = new Account(new SilverState());
        a.request();
        a.request();
        Assert.assertEquals("red", a.getState());
    }

    @Test
    public void when_fourth_request_comming_state_back_to_silver_test() {
        Account a = new Account(new SilverState());
        a.request();
        a.request();
        a.request();
        Assert.assertEquals("silver", a.getState());
    }
}
