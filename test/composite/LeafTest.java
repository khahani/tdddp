package composite;

import org.junit.Assert;
import org.junit.Test;

public class LeafTest {
    @Test
    public void empty_leaf_test() throws RuntimeException {
        Leaf l = new Leaf("");
        Assert.assertEquals("", l.describe(1));
    }

    @Test
    public void leaf_with_color_describe_test() throws RuntimeException {
        Leaf l = new Leaf("green");
        Assert.assertEquals("-green", l.describe(1));
    }

    @Test(expected = Leaf.CanNotAddLeafToLeafException.class)
    public void call_add_for_leaf_test() throws RuntimeException {
        Leaf l = new Leaf("");
        l.add(new Leaf("red"));
    }
}
