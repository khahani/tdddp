package javap.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class C {
    private static final Map<String, Integer> wdayNumber =
            new HashMap<>();

    static {
        int wdayno = 0;
        String[] wdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
                "Saturday", "Sunday"};
        for (String wday :
                wdays) {
            wdayNumber.put(wday, wdayno++);
        }
    }

    public static int wdayno(String wday) {
        Integer res = wdayNumber.get(wday);
        return res == null ? -1 : res;
    }

    public static Iterable<Integer> fromTo(final int m, final int n){
        class FromToIterator implements Iterator<Integer> {
            private int i = m;

            @Override
            public boolean hasNext() {
                return i <= n;
            }

            @Override
            public Integer next() {
                if (i <= n)
                    return i++;
                else
                    throw new NoSuchElementException();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        class FromToIterable implements Iterable<Integer>{

            @Override
            public Iterator<Integer> iterator() {
                return new FromToIterator();
            }
        }
        return new FromToIterable();
    }

    public static Iterable<Integer> fromToStream(final int m, final int n){
        return ()-> IntStream.rangeClosed(m, n).iterator();
    }
}
