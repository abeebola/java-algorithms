package unionfind;

abstract class UnionFind {
    int[] bucket;

    UnionFind(int N) {
        bucket = new int[N];
        // Initialise array values
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = i;
        }
    }

    abstract public boolean connected(int p, int q);

    abstract public void union(int p, int q);

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
