package unionfind;

public class QuickFind extends UnionFind {

    public QuickFind(int N) {
        super(N);
    }

    public boolean connected(int p, int q) {
        return bucket[p] == bucket[q];
    }

    public void union(int p, int q) {
        int pid = bucket[p];
        int qid = bucket[q];

        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == pid)
                bucket[i] = qid;
        }
    }
}
