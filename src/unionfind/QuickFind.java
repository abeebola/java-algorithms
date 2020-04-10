package unionfind;

public class QuickFind {
    private int[] bucket;

    public QuickFind(int N) {
        bucket = new int[N];
        // Initialise array values
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = i;
        }
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int value : bucket) {
            stringBuilder.append(
                    String.format("%s ", value)
            );
        }

        return stringBuilder.toString().trim();
    }
}
