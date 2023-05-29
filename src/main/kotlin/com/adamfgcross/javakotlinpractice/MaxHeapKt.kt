package com.adamfgcross.javakotlinpractice

class MaxHeapKt() {
    private val heapArray : MutableList<Int> = ArrayList<Int>()
    init {
        heapArray.add(0); // meaningless index 0
    }
    constructor(rootVal : Int) : this() {
        heapArray.add(rootVal); // at index 1
    }

    private fun swap(x : Int, y : Int) {
        val temp = heapArray[x]
        heapArray[x] = heapArray[y]
        heapArray[y] = temp
    }

    fun add(value: Int) {
        heapArray.add(value);
        var workingIndex = heapArray.size - 1
        while (workingIndex > 1) {
            val parentIndex =  if (workingIndex % 2 == 0 )  workingIndex/2 else (workingIndex - 1)/2

            if (heapArray[workingIndex] > heapArray[parentIndex]) {
                swap(workingIndex, parentIndex);
            }
            workingIndex = parentIndex;
        }
    }

    fun reHeap(parent: Int?) {
        if (parent == null)
            return;
        val left = parent * 2;
        val right = parent * 2 + 1;

        var maxIndex = parent;
        if (right < heapArray.size) {
            val maxChildren = if (heapArray[left] > heapArray[right]) left else right
            maxIndex = if (heapArray[parent] > heapArray[maxChildren]) parent else maxChildren
        } else if (left < heapArray.size) {
            maxIndex = if (heapArray[parent] > heapArray[left]) parent else left
        }

        if (parent != maxIndex) {
            swap(parent, maxIndex)
            val previousMax = maxIndex
            reHeap(previousMax)
        }
    }

    fun pick() : Int {
        val returnVal = heapArray[1]
        val finalIndex = heapArray.size - 1
        heapArray[1] = heapArray[finalIndex];
        heapArray.removeAt(finalIndex);
        reHeap(1)
        return returnVal
    }

    fun getRoot() : Int {
        return heapArray[1];
    }
}