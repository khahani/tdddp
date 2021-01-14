package composite;

import java.util.ArrayList;

public class Branch extends Tree {
    private ArrayList<Tree> children;

    Branch(String color) {
        super(color);
        children = new ArrayList<>();
    }

    //todo: As a practice handle leaves count
//    public int leavesCount() {
//        return children.size();
//    }

    @Override
    void add(Tree b) {
        children.add(b);
    }

    @Override
    public String describe(int depth) {

        StringBuilder descBuilder = new StringBuilder();
        String line = "*".repeat(depth);
        descBuilder.append(line).append(color).append("\n");

        if (!children.isEmpty())
            for (Tree b : children) {
                descBuilder.append(b.describe(depth + 1));
                descBuilder.append("\n");
            }

        String result = descBuilder.toString();
        int lastNewLine = result.lastIndexOf("\n");
        result = result.substring(0, lastNewLine);

        return result;
    }

}
