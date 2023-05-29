package com.adamfgcross.javakotlinpractice;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

public class MyStack<T> {
    private List<T> list;
    private int index;

    public MyStack() {
        list = new LinkedList<T>();
        index = -1;
    }

    public void push(T elt) {
        list.add(elt);
        index++;
    }

    public T pop() {
        if (-1 == index) {
            throw new EmptyStackException();
        }
        T elt = list.get(index);
        list.remove(index);
        index--;
        return elt;
    }

    public T peek() {
        if (index == -1) {
            throw new EmptyStackException();
        }
        return list.get(index);
    }
}
