package command;

import org.junit.Assert;
import org.junit.Test;

public class CommandTest {

    @Test
    public void action_test() {
        Receiver r = new Receiver();
        Assert.assertEquals("action called", r.action());
    }


}
