package com.example;

/**
 * Node
 */
public class Node<T> {
  private T data;

  public Node(T data) {
    super();
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
