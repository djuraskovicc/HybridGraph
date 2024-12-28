package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Adjecency Hybrid
 */
public class Graph<T> {
  private List<List<Integer>> matrix;
  private List<Node<T>> nodes;

  public Graph() {
    super();
    this.matrix = new ArrayList<>();
    this.nodes = new ArrayList<>();
  }

  public void addNode(Node<T> node) {
    nodes.add(node);
  }

  public void addEdge(int src, int dest) {
    // Ensure enough rows
    while (matrix.size() <= src) {
      matrix.add(new ArrayList<>());
    }

    // Ensure enough columns in the specified row
    List<Integer> targetRow = matrix.get(src);
    while (targetRow.size() <= dest) {
      targetRow.add(0); // Add placeholder values (e.g., 0 for no edge)
    }

    targetRow.set(dest, 1); // 1 represents an edge from src to dest   matrix.set(src, dest);
  }

  public boolean checkEdge(int src, int dest) {
    if (src < matrix.size() && dest < matrix.get(src).size()) {
      return true;
    }

    return false;
  }

  public void print() {
    System.out.print("  ");
    for (Node<T> node : nodes) {
      System.out.print(node.getData() + " ");
    }
    System.out.println();

    for (int i = 0; i < matrix.size(); i++) {
      System.out.print(nodes.get(i).getData() + " ");
      for (int j = 0; j < matrix.get(i).size(); j++) {
        System.out.print(matrix.get(i).get(j) + " ");
      }
      System.out.println();
    }
  }
}