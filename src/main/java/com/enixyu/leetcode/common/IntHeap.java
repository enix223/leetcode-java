package com.enixyu.leetcode.common;

public interface IntHeap {
  /**
   * Add item into the heap
   *
   * @param val item to add
   */
  void add(int val);

  /**
   * Get the first node of the heap
   *
   * @return max value for max heap, otherwise min value for min heap
   */
  int peek();

  /**
   * Remove item from the first node of the heap
   *
   * @return max value for max heap, otherwise min value for min heap
   */
  int remove();

  /**
   * Return the size of the heap
   *
   * @return the size
   */
  int size();

  /**
   * Return the capacity of the heap, if no limit for the heap then return 0
   *
   * @return heap capacity
   */
  int cap();

  /**
   * Check if the heap is empty or not
   *
   * @return true if empty, false otherwise
   */
  boolean isEmpty();
}
