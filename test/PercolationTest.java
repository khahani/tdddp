import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PercolationTest {

    final int N = 4;
    Percolation p = new Percolation(N);

    @Test(expected = IllegalArgumentException.class)
    public void initializePercolationWithNegativeNumber_ThrowException() {
        Percolation p = new Percolation(-1);
    }

    @Test
    public void givenNItem_MatrixOfNN_ClosedSite_Creates() {

        assertEquals(18, p.getSites().length);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17}, p.getSites());
        assertArrayEquals(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, p.getStatus());
        assertArrayEquals(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, p.getWeights());
    }

    @Test
    public void requestedIndexWithRowAndColumn_returnCorrect() {
        int index = 1;
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= N; col++) {
                assertEquals(index, p.getIndex(row, col));
                index++;
            }
        }
        assertEquals(16, p.getIndex(N, N));
        assertEquals(1, p.getIndex(1, 1));
    }

    @Test
    public void getTailIndex_returnCorrect() {
        assertEquals(17, p.getTailIndex());
    }
}