package com.adamfgcross.javakotlinpractice;


public class QuickSort implements SortingMethod {

    // partition of input, given si and ei as indexes on array input
    // should return an index, the partition index p, such that
    // all elements index[si]..index[p-1] <= index[p]
    // and index[p] <= index[p+1]..index[ei]
    private static int partition(int[] input, int si, int ei) {
        final int pivot = input[si];

        // counting num of elements less than pivot so that space can be made empty to left of pivot

        int smallerThanPivotCount = 0;
        for (int i = si; i <= ei; i++) { // ei is included because function is defined inclusive
            if (input[i] < pivot)
                smallerThanPivotCount++;
        }
        //  between si and ei, inclusive, smallerThanPivotCount elements are < pivot

        // swap pivot to its new position, which allows enough spaces to its left
        // for elements that are strictly smaller
        final int newPivotPosition = si + smallerThanPivotCount;
        input[si] = input[newPivotPosition];
        input[newPivotPosition] = pivot;

        // next we are
        // ensuring all elements to the left of pivot are < pivot and to the right are >= pivot
        int i = si, j = ei,temp;

        while(i < newPivotPosition && j > newPivotPosition) {
            if(input[i]<pivot)
                // we arbitrarily decided that elements equal to pivot
                // should be located to the right of the pivot position
                i++;
            else  {
                if(input[j]>=pivot)
                    j--;
                else {
                    temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                    i++;
                    j--;
                }
            }
        }
        return newPivotPosition;
    }

    public static void quickSort(int[] input, int si, int ei) {
        if(si>=ei)
            return;
        int pivotPos =  partition(input,si,ei);
        // we assume partition(input, si, ei) worked correctly,
        // which means that for p = pivotPos
        // all elements index[si]..index[p-1] < index[p]
        // and index[p] <= index[p+1]..index[ei]
        quickSort(input,si,pivotPos - 1);
        quickSort(input,pivotPos+1,ei);
    }

    public static void quickSort(int[] input) {
        if (input == null)
            return;
        quickSort(input,0,input.length - 1);
        // quickSort is designed so that si and ei are
        // inclusive, [si, ei]
    }

    public void sort (int[] input) {
       QuickSort.quickSort(input);
    }
}