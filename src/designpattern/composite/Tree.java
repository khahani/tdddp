package designpattern.composite;

public abstract class Tree {
    String color;

    Tree(String color) {
        this.color = color;
    }

    abstract void add(Tree b);

    public abstract String describe(int depth);
}
