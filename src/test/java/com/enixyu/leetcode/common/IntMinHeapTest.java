package com.enixyu.leetcode.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IntMinHeapTest {
  @Test
  public void itShouldCreateHeapSuccess() {
    IntHeap heap = new IntMinHeap(10);
    assertTrue(heap.isEmpty());
    assertEquals(0, heap.size());
    assertEquals(10, heap.cap());
  }

  @Test
  public void removeShouldWorkCorrect() {
    IntHeap heap = new IntMinHeap(new int[] {5, 4, 3, 2, 1}, 10, true);
    assertEquals(1, heap.remove());
    assertEquals(2, heap.remove());
    assertEquals(3, heap.remove());
    assertEquals(4, heap.remove());
    assertEquals(5, heap.remove());
  }

  @Test
  public void addElementShouldWorkCorrect() {
    IntHeap heap = new IntMinHeap(10);
    heap.add(1);
    heap.add(2);
    heap.add(3);
    heap.add(4);
    heap.add(5);
    assertEquals(1, heap.remove());
    assertEquals(2, heap.remove());
    assertEquals(3, heap.remove());
    assertEquals(4, heap.remove());
    assertEquals(5, heap.remove());

    heap = new IntMinHeap(10);
    heap.add(5);
    heap.add(4);
    heap.add(3);
    heap.add(2);
    heap.add(1);
    assertEquals(1, heap.remove());
    assertEquals(2, heap.remove());
    assertEquals(3, heap.remove());
    assertEquals(4, heap.remove());
    assertEquals(5, heap.remove());

    heap = new IntMinHeap(3);
    heap.add(5);
    heap.add(4);
    heap.add(3);
    heap.add(2);
    heap.add(1);
    assertEquals(1, heap.remove());
    assertEquals(2, heap.remove());
    assertEquals(3, heap.remove());
    assertEquals(4, heap.remove());
    assertEquals(5, heap.remove());
  }

  @Test
  public void peekShouldWorkCorrect() {
    IntHeap heap = new IntMinHeap(new int[] {5, 4, 3, 2, 1}, 10, true);
    assertEquals(1, heap.peek());

    heap = new IntMinHeap(new int[] {1, 2, 3, 4, 5}, 10, true);
    assertEquals(1, heap.peek());
  }
}
