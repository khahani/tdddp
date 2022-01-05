import org.junit.Test;

import static org.junit.Assert.*;

public class PercolationTest {

    private static final int HEAD_AND_TAIL = 2;
    final int N = 6;

    @Test(expected = IllegalArgumentException.class)
    public void initializePercolationWithNegativeNumber_ThrowException() {
        Percolation p = new Percolation(-1);
    }

    @Test
    public void percolateWithZeroOpenSiteTest() {
        Percolation p = new Percolation(1);
        Percolation p2 = new Percolation(2);
        assertFalse(p.percolates());
        assertFalse(p2.percolates());
    }

    @Test
    public void openAndFullArePersistence() {
        Percolation p = new Percolation(4);
        assertEquals(0, p.numberOfOpenSites());

        assertPersistence(p, 2, 2, "Ofp", 1);
        assertPersistence(p, 3, 3, "Ofp", 2);
        assertPersistence(p, 1, 3, "OFp", 3);

        assertFalse(p.isFull(2, 2));
        assertFalse(p.isFull(3, 3));

        assertPersistence(p, 2, 3, "OFp", 4);
        assertPersistence(p, 3, 1, "Ofp", 5);
        assertPersistence(p, 2, 1, "OFp", 6);

        assertTrue(p.isFull(3, 1));

        assertPersistence(p, 4, 2, "Ofp", 7);
        assertFalse(p.isOpen(3, 2));

        assertPersistence(p, 1, 1, "OFp", 8);
//        assertPersistence(p, 4,1, "OFP", 9);
        assertPersistence(p, 3, 4, "OFp", 9);
        assertPersistence(p, 4, 4, "OFP", 10);

        assertTrue(p.isFull(4, 2));

    }

    /**
     * test
     *
     * @param command OoFfPp
     */
    private void assertPersistence(Percolation p, int row, int col, String command, int numberOfOpenSites) {
        if (command.length() < 3)
            throw new IllegalArgumentException("Wrong command: OoFfPp");

        p.open(row, col);

        final boolean open = p.isOpen(row, col);
        if (command.charAt(0) == 'O') {
            assertTrue(open);
        } else if (command.charAt(0) == 'o') {
            assertFalse(open);
        } else {
            throw new IllegalArgumentException("Wrong command: Oo");
        }

        final boolean full = p.isFull(row, col);
        if (command.charAt(1) == 'F') {
            assertTrue(full);
        } else if (command.charAt(1) == 'f') {
            assertFalse(full);
        } else {
            throw new IllegalArgumentException("Wrong command: Ff");
        }

        final boolean percolates = p.percolates();
        if (command.charAt(2) == 'P') {
            assertTrue(percolates);
        } else if (command.charAt(2) == 'p') {
            assertFalse(percolates);
        } else {
            throw new IllegalArgumentException("Wrong command: Pp");
        }

        assertEquals(numberOfOpenSites, p.numberOfOpenSites());
    }

//
//    @Test
//    public void requestedIndexWithRowAndColumn_returnCorrect() {
//        int index = 1;
//        for (int row = 1; row <= N; row++) {
//            for (int col = 1; col <= N; col++) {
//                assertEquals(index, p.getIndex(row, col));
//                index++;
//            }
//        }
//        assertEquals(16, p.getIndex(N, N));
//        assertEquals(1, p.getIndex(1, 1));
//    }
//
//    @Test
//    public void getTailIndex_returnCorrect() {
//        assertEquals(17, p.getTailIndex());
//    }
//
//    @Test
//    public void initializePercolation_topAndBottomAreConnectedToTopAndTail() {
//        for (int i = 1; i <= p.getN(); i++)
//            assertEquals(p.getUf().find(0), p.getUf().find(i));
//    }
//
//    @Test
//    public void WhenASiteOpens_NumberOfSitesIncreases() {
//        p.open(1, 1);
//        assertEquals(1 + HEAD_AND_TAIL, p.numberOfOpenSites());
//    }
//
//    @Test
//    public void openingASite_ConnectsToItsNeighbors() {
//        p.open(1, 1);
//        p.open(1, 2);
//        assertEquals(p.findTest(p.getIndex(1, 1)), p.findTest(p.getIndex(1, 2)));
//        p.open(2, 3);
//    }
//
//    @Test
//    public void givenAConnectedSiteToTop_detectedAsFullSite() {
//        p.open(2, 2);
//        assertFalse(p.isFull(2, 2));
//        p.open(1, 2);
//        assertTrue(p.isFull(2, 2));
//    }
//
//    @Test
//    public void givenAPathFromTopToBottom_Percolates() {
//        p.open(1, 1);
//        p.open(2, 1);
//        p.open(3, 1);
//        p.open(4, 1);
//        assertTrue(p.percolates());
//    }
//
//    @Test
//    public void troubleshut() {
//        //region init data
//        p.open(5, 3);
//        p.open(3, 3);
//        p.open(1, 5);
//        p.open(2, 3);
//        p.open(7, 4);
//        p.open(1, 3);
//        p.open(4, 1);
//        p.open(2, 1);
//        p.open(7, 1);
//        p.open(3, 7);
//        p.open(7, 7);
//        p.open(4, 7);
//        p.open(6, 6);
//        p.open(7, 6);
//        p.open(2, 2);
//        p.open(7, 5);
//        p.open(6, 7);
//        p.open(2, 5);
//        p.open(3, 5);
//        p.open(3, 1);
//        p.open(6, 1);
//        p.open(6, 3);
//        p.open(1, 1);
//        p.open(2, 6);
//        p.open(4, 5);
//        p.open(3, 6);
//        p.open(1, 7);
//        p.open(5, 7);
//        p.open(5, 4);
//        p.open(1, 2);
//        p.open(6, 5);
//        p.open(6, 2);
//        p.open(2, 7);
//        p.open(4, 4);
//        p.open(4, 6);
//        p.open(5, 1);
//        p.open(7, 2);
//        p.open(4, 2);
//        p.open(1, 4);
//        p.open(3, 4);
//        p.open(7, 3);
//        p.open(2, 4);
//        p.open(3, 2);
//        p.open(6, 4);
//        p.open(1, 6);
//        p.open(5, 2);
//        p.open(5, 5);
//        p.open(5, 6);
//        p.open(4, 3);
//        //endregion
//
//        assertTrue(p.percolates());
//
//    }

}