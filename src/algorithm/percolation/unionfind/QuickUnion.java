package algorithm.percolation.unionfind;

public class QuickUnion {

    private final int[] array;

    public QuickUnion(final int n) {
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
    }

    public static void main(String[] args) {
        QuickUnion uf = new QuickUnion(10);
        uf.union(1, 2);
        System.out.println(uf.find(1) == uf.find(2));
        uf.union(4, 3);
        System.out.println(uf.find(4) == uf.find(3));
        uf.union(1, 4);
        System.out.println(uf.find(1) == uf.find(3));

        System.out.println(uf.find(1) != uf.find(8));
    }

    public int find(int p) {
        validate(p);
        while (array[p] != p) {
            p = array[p];
        }
        return p;
    }

    public void union(int p, int q) {
        validate(p);
        validate(q);

        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ)
            return;

        array[rootP] = rootQ;
    }

    private void validate(int p) {
        final int n = array.length;
        if (p < 0 || p >= n)
            throw new IllegalArgumentException("Index " + p + " is not between 0 and " + (n - 1));
    }
}
