package com.adamfgcross.javakotlinpractice

import java.util.NoSuchElementException
import javax.imageio.plugins.tiff.ExifParentTIFFTagSet

abstract class Heap() {
    val heapArray : MutableList<Int> = ArrayList<Int>()
    init {
        heapArray.add(0); // meaningless index 0
    }
    constructor(rootVal : Int) : this() {
        heapArray.add(rootVal); // at index 1
    }

    fun peek() : Int {
        if (isEmpty()) {
            throw NoSuchElementException()
        }
        return heapArray[1];
    }

    fun size() : Int {
        return heapArray.size - 1;
    }

    fun clear() {
        heapArray.clear();
        heapArray.add(0);
    }

    fun isEmpty() : Boolean {
        return (heapArray.size == 1) // recall that the 0-index element is a meaningless placeholder
    }

    fun remove() : Int {
        if (isEmpty()) {
            throw NoSuchElementException()
        }
        val returnVal = heapArray[1]
        val finalIndex = heapArray.size - 1
        heapArray[1] = heapArray[finalIndex];
        heapArray.removeAt(finalIndex);
        reHeap(1)
        return returnVal
    }
    abstract fun reHeap(parent : Int?)
    abstract fun insert(element: Int)
}