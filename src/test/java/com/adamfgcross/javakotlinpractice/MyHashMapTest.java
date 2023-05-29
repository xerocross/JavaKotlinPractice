package com.adamfgcross.demospringmay82;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyHashMapTest {

    @Test
    public void canBuildHashMap() {
        MyHashMap<Integer> myHashMap = new MyHashMap<>(55);
    }

    @Test
    public void canAddElementToHashMap() {
        MyHashMap<Integer> myHashMap = new MyHashMap<>(55);
        myHashMap.add(5);
    }

    @Test
    public void afterAddingElementContainsIsPositive() {
        MyHashMap<Integer> myHashMap = new MyHashMap<>(55);
        myHashMap.add(5);
        assertTrue(myHashMap.contains(5));
    }

    @Test
    public void ifElementNotAddedContainsReturnsFalse() {
        MyHashMap<Integer> myHashMap = new MyHashMap<>(55);
        myHashMap.add(3);
        assertFalse(myHashMap.contains(5));
    }
}
