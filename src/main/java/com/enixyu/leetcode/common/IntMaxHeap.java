package com.enixyu.leetcode.common;

public class IntMaxHeap implements IntHeap {

  private final float loadFactor;
  private int cap;
  private int[] elements;
  private int size;

  /**
   * Create max heap with given capacity, if cap is 0, then the heap size will be not limit.
   *
   * @param cap the max capacity of the heap
   */
  public IntMaxHeap(int cap) {
    if (cap < 0) {
      throw new IllegalArgumentException("cap should be greater than or equal 0");
    }
    this.loadFactor = 0.5f;
    this.cap = cap;
    this.size = 0;
    this.elements = new int[cap];
  }

  /**
   * Create max heap with initial elements, and max capacity.
   *
   * @param elements initial elements
   * @param cap capacity of the heap, 0 means not limit
   * @param copy copy the initial elements to internal array or not
   */
  public IntMaxHeap(int[] elements, int cap, boolean copy) {
    this.cap = cap;
    this.loadFactor = 0.5f;
    this.size = elements.length;
    if (copy) {
      this.elements = new int[cap];
      System.arraycopy(elements, 0, this.elements, 0, this.size);
    } else {
      this.elements = elements;
    }
    heapify();
  }

  @Override
  public void add(int val) {
    if (isFull()) {
      throw new ArrayIndexOutOfBoundsException("heap is full");
    }
    if (size == cap) {
      grow();
    }
  }

  @Override
  public int peek() {
    return elements[0];
  }

  @Override
  public int remove() {
    int res = elements[0];
    swap(0, --size);
    down(0, size);
    return res;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public int cap() {
    return cap;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean isFull() {
    return cap > 0 && size == cap;
  }

  /** Convert the element array to heap */
  private void heapify() {
    for (int i = (size - 1) / 2; i >= 0; i--) {
      down(i, size);
    }
  }

  private void down(int i, int bound) {
    while (true) {
      int l = i * 2 + 1;
      int r = l + 1;
      int max = i;
      if (l < bound && elements[l] > elements[max]) {
        max = l;
      }
      if (r < bound && elements[r] > elements[max]) {
        max = r;
      }
      if (max != i) {
        swap(i, max);
        continue;
      }
      return;
    }
  }

  private void up(int i) {
    while (i > 0) {
      int parent = (i - 1) / 2;
      if (elements[parent] < elements[i]) {
        swap(parent, i);
        i = parent;
      }
    }
  }

  private void swap(int i, int j) {
    int t = elements[i];
    elements[i] = elements[j];
    elements[j] = t;
  }

  private void grow() {
    this.cap *= 2;
  }
}
