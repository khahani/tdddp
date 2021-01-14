package composite;

public class Leaf extends Branch {

    Leaf(String color) {
        super(color);
    }

    public String describe(int depth) {
        if (color == null || color.isEmpty())
            return "";
        return "-".repeat(depth) + color;
    }

    @Override
    void add(Tree b) {
        throw new CanNotAddLeafToLeafException();
    }

    static class CanNotAddLeafToLeafException extends RuntimeException {
    }
}
