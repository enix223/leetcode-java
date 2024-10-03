package com.enixyu.leetcode.common;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DynamicIntArrayTest {
  @Test
  public void itShouldCreateArrayWithCapacitySuccess() {
    DynamicIntArray arr = new DynamicIntArray(10);
    assertEquals(10, arr.getCapacity());
    assertEquals(0, arr.getSize());
    assertTrue(arr.isEmpty());
  }

  @Test
  public void itShouldCreateArrayWithPreloadingDataSuccess() {
    DynamicIntArray arr = new DynamicIntArray(new int[] {1, 2, 3, 4}, 10);
    assertEquals(10, arr.getCapacity());
    assertEquals(4, arr.getSize());
  }

  @Test
  public void itShouldAddItemWithValidIndexSuccess() {
    DynamicIntArray arr = new DynamicIntArray(new int[] {1, 2, 3, 4}, 10);
    arr.add(1, 10);
    assertEquals(10, arr.getCapacity());
    assertEquals(5, arr.getSize());
    assertEquals(1, arr.get(0));
    assertEquals(10, arr.get(1));
    assertEquals(2, arr.get(2));
    assertEquals(3, arr.get(3));
    assertEquals(4, arr.get(4));
  }

  @Test
  public void itShouldAddItemWithValidIndexAndNeedExpandSuccess() {
    DynamicIntArray arr = new DynamicIntArray(new int[] {1, 2, 3, 4}, 4);
    arr.add(1, 10);
    assertEquals(8, arr.getCapacity());
    assertEquals(5, arr.getSize());
    assertEquals(1, arr.get(0));
    assertEquals(10, arr.get(1));
    assertEquals(2, arr.get(2));
    assertEquals(3, arr.get(3));
    assertEquals(4, arr.get(4));
  }

  @Test
  public void itShouldAddItemWithLeftMostIndexSuccess() {
    DynamicIntArray arr = new DynamicIntArray(new int[] {1, 2, 3, 4}, 10);
    arr.add(0, 10);
    assertEquals(10, arr.getCapacity());
    assertEquals(5, arr.getSize());
    assertEquals(10, arr.get(0));
    assertEquals(1, arr.get(1));
    assertEquals(2, arr.get(2));
    assertEquals(3, arr.get(3));
    assertEquals(4, arr.get(4));
  }

  @Test
  public void itShouldAddItemWithLeftMostIndexAndNeedExpandSuccess() {
    DynamicIntArray arr = new DynamicIntArray(new int[] {1, 2, 3, 4}, 4);
    arr.add(0, 10);
    assertEquals(8, arr.getCapacity());
    assertEquals(5, arr.getSize());
    assertEquals(10, arr.get(0));
    assertEquals(1, arr.get(1));
    assertEquals(2, arr.get(2));
    assertEquals(3, arr.get(3));
    assertEquals(4, arr.get(4));
  }

  @Test
  public void itShouldAddItemWithRightMostIndexSuccess() {
    DynamicIntArray arr = new DynamicIntArray(new int[] {1, 2, 3, 4}, 10);
    arr.add(4, 10);
    assertEquals(10, arr.getCapacity());
    assertEquals(5, arr.getSize());
    assertEquals(1, arr.get(0));
    assertEquals(2, arr.get(1));
    assertEquals(3, arr.get(2));
    assertEquals(4, arr.get(3));
    assertEquals(10, arr.get(4));
  }

  @Test
  public void itShouldAddItemWithRightMostIndexAndNeedExpandSuccess() {
    DynamicIntArray arr = new DynamicIntArray(new int[] {1, 2, 3, 4}, 4);
    arr.add(4, 10);
    assertEquals(8, arr.getCapacity());
    assertEquals(5, arr.getSize());
    assertEquals(1, arr.get(0));
    assertEquals(2, arr.get(1));
    assertEquals(3, arr.get(2));
    assertEquals(4, arr.get(3));
    assertEquals(10, arr.get(4));
  }

  @Test
  public void itShouldDeleteElementAtValidIndexSuccess() {
    DynamicIntArray arr = new DynamicIntArray(new int[] {1, 2, 3, 4, 5}, 5);
    arr.delete(1);
    assertEquals(5, arr.getCapacity());
    assertEquals(4, arr.getSize());
    assertEquals(1, arr.get(0));
    assertEquals(3, arr.get(1));
    assertEquals(4, arr.get(2));
    assertEquals(5, arr.get(3));

    arr.delete(0);
    assertEquals(5, arr.getCapacity());
    assertEquals(3, arr.getSize());
    assertEquals(3, arr.get(0));
    assertEquals(4, arr.get(1));
    assertEquals(5, arr.get(2));
  }

  @Test
  public void itShouldRaiseExceptionWhenAddItemWithInvalidIndex() {
    DynamicIntArray arr = new DynamicIntArray(new int[] {1, 2, 3, 4}, 10);
    assertThrows(IndexOutOfBoundsException.class, () -> arr.add(5, 10));
    assertThrows(IndexOutOfBoundsException.class, () -> arr.add(9, 10));
    assertThrows(IndexOutOfBoundsException.class, () -> arr.add(-1, 10));
    assertThrows(IndexOutOfBoundsException.class, () -> arr.get(-1));
    assertThrows(IndexOutOfBoundsException.class, () -> arr.get(4));
  }

  @Test
  public void itShouldShrinkSuccessWhenFreeSpaceInArray() {
    DynamicIntArray arr = new DynamicIntArray(new int[] {1, 2, 3, 4}, 10);
    arr.shrink();
    assertEquals(4, arr.getSize());
    assertEquals(4, arr.getCapacity());
    assertEquals(1, arr.get(0));
    assertEquals(2, arr.get(1));
    assertEquals(3, arr.get(2));
    assertEquals(4, arr.get(3));
  }
}
