package Shared;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BaseSolution {
    public void run() throws IOException {}

    public BufferedReader getInput() {
        InputStream inputStream = this.getClass().getResourceAsStream("input.txt");
        return new BufferedReader(new InputStreamReader(inputStream));
    }
}