package designpattern.composite;


import org.junit.Assert;
import org.junit.Test;

public class BranchTest {

    @Test
    public void branch_without_leaf_test() throws RuntimeException {
        Tree b = new Branch("root");
        Assert.assertEquals("*root", b.describe(1));
    }

    @Test
    public void add_a_leaf_to_branch_test() throws RuntimeException {
        Tree b = new Branch("root");
        b.add(new Leaf("green"));

        Assert.assertEquals("*root\n--green", b.describe(1));
    }

    @Test
    public void add_two_leaf_to_branch_test() throws RuntimeException {
        Tree b = new Branch("root");

        b.add(new Leaf("green"));
        b.add(new Leaf("red"));

        Assert.assertEquals("*root\n--green\n--red", b.describe(1));
    }

    @Test
    public void add_three_leaf_to_branch_test() throws RuntimeException {
        Tree b = new Branch("root");

        b.add(new Leaf("green"));
        b.add(new Leaf("red"));
        b.add(new Leaf("orange"));

        Assert.assertEquals("*root\n--green\n--red\n--orange", b.describe(1));
    }

    @Test
    public void add_an_empty_branch_to_root_branch_test() throws RuntimeException {
        Tree root = new Branch("root");
        Tree child = new Branch("sub");

        root.add(child);

        Assert.assertEquals("*root\n**sub", root.describe(1));
    }

    @Test
    public void add_a_branch_with_a_leaf_to_root_branch_test() throws RuntimeException {
        Tree root = new Branch("root");
        Tree child = new Branch("sub");
        child.add(new Leaf("green"));

        root.add(child);

        Assert.assertEquals("*root\n**sub\n---green", root.describe(1));
    }

    @Test
    public void add_a_branch_with_2_leaf_to_root_branch_test() throws RuntimeException {
        Tree root = new Branch("root");
        Tree child = new Branch("sub");
        child.add(new Leaf("green"));
        child.add(new Leaf("red"));

        root.add(child);

        Assert.assertEquals("*root\n**sub\n---green\n---red", root.describe(1));
    }

    @Test
    public void add_2_empty_branch_to_root_branch_test() throws RuntimeException {
        Tree root = new Branch("root");
        Tree child1 = new Branch("sub1");
        Tree child2 = new Branch("sub2");

        root.add(child1);
        root.add(child2);

        Assert.assertEquals("*root\n**sub1\n**sub2", root.describe(1));
    }

    @Test
    public void add_4_branch_that_each_have_leaves_to_root_branch_test() throws RuntimeException {
        Tree root = new Branch("root");
        root.add(new Leaf("brown"));
        root.add(new Leaf("brown"));

        Tree child1 = new Branch("sub1");
        child1.add(new Leaf("green"));
        child1.add(new Leaf("green"));
        child1.add(new Leaf("green"));

        Tree child2 = new Branch("sub2");
        child2.add(new Leaf("red"));
        child2.add(new Leaf("red"));
        child2.add(new Leaf("red"));
        child2.add(new Leaf("red"));
        child2.add(new Leaf("red"));

        Tree child3 = new Branch("sub3");
        child3.add(new Leaf("orange"));
        child3.add(new Leaf("orange"));
        child3.add(new Leaf("orange"));
        child3.add(new Leaf("orange"));

        root.add(child1);
        root.add(child2);
        root.add(child3);
        String expected = "*root\n--brown\n--brown\n**sub1\n---green\n---green\n---green\n**sub2\n---red\n---red\n---red\n---red\n---red\n**sub3\n---orange\n---orange\n---orange\n---orange";
        Assert.assertEquals(expected, root.describe(1));
    }

    @Test
    public void add_second_level_deep_branch_to_root_test() throws RuntimeException {

        Tree root = new Branch("root");
        Tree l1 = new Branch("level1");
        Tree l2 = new Branch("level2");

        root.add(l1);
        l1.add(l2);

        String exp = "*root\n**level1\n***level2";
        Assert.assertEquals(exp, root.describe(1));
    }

    @Test
    public void add_second_level_deep_branch_with_leaves_to_root_test() throws RuntimeException {

        Tree root = new Branch("root");
        root.add(new Leaf("brown"));
        root.add(new Leaf("brown"));

        Tree l1s1 = new Branch("level1_sub1");
        l1s1.add(new Leaf("green"));
        l1s1.add(new Leaf("green"));
        l1s1.add(new Leaf("green"));

        Tree l1s2 = new Branch("level1_sub2");
        l1s2.add(new Leaf("red"));
        l1s2.add(new Leaf("red"));

        Tree l2s1 = new Branch("level2_sub1");
        l2s1.add(new Leaf("orange"));
        l2s1.add(new Leaf("orange"));
        l2s1.add(new Leaf("orange"));

        root.add(l1s1);
        root.add(l1s2);
        l1s1.add(l2s1);

        String exp = "*root\n--brown\n--brown\n**level1_sub1\n---green\n---green\n---green\n***level2_sub1\n----orange\n----orange\n----orange\n**level1_sub2\n---red\n---red";
        Assert.assertEquals(exp, root.describe(1));
    }

}















