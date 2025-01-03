# HybridGraph
This project introduces a hybrid approach combining adjecency matrix and adjecency list.

## Introduction

This project introduces approach to representing graphs that combines the memory efficiency of adjacency lists with the conceptual simplicity and direct access benefits of adjacency matrices.
This hybrid structure is particularly suitable for dynamic graphs where the number of nodes and edges can change over time.

## Key Features

1. **Dynamic Resizing**:

- Rows and columns are dynamically resized as needed, allowing the graph to grow without predefining its size.
- Unlike a traditional adjacency matrix, memory is only allocated for existing edges, mimicking the efficiency of adjacency lists.

2. **Efficient Access**:

- Provides O(1) access for edge queries (e.g., checking if an edge exists between two nodes).

3. **Memory Efficiency**:

- Avoids the O(V^2) memory overhead of a traditional adjacency matrix by allocating space only as required.

## Implementation Details

### Core Data Structure

The graph is represented as a list of lists, where each inner list corresponds to a row in the adjacency matrix. 
Rows are dynamically resized and have they lenght to the last node that is connected to. Mimicking adjacency list.

### Example Code
```
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
    while (matrix.size() <= src) {
      matrix.add(new ArrayList<>());
    }

    List<Integer> targetRow = matrix.get(src);
    while (targetRow.size() <= dest) {
      targetRow.add(0);
    }

    targetRow.set(dest, 1);
  }

  public boolean checkEdge(int src, int dest) {
    if (src < matrix.size() && dest < matrix.get(src).size()) {
      return true;
    }

    return false;
  }
}
```

### Example Usage
```
Graph<Character> graph = new Graph<>();
graph.addNode(new Node<Character>('A'));
graph.addNode(new Node<Character>('B'));
graph.addNode(new Node<Character>('C'));

graph.addEdge(0, 1);
graph.addEdge(1, 2);
graph.addEdge(2, 0);

graph.print();
```

### Example Output

For the graph above, the output will be:

```
  A B C 
A 0 1  
B 0 0 1 
C 1   
```

## Applications

1. **Dynamic Graphs**:

- Ideal for scenarios where the graph size changes frequently.

2. **Sparse Graphs**:

- Efficient memory usage for graphs with fewer edges.

3. **Dense Graphs**:

- Maintains the fast access times of adjacency matrices while minimizing memory overhead.

## Limitations

Overhead of dynamic resizing may be less efficient than a static adjacency matrix for extremely dense graphs.
Slightly more complex implementation compared to traditional representations.

## Next Steps

1. **Performance Benchmarking**:

- Compare this approach with traditional adjacency matrices and lists for different graph densities.

2. **Expand Features**:

- Add support for weighted edges.
  Implement methods for removing nodes and edges.
