package algorithm.percolation.unionfind;

public class WeightedAndPathCompressionUnionFind {
    private final int[] array;
    private final int[] rank;

    public WeightedAndPathCompressionUnionFind(final int n) {
        array = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
            rank[i] = 1;
        }
    }

    public static void main(String[] args) {
        WeightedAndPathCompressionUnionFind uf = new WeightedAndPathCompressionUnionFind(10);
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
            array[p] = array[array[p]];
            p = array[p];
        }
        return p;
    }

    public void union(int p, int q) {
        validate(p);
        validate(q);

        final int rootP = find(p);
        final int rootQ = find(q);

        if (rootP == rootQ)
            return;

        if (rank[rootP] > rank[rootQ]) {
            array[rootQ] = rootP;
            rank[rootP] += rank[rootQ];
        } else {
            array[rootP] = rootQ;
            rank[rootQ] += rank[rootP];
        }
    }

    private void validate(int p) {
        final int n = array.length;
        if (p < 0 || p >= n)
            throw new IllegalArgumentException("Index " + p + " is not between 0 and " + (n - 1));
    }

}
