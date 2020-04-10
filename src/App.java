import unionfind.QuickFind;

public class App {
    public static void main(String[] args) {
        System.out.println("App started...");
        QuickFind uf = new QuickFind(10);

        uf.union(5, 0);
        uf.union(6, 5);

        uf.union(2, 1);
        uf.union(7, 2);

        uf.union(3, 8);
        uf.union(4, 3);
        uf.union(9, 4);

        System.out.println(String.format("Array values: %s", uf.toString()));
    }
}
