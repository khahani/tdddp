package algorithm.collinear;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BruteCollinearPointsTest {

    private final Class<? extends CollinearPoints> type;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    public BruteCollinearPointsTest(Class<? extends CollinearPoints> theType) {
        type = theType;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{BruteCollinearPoints.class},
                {FastCollinearPoints.class}});
    }

    private CollinearPoints create(Point[] points) {
        if (type.isAssignableFrom(BruteCollinearPoints.class))
            return new BruteCollinearPoints(points);
        else
            return new FastCollinearPoints(points);
    }

    @Test
    public void givenFourPoint_numberOfSegments_thenReturnFour() {
        final Point[] points = {
                new Point(0, 0),
                new Point(1, 1),
                new Point(2, 2),
                new Point(3, 3)
        };
        CollinearPoints b = create(points);
        assertEquals(1, b.numberOfSegments());
    }

    @Test
    public void givenFivePoint_FindTheNumberOfSegments() {
        final Point[] points = {
                new Point(0, 0),
                new Point(1, 1),
                new Point(3, 3),
                new Point(8, 2),
                new Point(2, 2),
                new Point(4, 6),
                new Point(6, 4),
                new Point(10, 0)
        };
        CollinearPoints b = create(points);

        assertEquals(2, b.numberOfSegments());
    }

    @Test
    public void givenNull_throwIllegalException() {
        thrown.expect(IllegalArgumentException.class);
        CollinearPoints b = create(null);
    }

    @Test
    public void givenNullPoint_thrownIllegalException() {
        thrown.expect(IllegalArgumentException.class);
        CollinearPoints b = create(new Point[]{null});
    }

    @Test
    public void givenDuplicatePoint_thrownIllegalException() {
        thrown.expect(IllegalArgumentException.class);
        Point[] points = new Point[2];
        points[0] = new Point(1, 1);
        points[1] = new Point(1, 1);
        CollinearPoints b = create(points);
    }

}