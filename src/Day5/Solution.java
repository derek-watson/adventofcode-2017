package Day5;

import java.io.IOException;

public class Solution extends Shared.BaseSolution {
    public void run() throws IOException {
        System.out.println(String.format("Part one: %s", partOne()));
        System.out.println(String.format("Part two: %s", partTwo()));
    }

    private long partOne() {
        int[] instructions = getInput()
                .lines()
                .mapToInt(Integer::parseInt)
                .toArray();

        int cursor = 0;
        int steps = 0;

        while (cursor < instructions.length) {
            int jump = instructions[cursor];
            instructions[cursor] += 1;
            cursor += jump;
            steps++;
        }

        return steps;
    }

    private long partTwo() {
        int[] instructions = getInput()
                .lines()
                .mapToInt(Integer::parseInt)
                .toArray();

        int cursor = 0;
        int steps = 0;

        while (cursor < instructions.length) {
            int jump = instructions[cursor];
            instructions[cursor] += (jump >= 3) ? -1 : 1;
            cursor += jump;
            steps++;
        }

        return steps;
    }
}