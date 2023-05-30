package com.adamfgcross.javakotlinpractice;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LargeNumberFileReader {
    public int[] readNumbersFromFile(String name) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(name);
        if (inputStream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line = reader.readLine();
                if (line != null) {
                    String[] numberStrings = line.split("\\s*,\\s*");
                    int[] numbers = Arrays.stream(numberStrings)
                            .mapToInt(Integer::parseInt)
                            .toArray();
                    return numbers;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return new int[0];
    }
}
