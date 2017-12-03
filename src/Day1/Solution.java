package Day1;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution extends Shared.BaseSolution {
    public void run() throws IOException {
        String input = getInput().readLine();
        int[] digits = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(String.format("Part one: %s", partOne(digits)));
        System.out.println(String.format("Part two: %s", partTwo(digits)));
    }

    private int partOne(int[] digits) {
        return IntStream
                .range(0, digits.length)
                .reduce(0, (val, index) -> {
                    int next = index == digits.length - 1 ? 0 : index + 1;

                    if (digits[index] == digits[next]) {
                        return val + digits[index];
                    }
                    return val;
                });
    }

    private int partTwo(int[] digits) {
        int last = digits.length - 1;

        return IntStream
                .range(0, digits.length)
                .reduce(0, (val, index) -> {
                    int next = index + digits.length / 2;
                    if (next > last) {
                        next = (next - last) - 1;
                    }

                    if (digits[index] == digits[next]) {
                        return val + digits[index];
                    }
                    return val;
                });
    }
}
