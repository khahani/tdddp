package algorithm.percolation.unionfind;

public class QuickFind {
    private final int[] array;

    public QuickFind(final int n) {
        this.array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
    }

    public static void main(String[] args) {
        QuickFind uf = new QuickFind(10);
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
        return array[p];
    }

    public void union(int p, int q) {
        validate(p);
        validate(q);

        final int rootP = array[p];
        final int rootQ = array[q];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == rootP)
                array[i] = rootQ;
        }
    }

    private void validate(final int p) {
        int n = array.length;
        if (p < 0 || p >= n)
            throw new IllegalArgumentException("Index " + p + " is not between 0 and " + (n - 1));
    }
}
