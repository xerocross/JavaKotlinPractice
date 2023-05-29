package com.adamfgcross.javakotlinpractice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void sortsSmallArray() {
        Integer [] arr = new Integer[] {4,3,8,4,6,5};
        MergeSortKt.mergeSort(arr);
        System.out.println(Arrays.asList(arr));
        assertArrayEquals(new Integer[] {3,4,4,5,6,8}, arr);
    }

    @Test
    public void sortsSmallArray2() {
        Integer [] arr = new Integer[] {4,3,8,6};
        MergeSortKt.mergeSort(arr);
        System.out.println(Arrays.asList(arr));
        assertArrayEquals(new Integer[] {3,4,6,8}, arr);
    }

    @Test
    public void sortsSmallArray3() {
        Integer [] arr = new Integer[] {220,4,3,8,6,2,2,9,18,2,1,39,2};
        MergeSortKt.mergeSort(arr);
        System.out.println(Arrays.asList(arr));
        assertArrayEquals(new Integer[] {1,2,2,2,2,3,4,6,8,9,18,39,220}, arr);
    }
    @Test
    public void sortsSmallArray4() {
        Integer [] arr = new Integer[] {220,4,3,8,6,2,2,9,18,2,1,39,2, 1};
        MergeSortKt.mergeSort(arr);
        System.out.println(Arrays.asList(arr));
        assertArrayEquals(new Integer[] {1,1,2,2,2,2,3,4,6,8,9,18,39,220}, arr);
    }

}
