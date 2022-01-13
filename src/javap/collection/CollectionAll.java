package javap.collection;

import java.util.*;

public class CollectionAll {
    public static void main(String[] args) {
        List<String> list1 = new LinkedList<>();
        list1.add("list");
        list1.add("dup");
        list1.add("x");
        list1.add("dup");
        traverse(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("list");
        list2.add("dup");
        list2.add("x");
        list2.add("dup");
        traverse(list2);

        System.out.println("**");
        Set<String> ss = new HashSet<>(list1);
        traverse(ss);
        System.out.println("**");

        Set<String> set1 = new HashSet<>();
        set1.add("set");
        set1.add("dup");
        set1.add("x");
        set1.add("dup");
        traverse(set1);

        Set<String> set2 = new LinkedHashSet<>();
        set2.add("set");
        set2.add("dup");
        set2.add("x");
        set2.add("dup");
        traverse(set1);

        SortedSet<String> set3 = new TreeSet<>();
        set3.add("set");
        set3.add("dup");
        set3.add("x");
        set3.add("dup");
        traverse(set3);

        Map<String, String> map1 = new IdentityHashMap<>();
        map1.put("map", "J");
        map1.put("dup", "K");
        map1.put("x", "M");
        map1.put("dup", "L");
        traverse(map1.keySet());
        traverse(map1.values());

        Map<String, String> map2 = new HashMap<>();
        map2.put("map", "J");
        map2.put("dup", "K");
        map2.put("x", "M");
        map2.put("dup", "L");
        traverse(map2.keySet());
        traverse(map2.values());

        Map<String, String> map3 = new LinkedHashMap<>();
        map3.put("map", "J");
        map3.put("dup", "K");
        map3.put("x", "M");
        map3.put("dup", "L");
        traverse(map3.keySet());
        traverse(map3.values());

        Map<String, String> map4 = new TreeMap<>();
        map4.put("map", "J");
        map4.put("dup", "K");
        map4.put("x", "M");
        map4.put("dup", "L");
        traverse(map4.keySet());
        traverse(map4.values());

    }

    private static void traverse(Collection<String> coll) {
        for (String s : coll)
            System.out.printf("%1$s, ", s);

        System.out.println();
    }
}
