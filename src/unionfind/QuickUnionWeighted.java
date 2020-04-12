package unionfind;

import java.util.Arrays;

public class QuickUnionWeighted extends QuickUnion {
    int[] sizeTracker;

    public QuickUnionWeighted(int N) {
        super(N);
        sizeTracker = new int[N];
        // Set initial size of all nodes to 1
        Arrays.fill(sizeTracker, 1);
    }

    @Override
    public void union(int p1, int p2) {
        int firstRoot = root(p1);
        int secondRoot = root(p2);

        if (firstRoot == secondRoot) return;

        if (sizeTracker[p1] >= sizeTracker[p2]) {
            bucket[secondRoot] = firstRoot;
            sizeTracker[firstRoot] += sizeTracker[secondRoot];
        } else {
            bucket[firstRoot] = secondRoot;
            sizeTracker[secondRoot] += sizeTracker[firstRoot];
        }
    }

    @Override
    public int root(int index) {
        int parent = bucket[index];
        while (index != parent) {
            index = parent;
            parent = bucket[parent];
        }

        return parent;
    }
}
