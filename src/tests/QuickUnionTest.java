package tests;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import unionfind.QuickUnion;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class QuickUnionTest {

    private QuickUnion qu;

    @Test
    @Order(1)
    void testToString() {
    }

    @Test
    @Order(2)
    void connected() {
        qu = new QuickUnion(10);
        assertFalse(qu.connected(2, 3));
        assertTrue(qu.connected(0, 0));
    }

    @Test
    @Order(3)
    void union() {
        qu = new QuickUnion(10);

        qu.union(5, 0);
        qu.union(6, 5);
        qu.union(4, 8);
        qu.union(3, 7);
        qu.union(4, 0);

        assertTrue(qu.connected(8, 5));
        assertTrue(qu.connected(6, 0));
    }

    @Test
    @Order(4)
    void root() {
        qu = new QuickUnion(10);
        qu.union(4, 0);
        qu.union(6, 3);
        qu.union(6, 4);
        assertEquals(qu.root(0), 0);
        assertEquals(qu.root(4), 0);
        assertEquals(qu.root(6), 0);
    }
}