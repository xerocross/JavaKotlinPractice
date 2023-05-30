package com.adamfgcross.javakotlinpractice

class MinHeapKt() : Heap() {
    constructor(rootVal : Int) : this() {
        heapArray.add(rootVal); // at index 1
    }

    override fun insert(value: Int) {
        heapArray.add(value);
        var workingIndex = heapArray.size - 1
        while (workingIndex > 1) {
            val parentIndex =  if (workingIndex % 2 == 0 )  workingIndex/2 else (workingIndex - 1)/2

            if (heapArray[workingIndex] < heapArray[parentIndex]) {
                swap(workingIndex, parentIndex);
            }
            workingIndex = parentIndex;
        }
    }

    override fun reHeap(parent: Int?) {
        if (parent == null)
            return;
        val left = parent * 2;
        val right = parent * 2 + 1;

        var minIndex = parent;
        if (right < heapArray.size) {
            val minChildren = if (heapArray[left] < heapArray[right]) left else right
            minIndex = if (heapArray[parent] < heapArray[minChildren]) parent else minChildren
        } else if (left < heapArray.size) {
            minIndex = if (heapArray[parent] < heapArray[left]) parent else left
        }

        if (parent != minIndex) {
            swap(parent, minIndex)
            val previousMax = minIndex
            reHeap(previousMax)
        }
    }

    private fun swap(x : Int, y : Int) {
        val temp = heapArray[x]
        heapArray[x] = heapArray[y]
        heapArray[y] = temp
    }
}