package composite;

public class Client {
    public static void main(String[] args) {
        Branch root = new Branch("root");
        root.add(new Leaf("green"));
        root.add(new Leaf("green"));

        Branch b1 = new Branch("level 1");
        b1.add(new Leaf("yellow"));
        b1.add(new Leaf("yellow"));
        b1.add(new Leaf("yellow"));

        root.add(b1);

        System.out.println(root.describe(1));
    }
}
