package javap.reflection;

import java.lang.reflect.*;

public class ReflectionTest {
    public static void main(String[] args) {
        example209();
        example210();
        example211();
        example212();
    }

    private static void example212() {
        Class<K1> k1o = K1.class;
        final Method[] mod = k1o.getDeclaredMethods();
        for (Method m :
                mod) {
            if (Modifier.isPrivate(m.getModifiers()))
                System.out.println(m);
        }
    }

    private static void example211() {
        Class<K1> k1o = K1.class;
        try {
            final Constructor<K1> ck1o = k1o.getConstructor(int.class);
            Constructor cco = ck1o;
            final K1 k1 = ck1o.newInstance(42);
            final Object k12 = cco.newInstance(56);

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void example210() {
        Class<K1> k1o = K1.class;
        try {
            final Method m1o = k1o.getMethod("m1"),
                    m1io = k1o.getMethod("m1", int.class);
            K2 o2 = new K2();
            m1o.invoke(o2);
            m1io.invoke(o2, 117);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void example209() {
        Class<K2> k2o = K2.class;
        try {
            final Field f1o = k2o.getField("f1");
            K2 o2 = new K2();
            f1o.set(o2, 117);
            System.out.format("Value of o2.f1 = %d%n", f1o.get(o2));
            Class<K1> k1o = K1.class;
            final Field f21 = k1o.getDeclaredField("f2");
            K1 o1 = new K1();
            f21.set(o1, 12);
            System.out.format("Value of o1.f2 = %d%n", f21.get(o1));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
