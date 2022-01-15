package algorithm.queue;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ArrayQueueTest {

    private static class A {
        public static final int head = 0;
        public static final int tail = 0;
        public static final Object[] array = new Object[]{null};

        public static ArrayQueue<Integer> create() {
            return new ArrayQueue<>();
        }
    }

    private static class B {
        public static final int head = 0;
        public static final int tail = 1;
        public static final Object[] array = new Object[]{1, null};

        public static ArrayQueue<Integer> create() {
            final ArrayQueue<Integer> q = new ArrayQueue<>();
            q.enqueue(1);
            return q;
        }

        public static int dequeue() {
            return 1;
        }
    }

    private static class C {
        public static final int head = 0;
        public static final int tail = 2;
        public static final Object[] array = new Object[]{1, 2, null, null};
        public static ArrayQueue<Integer> create(){
            final ArrayQueue<Integer> q = B.create();
            q.enqueue(2);
            return q;
        }
    }

    @Test
    public void testQueue(){
        ArrayQueue<Integer> q = new ArrayQueue<>();
        assertTrue(q.isEmpty());
        q.enqueue(1);
        assertFalse(q.isEmpty());
        int i1 = q.dequeue();
        assertEquals(1, i1);
        for (int i = 0; i < 100; i++) {
            q.enqueue(i);
        }
        for (int i = 99; i >= 0 ; i--) {
            int item = q.dequeue();
            assertEquals(i, item);
        }
        assertTrue(q.isEmpty());
    }

    @Test
    public void givenC_dequeue_thenB(){
        final ArrayQueue<Integer> q = C.create();
        int item = q.dequeue();
        assertWithAnState(q, B.head, B.tail, B.array);
        assertEquals(1, item);
    }

    @Test
    public void givenB_enqueue_thenD(){
        final ArrayQueue<Integer> q = B.create();
        q.enqueue(2);
        assertWithAnState(q, C.head, C.tail, C.array);
    }

    @Test
    public void givenB_dequeue_thenA() {
        final ArrayQueue<Integer> q = B.create();
        int item = q.dequeue();
        assertWithAnState(q, A.head, A.tail, A.array);
        assertEquals(B.dequeue(), item);
    }

    @Test
    public void givenA_enqueue_thenB() {
        final ArrayQueue<Integer> q = A.create();
        q.enqueue(1);
        assertWithAnState(q, B.head, B.tail, B.array);
    }

    @Test(expected = NoSuchElementException.class)
    public void givenA_callIsEmpty_thenTrue() {
        ArrayQueue<Integer> q = A.create();
        assertTrue(q.isEmpty());
        q.dequeue();
    }

    @Test
    public void initialize_thenA() {
        ArrayQueue<Integer> q = A.create();
        assertWithAnState(q, A.head, A.tail, A.array);
    }

    private void assertWithAnState(ArrayQueue<Integer> q, int expectedHead, int expectedTail, Object[] expectedArray) {
        final Class<? extends ArrayQueue> qClass = q.getClass();
        try {
            final Field head = qClass.getDeclaredField("head");
            head.setAccessible(true);
            assertEquals(expectedHead, head.get(q));

            final Field tail = qClass.getDeclaredField("tail");
            tail.setAccessible(true);
            assertEquals(expectedTail, tail.get(q));

            final Field array = qClass.getDeclaredField("array");
            array.setAccessible(true);
            assertArrayEquals(expectedArray, (Object[]) array.get(q));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}