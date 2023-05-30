package com.adamfgcross.javakotlinpractice

class HeapSortKt : SortingMethod {
    override fun sort(array : IntArray?) {
        if (array == null)
            return
        heapSort(array)
    }

    private fun heapSort(array: IntArray) {
        val minHeapKt = MinHeapKt();
        for (i in array) {
            minHeapKt.insert(i);
        }
        for (i in array.indices) {
            array[i] = minHeapKt.remove();
        }
    }
}