package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unionfind.QuickUnionWeighted;

import static org.junit.jupiter.api.Assertions.*;

class QuickUnionWeightedTest {

    private QuickUnionWeighted qw;

    @BeforeEach
    void setUp() {
        qw = new QuickUnionWeighted(10);
    }

    @Test
    void connected() {
        assertFalse(qw.connected(2, 3));
        assertTrue(qw.connected(0, 0));
        assertFalse(qw.connected(9, 3));
    }

    @Test
    void union() {
        qw.union(4, 3);
        qw.union(3, 8);
        qw.union(6, 5);
        qw.union(9, 4);
        qw.union(2, 1);
        qw.union(5, 0);
        qw.union(7, 2);
        qw.union(6, 1);
        qw.union(7, 3);

        assertTrue(qw.connected(9, 3));
        assertTrue(qw.connected(6, 0));
        assertTrue(qw.connected(1, 5));

        // Test final tree structure
        // Should be [6, 2, 6, 4, 6, 6, 6, 2, 4, 4]
        int[] finalBucket = qw.getBucket();

        assertEquals(6, finalBucket[2]);
        assertEquals(4, finalBucket[3]);
        assertEquals(6, finalBucket[5]);
        assertEquals(4, finalBucket[8]);
    }

    @Test
    void root() {
        qw.union(4, 0);
        qw.union(6, 3);
        qw.union(6, 4);

        assertEquals(6, qw.root(4));
        assertEquals(6, qw.root(0));
    }
}