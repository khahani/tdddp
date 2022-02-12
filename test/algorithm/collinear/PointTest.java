package algorithm.collinear;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class PointTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void GivenExceededXandYLimitation_constructor_thenXandYareBetweenZeroToMaxLimit() {
        Point p = new Point(Short.MAX_VALUE + 1, -1);
        Point p2 = new Point(-1, Short.MAX_VALUE + 1);

        assertXY(p, Short.MAX_VALUE, 0);
        assertXY(p2, 0, Short.MAX_VALUE);
    }

    private void assertXY(Point p, int expectedX, int expectedY) {
        try {
            final String x = "x";
            final String y = "y";
            final Class<? extends Point> pClass = p.getClass();
            final Field pX = pClass.getDeclaredField(x);
            pX.setAccessible(true);
            final Field pY = pClass.getDeclaredField(y);
            pY.setAccessible(true);
            final int p1x = (int) pX.get(p);
            final int p1y = (int) pY.get(p);

            assertEquals(expectedX, p1x);
            assertEquals(expectedY, p1y);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void GivenTwoSamePoint_compare_thenReturn0() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        assertEquals(0, p1.compareTo(p2));
    }

    @Test
    public void GivenSmallerPoint_compare_thenReturnNegativeOne() {
        Point bigger = new Point(1, 1);
        Point small1 = new Point(0, 0);
        Point small2 = new Point(0, 1);

        assertEquals(-1, small1.compareTo(bigger));
        assertEquals(-1, small2.compareTo(bigger));
        assertEquals(1, bigger.compareTo(small1));
        assertEquals(1, bigger.compareTo(small2));
    }

    @Test
    public void GivenHorizontalPoint_slope_thenReturnPositiveZero() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 1);
        assertEquals(+0.0, p1.slopeTo(p2), 0.0);
    }

    @Test
    public void GivenSelfPoint_slope_thenReturnNegativeInfinitive() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        assertEquals(Double.NEGATIVE_INFINITY, p1.slopeTo(p2), 0.0);
    }

    @Test
    public void givenTwoPoint_slope_thenReturnTheSlope() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(4, 7);

        assertEquals(1, p1.slopeTo(p2), 0.0);
        assertEquals(1.75, p1.slopeTo(p3), 0.0);
    }

    @Test
    public void getComparator() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        Point p3 = new Point(0, 0);
        Comparator<Point> cmp = p1.slopeOrder();
        assertEquals(0, cmp.compare(p1, p2));
        assertEquals(0, cmp.compare(p2, p3));
    }
}