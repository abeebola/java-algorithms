package tests;

import unionfind.QuickFind;

import static org.junit.jupiter.api.Assertions.*;

class QuickFindTest {
    private QuickFind uf;

    @org.junit.jupiter.api.Test
    void connected() {
        uf = new QuickFind(10);

        uf.union(5, 0);
        uf.union(6, 5);

        assertFalse(uf.connected(2, 3));
        assertFalse(uf.connected(7, 8));
    }

    @org.junit.jupiter.api.Test
    void union() {
        uf = new QuickFind(10);

        uf.union(5, 0);
        uf.union(6, 5);

        assertTrue(uf.connected(5, 0));
        assertTrue(uf.connected(6, 0));
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        uf = new QuickFind(4);

        uf.union(3, 1);
        assertEquals(uf.toString(), "0 1 2 1");
    }
}