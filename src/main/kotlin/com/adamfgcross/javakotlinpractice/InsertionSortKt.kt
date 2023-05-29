package com.adamfgcross.javakotlinpractice

class InsertionSortKt : SortingMethod {

    override fun sort(array : IntArray?) {
        if (array == null)
            return;
        insertionSort(array)
    }

    private fun insertionSort(array : IntArray) {
        for (rightIndexSortedSublist in 0 until (array.size - 1)) {
            // assume that the subarray from 0 up to rightIndexSortedSublist
            // is sorted, up to and including rightIndexSortedSublist
            // The base case is the single-element subarray containing
            // only the element array[0], so the base case is true
            for (test in (rightIndexSortedSublist + 1) downTo (0 + 1)) {
                // start with test the index 1 to the right of the
                // sorted subarray

                if (array[test-1] > array[test]) {
                    // if the pair array[test-1] and array[test]
                    // are out of order then swap them
                    val temp = array[test]
                    array[test] = array[test - 1]
                    array[test - 1] = temp
                } else {
                    break
                }
            }
            // we started with the element at index test = rightIndexSortedSublist + 1
            // the subarray [0, rightIndexSortedSublist] was sorted,
            // If the element at test was less than the element to its
            // left then we swapped them and we moved left, and we kept
            // swapping until the element formerly at rightIndexSortedSublist + 1
            // gets inserted into its proper position in the sorted subarray
            // we continue in this fashion until rightIndexSortedSublist = array.size - 1
        }
    }
}