package Day3;

import java.util.Hashtable;

public class Solution {

    private static int input = 347991;

    private enum Directions {
        RIGHT, UP, LEFT, DOWN
    }

    public void run() {
        System.out.println(String.format("Part one: %s", partOne()));
        System.out.println(String.format("Part two: %s", partTwo()));
    }

    private Directions mapStep(Directions direction, int[] coordinates, int[] maxCoordinates) {
        switch (direction) {
            case RIGHT:
                coordinates[0] += 1;
                if (coordinates[0] > maxCoordinates[0]) {
                    direction = Directions.UP;
                    maxCoordinates[0] = coordinates[0];
                }
                break;
            case UP:
                coordinates[1] += 1;
                if (coordinates[1] > maxCoordinates[1]) {
                    direction = Directions.LEFT;
                    maxCoordinates[1] = coordinates[1];
                }
                break;
            case LEFT:
                coordinates[0] -= 1;
                if (coordinates[0] < maxCoordinates[2]) {
                    direction = Directions.DOWN;
                    maxCoordinates[2] = coordinates[0];
                }
                break;
            case DOWN:
                coordinates[1] -= 1;
                if (coordinates[1] < maxCoordinates[3]) {
                    direction = Directions.RIGHT;
                    maxCoordinates[3] = coordinates[1];
                }
                break;
        }

        return direction;
    }

    private int partOne() {
        int cursor = 1;

        Directions direction = Directions.RIGHT;
        int[] coordinates = {-1, 0};
        int[] maxCoordinates = {0, 0, 0, 0};

        while (cursor <= input) {
            direction = mapStep(direction, coordinates, maxCoordinates);
            cursor++;
        }

        // manhattan distance
        return Math.abs(coordinates[0]) + Math.abs(coordinates[1]);
    }

    private int partTwo() {
        int value = -1;

        Directions direction = Directions.RIGHT;
        int[] coordinates = {-1, 0};
        int[] maxCoordinates = {0, 0, 0, 0};

        Hashtable<String, Integer> storage = new Hashtable<String, Integer>();

        while (value <= input) {
            direction = mapStep(direction, coordinates, maxCoordinates);

            // calculate new value each loop
            value = 0;
            
            int[] testDistances = {-1, 0, 1};
            for (int x : testDistances) {
                for (int y: testDistances) {
                    if (x == 0 && y == 0) {
                        continue;
                    }
                    String testKey = String.format("%s:%s", coordinates[0] + x, coordinates[1] + y);
                    if (storage.containsKey(testKey)) {
                        value += storage.get(testKey);
                    }
                }
            }

            // special case for first cell
            if (value == 0) {
                value = 1;
            }

            // store value
            String key = String.format("%s:%s", coordinates[0], coordinates[1]);
            storage.put(key, value);
        }

        return value;
    }
}
