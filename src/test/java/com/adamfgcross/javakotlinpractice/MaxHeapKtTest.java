package com.adamfgcross.javakotlinpractice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MaxHeapKtTest {

    @DisplayName("A heap of three elements maintains max heap property")
    @Test
    public void heapOfThreeElementsMaintainsMaxHeapProperty() {
        int[] elements = {5, 4, 6};
        MaxHeapKt maxHeapKt = new MaxHeapKt();
        for (int elt : elements) {
            maxHeapKt.insert(elt);
        }
        assertEquals(6,maxHeapKt.peek());
    }

    @DisplayName("A heap of seven elements maintains max heap property")
    @Test
    public void heapOf7ElementsMaintainsMaxHeapProperty() {
        int[] elements = {5, 4, 6,3, 5,2, 1};
        MaxHeapKt maxHeapKt = new MaxHeapKt();
        for (int elt : elements) {
            maxHeapKt.insert(elt);
        }
        assertEquals(6,maxHeapKt.peek());
    }

    @DisplayName("A heap of 100 elements maintains max heap property")
    @Test
    public void heapOf100ElementsMaintainsMaxHeapProperty() {
        int[] elements = {19, 1146, 2530, 3054, 4566, 2093, 427, 3856, 3156, 1391, 3746, 3796, 1199, 4388, 4967, 4064, 3761, 2076, 3927, 2402, 2388, 4137, 4794, 2984, 3881, 1895, 498, 4824, 2548, 3004, 3673, 3507, 696, 1307, 3977, 3929, 1627, 3549, 3097, 553, 2740, 1366, 3570, 4112, 1295, 3160, 2036, 4488, 3498, 4374, 444, 106, 1556, 1994, 2526, 4249, 2719, 3392, 2205, 944, 1119, 3686, 1526, 2151, 1865, 1843, 1520, 1764, 3138, 2271, 1305, 983, 1758, 707, 4349, 1316, 2155, 1975, 2828, 1115, 8, 4550, 573, 1541, 1946, 2715, 2859, 4450, 4679, 2008, 3704, 4060, 4579, 239, 3981, 1704, 4450, 1733, 2540, 4582};
        MaxHeapKt maxHeapKt = new MaxHeapKt();
        for (int elt : elements) {
            maxHeapKt.insert(elt);
        }
        assertEquals(4967,maxHeapKt.peek());
    }

    @DisplayName("Given a heap of 100 Elements, Remove chooses first several in the right order")
    @Test
    public void givenAHeapOf100ElementsRemoveChoosesSeveralInRightOrder() {
        int[] elements = {19, 1146, 2530, 3054, 4566, 2093, 427, 3856, 3156, 1391, 3746, 3796, 1199, 4388, 4967, 4064, 3761, 2076, 3927, 2402, 2388, 4137, 4794, 2984, 3881, 1895, 498, 4824, 2548, 3004, 3673, 3507, 696, 1307, 3977, 3929, 1627, 3549, 3097, 553, 2740, 1366, 3570, 4112, 1295, 3160, 2036, 4488, 3498, 4374, 444, 106, 1556, 1994, 2526, 4249, 2719, 3392, 2205, 944, 1119, 3686, 1526, 2151, 1865, 1843, 1520, 1764, 3138, 2271, 1305, 983, 1758, 707, 4349, 1316, 2155, 1975, 2828, 1115, 8, 4550, 573, 1541, 1946, 2715, 2859, 4450, 4679, 2008, 3704, 4060, 4579, 239, 3981, 1704, 4450, 1733, 2540, 4582};
        MaxHeapKt maxHeapKt = new MaxHeapKt();
        for (int elt : elements) {
            maxHeapKt.insert(elt);
        }
        int[] expectedElements = new int[] {4967, 4824, 4794, 4679, 4582, 4579, 4566, 4550, 4488, 4450, 4450, 4388, 4374, 4349, 4249, 4137, 4112, 4064, 4060, 3981, 3977, 3929, 3927, 3881, 3856, 3796, 3761, 3746, 3704, 3686, 3673, 3570, 3549, 3507, 3498};
        int[] removedElements = new int[expectedElements.length];
        for (int i = 0; i < expectedElements.length; i++) {
            removedElements[i] = maxHeapKt.remove();
        }
        assertArrayEquals(expectedElements,removedElements);
    }

    @DisplayName("Given a heap of 100 Elements, remove chooses first several in the right order (2)")
    @Test
    public void givenAHeapOf100ElementsRemoveChoosesSeveralInRightOrder2() {
        int[] elements = {688, 3815, 410, 1265, 3105, 4798, 4568, 740, 1847, 2344, 550, 1404, 1953, 2373, 2640, 2803, 1573, 3301, 2596, 407, 2398, 2288, 971, 4786, 1208, 4733, 1550, 2688, 2100, 4198, 1209, 4499, 3028, 832, 1190, 1688, 3637, 3714, 738, 4181, 3037, 1343, 4340, 2081, 4950, 2631, 2088, 4880, 364, 1866, 4537, 2768, 2207, 3833, 2841, 196, 4736, 1860, 315, 2198, 968, 4295, 2395, 3360, 3041, 1087, 3917, 1853, 3785, 2832, 4193, 1653, 1849, 1334, 3656, 653, 2822, 968, 806, 1925, 431, 1054, 4721, 2021, 4854, 2243, 3356, 4282, 1362, 4007, 4753, 4218, 4145, 958, 663, 4150, 3193, 916, 4883, 1569};
        MaxHeapKt maxHeapKt = new MaxHeapKt();
        for (int elt : elements) {
            maxHeapKt.insert(elt);
        }
        int[] expectedElements = new int[] {4950, 4883, 4880, 4854, 4798, 4786, 4753, 4736, 4733, 4721, 4568, 4537, 4499, 4340, 4295, 4282, 4218, 4198, 4193, 4181, 4150, 4145, 4007, 3917, 3833, 3815, 3785, 3714, 3656, 3637, 3360, 3356, 3301, 3193, 3105, 3041, 3037, 3028, 2841, 2832, 2822, 2803, 2768, 2688, 2640, 2631, 2596, 2398, 2395, 2373, 2344, 2288, 2243, 2207, 2198, 2100, 2088, 2081, 2021, 1953, 1925, 1866, 1860, 1853, 1849, 1847, 1688, 1653, 1573, 1569, 1550, 1404, 1362, 1343, 1334, 1265, 1209, 1208, 1190, 1087, 1054, 971, 968, 968, 958, 916, 832, 806, 740, 738, 688, 663, 653, 550, 431, 410, 407, 364, 315, 196};
        int[] removedElements = new int[expectedElements.length];
        for (int i = 0; i < expectedElements.length; i++) {
            removedElements[i] = maxHeapKt.remove();
        }
        assertArrayEquals(expectedElements,removedElements);
    }

    private class LargeNumberFileReader {
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


    @DisplayName("Given a heap of 10_000 Elements, remove chooses first several in the right order")
    @Test
    public void givenAHeapOf10_000ElementsRemoveChoosesSeveralInRightOrder2() {
        LargeNumberFileReader largeNumberFileReader = new LargeNumberFileReader();
        int[] elements = largeNumberFileReader.readNumbersFromFile("tenThousandNumbers.txt");
        MaxHeapKt maxHeapKt = new MaxHeapKt();
        for (int elt : elements) {
            maxHeapKt.insert(elt);
        }
        int[] expectedElements = largeNumberFileReader.readNumbersFromFile("tenThousandDescending.txt");
        int[] removedElements = new int[expectedElements.length];
        for (int i = 0; i < expectedElements.length; i++) {
            removedElements[i] = maxHeapKt.remove();
        }
        assertArrayEquals(expectedElements,removedElements);
    }
}