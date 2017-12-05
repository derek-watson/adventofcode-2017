package Day4;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.IntStream;

public class Solution extends Shared.BaseSolution {
    public void run() throws IOException {
        System.out.println(String.format("Part one: %s", partOne()));
        System.out.println(String.format("Part two: %s", partTwo()));
    }

    private boolean noDuplicateWords(String line) {
        String[] words = line.split(" ");

        HashSet<String> set = new HashSet<String>(Arrays.asList(words));
        return set.size() == words.length;
    }

    private boolean noAnagrams(String line) {
        String[] words = line.split(" ");

        IntStream.range(0, words.length)
                .forEach(i -> {
                    Stream<String> chars = Arrays.stream(words[i].split(""));
                    words[i] = String.join("", chars.sorted().collect(Collectors.toList()));
                });

        HashSet<String> set = new HashSet<String>(Arrays.asList(words));
        return set.size() == words.length;
    }

    private long partOne() {
        return getInput()
                .lines()
                .filter(this::noDuplicateWords)
                .count();
    }

    private long partTwo() {
        return getInput()
                .lines()
                .filter(this::noAnagrams)
                .count();
    }
}