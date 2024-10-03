package com.enixyu.leetcode.common;

public class DynamicIntArray {
  private int size;
  private int capacity;
  private int[] data;

  public DynamicIntArray(int[] initData, int capacity) {
    if (capacity < initData.length) {
      throw new IllegalArgumentException("capacity should greater than or equal init data size");
    }
    this.capacity = capacity;
    size = initData.length;
    data = new int[capacity];
    System.arraycopy(initData, 0, data, 0, initData.length);
  }

  public DynamicIntArray(int capacity) {
    this.capacity = capacity;
    size = 0;
    data = new int[capacity];
  }

  public int get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("index invalid");
    }
    return data[index];
  }

  public void add(int index, int element) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("index invalid");
    }
    if (size == capacity) {
      // need expand
      capacity *= 2;
      int[] newData = new int[capacity];
      if (index > 0) {
        // copy left part
        System.arraycopy(data, 0, newData, 0, index);
      }
      if (index < size) {
        // copy the right part
        System.arraycopy(data, index, newData, index + 1, size - index);
      }
      data = newData;
    } else if (index < size) {
      System.arraycopy(data, index, data, index + 1, size - index);
    }
    data[index] = element;
    size++;
  }

  public void delete(int index) {
    assertIndex(index);
    if (size - index - 1 > 0) {
      System.arraycopy(data, index + 1, data, index, size - index - 1);
    }
    size--;
  }

  public void shrink() {
    if (size == capacity) {
      return;
    }
    int[] newData = new int[size];
    capacity = size;
    System.arraycopy(data, 0, newData, 0, size);
    data = newData;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int getSize() {
    return size;
  }

  public int getCapacity() {
    return capacity;
  }

  private void assertIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("index invalid");
    }
  }
}
