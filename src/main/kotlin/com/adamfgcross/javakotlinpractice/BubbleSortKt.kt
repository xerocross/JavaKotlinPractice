package com.adamfgcross.javakotlinpractice

class BubbleSortKt : SortingMethod {

    private fun bubbleSort(lst: IntArray?) {
        if (lst == null) {
            return;
        }
        var swapped = true
        while (swapped) {
            swapped = false
            for (i in 0 until lst.size - 1) {
                if (lst[i] > lst[i + 1]) {
                    val temp = lst[i]
                    lst[i] = lst[i + 1]
                    lst[i + 1] = temp
                    swapped = true
                }
            }
        }
    }

    override fun sort(list: IntArray?) {
        bubbleSort(list)
    }
}

