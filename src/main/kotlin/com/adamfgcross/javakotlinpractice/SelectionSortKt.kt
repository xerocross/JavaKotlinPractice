package com.adamfgcross.javakotlinpractice

class SelectionSortKt : SortingMethod {

    override fun sort (array : IntArray?) {
        selectionSort(array)
    }

    private fun selectionSort(array : IntArray?) {
        if (array == null)
            return;

        for (sortedToLeft in array.indices) {
            var minIndex = sortedToLeft
            for (i in minIndex until array.size) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            val temp = array[sortedToLeft]
            array[sortedToLeft] = array[minIndex];
            array[minIndex] = temp
        }
    }

}