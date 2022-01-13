package javap.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetMembership {
    final static String[] keywordarray =
            {"abstract", "assert", "boolean", "break", "byte", "while"};

    final static Set<String> keywords =
            new HashSet<>(Arrays.asList(keywordarray));

    static boolean isKeyword1(String id) {
        return keywords.contains(id);
    }

    static boolean isKeyword2(String id) {
        return Arrays.binarySearch(keywordarray, id) >= 0;
    }

    public static String[] unique(String[] filenames) {
        LinkedHashSet<String> uniqueFiles = new LinkedHashSet<>(
                Arrays.asList(filenames));
        return uniqueFiles.toArray(new String[0]);
    }
}
