package com.adamfgcross.javakotlinpractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class MyHashMap<T> {
    List<List<T>> elts;
    int size;

    public MyHashMap(int size) {
        this.size = size;

        while (!checkIsPrime(size)) {
            size++;
        }

        elts = new ArrayList<List<T>>();
        for (int i = 0; i < size; i++) {
            elts.add(new LinkedList<T>());
        }
    }

    private boolean checkIsPrime(int n) {
        for (int i = 2; i < n-1 ; i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }

    private int hash(T elt) {
        return elt.hashCode() % size;
    }


    public void add (T elt) {
        int hashVal = hash(elt);
        elts.get(hashVal).add(elt);
    }

    public Boolean contains(T elt) {
        int hashElt = hash(elt);
        return elts.get(hashElt).contains(elt);
    }
}
