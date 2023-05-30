package com.adamfgcross.javakotlinpractice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinHeapKtTest {

    @DisplayName("A heap of three elements maintains min heap property")
    @Test
    public void heapOfThreeElementsMaintainsMinHeapProperty() {
        int[] elements = {5, 4, 6};
        Heap minHeapKt = new MinHeapKt();
        for (int elt : elements) {
            minHeapKt.insert(elt);
        }
        assertEquals(4,minHeapKt.peek());
    }

    @DisplayName("A heap of seven elements maintains min heap property")
    @Test
    public void heapOf7ElementsMaintainsMaxHeapProperty() {
        int[] elements = {5, 4, 6,3, 5,2, 1};
        Heap minHeapKt = new MinHeapKt();
        for (int elt : elements) {
            minHeapKt.insert(elt);
        }
        assertEquals(1,minHeapKt.peek());
    }

    @DisplayName("A heap of 100 elements maintains min heap property")
    @Test
    public void heapOf100ElementsMaintainsMinHeapProperty() {
        int[] elements = {19, 1146, 2530, 3054, 4566, 2093, 427, 3856, 3156, 1391, 3746, 3796, 1199, 4388, 4967, 4064, 3761, 2076, 3927, 2402, 2388, 4137, 4794, 2984, 3881, 1895, 498, 4824, 2548, 3004, 3673, 3507, 696, 1307, 3977, 3929, 1627, 3549, 3097, 553, 2740, 1366, 3570, 4112, 1295, 3160, 2036, 4488, 3498, 4374, 444, 106, 1556, 1994, 2526, 4249, 2719, 3392, 2205, 944, 1119, 3686, 1526, 2151, 1865, 1843, 1520, 1764, 3138, 2271, 1305, 983, 1758, 707, 4349, 1316, 2155, 1975, 2828, 1115, 8, 4550, 573, 1541, 1946, 2715, 2859, 4450, 4679, 2008, 3704, 4060, 4579, 239, 3981, 1704, 4450, 1733, 2540, 4582};
        Heap minHeapKt = new MinHeapKt();
        for (int elt : elements) {
            minHeapKt.insert(elt);
        }
        assertEquals(8, minHeapKt.peek());
    }

    @DisplayName("Given a heap of 100 Elements, remove chooses first several in the right order")
    @Test
    public void givenAHeapOf100ElementsRemoveChoosesSeveralInRightOrder() {
        int[] elements = {19, 1146, 2530, 3054, 4566, 2093, 427, 3856, 3156, 1391, 3746, 3796, 1199, 4388, 4967, 4064, 3761, 2076, 3927, 2402, 2388, 4137, 4794, 2984, 3881, 1895, 498, 4824, 2548, 3004, 3673, 3507, 696, 1307, 3977, 3929, 1627, 3549, 3097, 553, 2740, 1366, 3570, 4112, 1295, 3160, 2036, 4488, 3498, 4374, 444, 106, 1556, 1994, 2526, 4249, 2719, 3392, 2205, 944, 1119, 3686, 1526, 2151, 1865, 1843, 1520, 1764, 3138, 2271, 1305, 983, 1758, 707, 4349, 1316, 2155, 1975, 2828, 1115, 8, 4550, 573, 1541, 1946, 2715, 2859, 4450, 4679, 2008, 3704, 4060, 4579, 239, 3981, 1704, 4450, 1733, 2540, 4582};
        Heap minHeapKt = new MinHeapKt();
        for (int elt : elements) {
            minHeapKt.insert(elt);
        }
        int[] expectedElements = new int[] {8, 19, 106, 239, 427, 444, 498, 553, 573, 696, 707, 944, 983, 1115, 1119, 1146, 1199, 1295, 1305};
        int[] removedElements = new int[expectedElements.length];
        for (int i = 0; i < expectedElements.length; i++) {
            removedElements[i] = minHeapKt.remove();
        }
        assertArrayEquals(expectedElements,removedElements);
    }

    @DisplayName("Given a heap of 100 Elements, remove chooses first several in the right order (2)")
    @Test
    public void givenAHeapOf100ElementsRemoveChoosesSeveralInRightOrder2() {
        int[] elements = {688, 3815, 410, 1265, 3105, 4798, 4568, 740, 1847, 2344, 550, 1404, 1953, 2373, 2640, 2803, 1573, 3301, 2596, 407, 2398, 2288, 971, 4786, 1208, 4733, 1550, 2688, 2100, 4198, 1209, 4499, 3028, 832, 1190, 1688, 3637, 3714, 738, 4181, 3037, 1343, 4340, 2081, 4950, 2631, 2088, 4880, 364, 1866, 4537, 2768, 2207, 3833, 2841, 196, 4736, 1860, 315, 2198, 968, 4295, 2395, 3360, 3041, 1087, 3917, 1853, 3785, 2832, 4193, 1653, 1849, 1334, 3656, 653, 2822, 968, 806, 1925, 431, 1054, 4721, 2021, 4854, 2243, 3356, 4282, 1362, 4007, 4753, 4218, 4145, 958, 663, 4150, 3193, 916, 4883, 1569};
        Heap minHeapKt = new MinHeapKt();
        for (int elt : elements) {
            minHeapKt.insert(elt);
        }
        int[] expectedElements = new int[] {196, 315, 364, 407, 410, 431, 550, 653, 663, 688, 738, 740, 806, 832, 916, 958, 968, 968, 971, 1054, 1087, 1190, 1208, 1209, 1265, 1334, 1343, 1362, 1404, 1550, 1569, 1573, 1653, 1688, 1847, 1849, 1853, 1860, 1866, 1925, 1953, 2021, 2081, 2088, 2100, 2198, 2207, 2243, 2288, 2344, 2373, 2395, 2398, 2596, 2631, 2640, 2688, 2768, 2803, 2822, 2832, 2841, 3028, 3037, 3041, 3105, 3193, 3301, 3356, 3360, 3637, 3656, 3714, 3785, 3815, 3833, 3917, 4007, 4145, 4150, 4181, 4193, 4198, 4218, 4282, 4295, 4340, 4499, 4537, 4568, 4721, 4733, 4736, 4753, 4786, 4798, 4854, 4880, 4883, 4950};
        int[] removedElements = new int[expectedElements.length];
        for (int i = 0; i < expectedElements.length; i++) {
            removedElements[i] = minHeapKt.remove();
        }
        assertArrayEquals(expectedElements,removedElements);
    }

    @DisplayName("Given a heap of 10_000 Elements, remove chooses first several in the right order")
    @Test
    public void givenAHeapOf10_000ElementsRemoveChoosesSeveralInRightOrder2() {
        LargeNumberFileReader largeNumberFileReader = new LargeNumberFileReader();
        int[] elements = largeNumberFileReader.readNumbersFromFile("tenThousandNumbers.txt");
        Heap minHeapKt = new MinHeapKt();
        for (int elt : elements) {
            minHeapKt.insert(elt);
        }
        int[] expectedElements = largeNumberFileReader.readNumbersFromFile("tenThousandAscending.txt");
        int[] removedElements = new int[expectedElements.length];
        for (int i = 0; i < expectedElements.length; i++) {
            removedElements[i] = minHeapKt.remove();
        }
        assertArrayEquals(expectedElements,removedElements);
    }
}
