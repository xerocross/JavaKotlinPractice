package com.adamfgcross.javakotlinpractice

class MergeSortKt :SortingMethod {
    // sort an array (mutates the array)

    override fun sort(array : IntArray?) {
        mergeSort(array);
    }

    fun mergeSort(arr: IntArray?) {
        if (arr == null)
            return;
        val workingArr = Array<Int>(size = arr.size) { 0 };
        mergeSortRecursion(arr, 0, arr.size - 1, workingArr);
    }

    private fun mergeSortRecursion(arr: IntArray, si: Int, ei: Int, workingArr: Array<Int>) {
        if (si >= ei) {
            return;
        }
        val mi = si + (ei - si) / 2;
        mergeSortRecursion(arr, si, mi, workingArr)
        mergeSortRecursion(arr, mi + 1, ei, workingArr)
        //subarray [si, mi] and [mi + 1, ei] are sorted
        merge(arr, si, mi, ei, workingArr);
    }

    private fun merge(arr: IntArray, si: Int, mi: Int, ei: Int, workingArr: Array<Int>) {
        // the subarrays [si, mi] and [mi+1,ei] are sorted

        var i = si
        var j = mi + 1
        var count = si;
        while (i <= mi && j <= ei) {
            if (arr[i] < arr[j]) {
                workingArr[count] = arr[i];
                i++;
                count++;
            } else {
                workingArr[count] = arr[j];
                j++
                count++;
            }
        }
        while (i <= mi) {
            workingArr[count] = arr[i];
            i++;
            count++;
        }
        while (j <= ei) {
            workingArr[count] = arr[j];
            j++
            count++;
        }
        for (i in si..ei) {
            arr[i] = workingArr[i];
        }
    }
}