package unionfind;

public class QuickUnion extends UnionFind {
    public QuickUnion(int N) {
        super(N);
    }

    public boolean connected(int p1, int p2) {
        return root(p1) == root(p2);
    }

    public void union(int p1, int p2) {
        int newRoot = root(p2);
        int oldRootIndex = root(p1);
        bucket[oldRootIndex] = newRoot;
    }

    public int root(int index) {
        int parent = bucket[index];
        while (index != parent) {
            index = parent;
            parent = bucket[parent];
        }
        return parent;
    }
}
