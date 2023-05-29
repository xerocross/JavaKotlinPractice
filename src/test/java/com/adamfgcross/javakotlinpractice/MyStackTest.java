package com.adamfgcross.javakotlinpractice;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyStackTest {

    @Test
    public void canCreateStack() {
        MyStack<Integer> myStack = new MyStack<>();
    }

    @Test
    public void canPushAnElement() {
        Integer elt = 5;
        MyStack<Integer> myStack = new MyStack<Integer>();
        myStack.push(elt);
    }

    @Test
    public void canPopAnElement() {
        Integer elt = 5;
        MyStack<Integer> myStack = new MyStack<Integer>();
        myStack.push(elt);
        assertEquals(elt, myStack.pop());
    }

    @Test
    public void ifEmptyPopThrowsEmptyStackException() {
        MyStack<Integer> myStack = new MyStack<Integer>();
        assertThrows(EmptyStackException.class, () -> {
            myStack.pop();
        });
    }

    @Test
    public void canPopFromLargerStackInCorrectOrder() {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(5);
        myStack.push(8);
        assertEquals(Integer.valueOf(8), myStack.pop());
        assertEquals(Integer.valueOf(5), myStack.pop());
    }

    @Test
    public void canPeek() {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(5);
        myStack.push(8);
        assertEquals(Integer.valueOf(8), myStack.peek());
        assertEquals(Integer.valueOf(8), myStack.peek());
        assertEquals(Integer.valueOf(8), myStack.pop());
    }

    @Test
    public void peekOnEmptyStackThrowsEmptyStackException () {
        MyStack<Integer> myStack = new MyStack<>();
        assertThrows(EmptyStackException.class, () -> {
            myStack.peek();
        });
    }

}
