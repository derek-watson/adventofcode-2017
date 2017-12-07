package Day6;

import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Solution extends Shared.BaseSolution {
    public void run() throws IOException {
        int[] banks = Arrays.stream(getInput().readLine().split("\t"))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean seenConfiguration = false;
        ArrayList<String> configurations = new ArrayList<String>();

        while (!seenConfiguration) {
            configurations.add(tokenize(banks));
            redistribute(banks, largestBank(banks));
            seenConfiguration = configurations.contains(tokenize(banks));
        }

        System.out.println(String.format("Part one: %s", configurations.size()));

        System.out.println(String.format("Part two: %s", configurations.size() - configurations.indexOf(tokenize(banks))));
    }

    private String tokenize(int[] arr) {
        return Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("-"));
    }

    private void redistribute(int[] banks, int index) {
        int redistributeBlocks = banks[index];
        banks[index] = 0;

        int cursor = index;

        while (redistributeBlocks > 0) {
            cursor = cursor == banks.length - 1 ? 0 : cursor + 1;

            banks[cursor]++;
            redistributeBlocks--;
        }
    }

    private int largestBank(int[] banks) {
        int index = 0;
        int max = 0;
        for(int i = 0; i < banks.length; i++) {
            if (banks[i] > max || i == 0) {
                index = i;
                max = banks[i];
            }
        }
        return index;
    }
}