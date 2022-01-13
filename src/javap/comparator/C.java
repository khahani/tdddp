package javap.comparator;

import java.util.Comparator;
import java.util.stream.Stream;

public class C {
    public static void main(String[] args) {
        String[] words = {"car", "ape", "act"};

        Comparator<String> shortestThenLetters =
                Comparator.comparing(String::length)
                .thenComparing(Comparator.naturalOrder());

        Comparator<String> longestThenLetters =
                Comparator.comparing(String::length)
                .reversed()
                .thenComparing(Comparator.naturalOrder());

        Stream.of(words).sorted(Comparator.naturalOrder())
                .forEach(System.out::println);

        Stream.of(words).sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);

        Stream.of(words).sorted(shortestThenLetters)
                .forEach(System.out::println);

        Stream.of(words).sorted(longestThenLetters)
                .forEach(System.out::println);
    }
}
