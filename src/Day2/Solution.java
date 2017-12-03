package Day2;

import java.io.IOException;
import java.util.Arrays;

public class Solution extends Shared.BaseSolution {
    public void run() throws IOException {
        System.out.println(String.format("Part one: %s", partOne()));
        System.out.println(String.format("Part two: %s", partTwo()));
    }

    private int[] parseLine(String line) {
        return Arrays.stream(line.split("\t"))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
    }

    private int partOne() {
        return getInput()
                .lines()
                .mapToInt(line -> {
                    int[] digits = parseLine(line);
                    return digits[digits.length - 1] - digits[0];
                })
                .sum();
    }

    private int partTwo() {
        return getInput()
                .lines()
                .mapToInt(line -> {
                    int[] digits = parseLine(line);

                    for (int numerator : digits) {
                        for (int denominator : digits) {
                            if (!(numerator > denominator)) {
                                continue;
                            }

                            if ((float)numerator % (float)denominator == 0) {
                                return (int)((float)numerator / (float)denominator);
                            }
                        }
                    }

                    throw new RuntimeException("No evenly divisible pair found");
                })
                .sum();
    }
}
