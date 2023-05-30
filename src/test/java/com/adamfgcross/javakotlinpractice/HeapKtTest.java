package com.adamfgcross.javakotlinpractice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeapKtTest {

    private int arbitraryRoot = 10;

    @Parameterized.Parameter
    Heap heap;

    public static class HeapForTest {
        public final String name;
        public final Heap heap;

        public HeapForTest(String name, Heap heap) {
            this.name = name;
            this.heap = heap;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static List<HeapForTest> data() {
        return Arrays.asList(
                new HeapForTest("MaxHeap", new MaxHeapKt()),
                new HeapForTest("MinHeap", new MinHeapKt())
        );
    }

    @DisplayName("Can create max heap without throwing.")
    public void canCreateMaxHeap() {
        assertDoesNotThrow(()-> {
            MaxHeapKt maxHeapKt = new MaxHeapKt(arbitraryRoot);
        });
    }

    @DisplayName("Can create min heap without throwing.")
    public void canCreateMinHeap() {
        assertDoesNotThrow(()-> {
            Heap minHeapKt = new MinHeapKt(arbitraryRoot);
        });
    }

    @DisplayName("Clear method on empty heap does not throw.")
    @ParameterizedTest(name = "{0}")
    @MethodSource("data")
    public void clearOnEmptyHeapDoesNotThrow(HeapForTest heapForTest) {
        assertDoesNotThrow(()-> {
            heapForTest.heap.clear();
        });
    }

    @DisplayName("Remove on empty throws NoSuchElementException")
    @ParameterizedTest(name = "{0}")
    @MethodSource("data")
    public void removeOnEmptyThrowsNoSuchElementException(HeapForTest heapForTest) {
        assertThrows(NoSuchElementException.class, ()-> {
            heapForTest.heap.remove();
        });
    }

    @DisplayName("Remove on non-empty does not throw")
    @ParameterizedTest(name = "{0}")
    @MethodSource("data")
    public void removeOnNonEmptyDoesNotThrow(HeapForTest heapForTest) {
        int random = new Random().nextInt(100);
        heapForTest.heap.insert(random);
        assertDoesNotThrow(()-> {
            heapForTest.heap.remove();
        });
    }


    @DisplayName("Peek on empty throws NoSuchElementException")
    @ParameterizedTest(name = "{0}")
    @MethodSource("data")
    public void peekOnEmptyThrowsNoSuchElementException(HeapForTest heapForTest) {
        assertThrows(NoSuchElementException.class, ()-> {
            heapForTest.heap.peek();
        });
    }

    @DisplayName("Peek on non-empty does not throw")
    @ParameterizedTest(name = "{0}")
    @MethodSource("data")
    public void peekOnNonEmptyDoesNotThrow(HeapForTest heapForTest) {
        int random = new Random().nextInt(100);
        heapForTest.heap.insert(random);
        assertDoesNotThrow(()-> {
            heapForTest.heap.peek();
        });
    }

    @DisplayName("IsEmpty returns true before any insertions")
    @ParameterizedTest(name = "{0}")
    @MethodSource("data")
    public void isEmptyTrueBeforeInsertions(HeapForTest heapForTest) {
        assertTrue(heapForTest.heap.isEmpty());
    }

    @DisplayName("IsEmpty returns false after any insertions")
    @ParameterizedTest(name = "{0}")
    @MethodSource("data")
    public void isEmptyFalseAfterInsertions(HeapForTest heapForTest) {
        heapForTest.heap.insert(arbitraryRoot);
        assertFalse(heapForTest.heap.isEmpty());
    }

    @DisplayName("IsEmpty returns true after inserting elements and removing them again")
    @ParameterizedTest(name = "{0}")
    @MethodSource("data")
    public void isEmptyTrueAfterSeveralInsertionsAndDeletions(HeapForTest heapForTest) {
        int[] insertedElements = new int[] {4967, 4824, 4794, 4679, 4582, 4579, 4566, 4550, 4488, 4450, 4450, 4388, 4374, 4349, 4249, 4137, 4112, 4064, 4060, 3981, 3977, 3929, 3927, 3881, 3856, 3796, 3761, 3746, 3704, 3686, 3673, 3570, 3549, 3507, 3498};
        for (int i : insertedElements) {
            heapForTest.heap.insert(i);
        }
        for (int i : insertedElements) {
            heapForTest.heap.remove(); // intentionally not using i
        }
        assertTrue(heapForTest.heap.isEmpty());
    }

    @DisplayName("IsEmpty returns true after clearing several")
    @ParameterizedTest(name = "{0}")
    @MethodSource("data")
    public void isEmptyTrueAfterClearingSeveral(HeapForTest heapForTest) {
        int[] insertedElements = new int[] {4967, 4824, 4794, 4679, 4582, 4579, 4566, 4550, 4488, 4450, 4450, 4388, 4374, 4349, 4249, 4137, 4112, 4064, 4060, 3981, 3977, 3929, 3927, 3881, 3856, 3796, 3761, 3746, 3704, 3686, 3673, 3570, 3549, 3507, 3498};
        for (int i : insertedElements) {
            heapForTest.heap.insert(i);
        }
        heapForTest.heap.clear();
        assertTrue(heapForTest.heap.isEmpty());
    }

    @DisplayName("Method size returns 0 before any insertions")
    @ParameterizedTest(name = "{0}")
    @MethodSource("data")
    public void sizeZeroOnNoInsertions(HeapForTest heapForTest) {
        assertEquals(0, heapForTest.heap.size());
    }

    @DisplayName("Method size returns correct after several insertions")
    @ParameterizedTest(name = "{0}")
    @MethodSource("data")
    public void sizeCorrectOnSeveralInsertions(HeapForTest heapForTest) {
        int[] insertedElements = new int[] {4967, 4824, 4794, 4679, 4582, 4579, 4566, 4550, 4488, 4450, 4450, 4388, 4374, 4349, 4249, 4137, 4112, 4064, 4060, 3981, 3977, 3929, 3927, 3881, 3856, 3796, 3761, 3746, 3704, 3686, 3673, 3570, 3549, 3507, 3498};
        for (int i : insertedElements) {
            heapForTest.heap.insert(i);
        }
        int expectedSize = insertedElements.length;
        assertEquals(expectedSize, heapForTest.heap.size());
    }

    @DisplayName("After adding and removing all elements size is zero again")
    @ParameterizedTest(name = "{0}")
    @MethodSource("data")
    public void sizeZeroAfterAddingAndRemovingElements(HeapForTest heapForTest) {
        int[] insertedElements = new int[] {4967, 4824, 4794, 4679, 4582, 4579, 4566, 4550, 4488, 4450, 4450, 4388, 4374, 4349, 4249, 4137, 4112, 4064, 4060, 3981, 3977, 3929, 3927, 3881, 3856, 3796, 3761, 3746, 3704, 3686, 3673, 3570, 3549, 3507, 3498};
        for (int i : insertedElements) {
            heapForTest.heap.insert(i);
        }
        for (int i : insertedElements) {
            heapForTest.heap.remove();
        }
        assertEquals(0, heapForTest.heap.size());
    }

    @DisplayName("Can create heap and get root element back.")
    @ParameterizedTest(name = "{0}")
    @MethodSource("data")
    public void canGetHeapRoot(HeapForTest heapForTest) {
        heapForTest.heap.insert(arbitraryRoot);
        assertEquals(arbitraryRoot, heapForTest.heap.peek());
    }
}
