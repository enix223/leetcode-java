package com.enixyu.leetcode.common;

public class IntMaxHeap implements IntHeap {

  private static final int DEFAULT_INCREASE_FACTOR = 2;
  private final int increaseFactor;
  private int cap;
  private int[] elements;
  private int size;

  /**
   * Create max heap with given initial capacity
   *
   * @param cap the initial capacity of the heap
   */
  public IntMaxHeap(int cap) {
    this(null, cap, false, DEFAULT_INCREASE_FACTOR);
  }

  public IntMaxHeap(int[] elements, int cap, boolean copy) {
    this(elements, cap, copy, DEFAULT_INCREASE_FACTOR);
  }

  /**
   * Create max heap with initial elements, and initial capacity.
   *
   * @param elements initial elements
   * @param cap initial capacity of the heap
   * @param copy copy the initial elements to internal array or not
   */
  public IntMaxHeap(int[] elements, int cap, boolean copy, int increaseFactor) {
    if (cap <= 0 || (elements != null && cap < elements.length)) {
      throw new IllegalArgumentException("cap should be greater than 0");
    }
    this.cap = cap;
    this.size = elements == null ? 0 : elements.length;
    this.increaseFactor = increaseFactor;
    if (copy && elements != null) {
      this.elements = new int[cap];
      System.arraycopy(elements, 0, this.elements, 0, this.size);
    } else {
      this.elements = elements != null ? elements : new int[cap];
    }
    heapify();
  }

  @Override
  public void add(int val) {
    if (size == cap) {
      grow();
    }
    elements[size++] = val;
    up(size - 1);
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
        continue;
      }
      return;
    }
  }

  private void swap(int i, int j) {
    int t = elements[i];
    elements[i] = elements[j];
    elements[j] = t;
  }

  private void grow() {
    cap *= increaseFactor;
    int[] newElements = new int[cap];
    System.arraycopy(elements, 0, newElements, 0, size);
    elements = newElements;
  }
}
