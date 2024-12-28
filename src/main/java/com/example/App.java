package com.example;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {

    Graph<Character> graph = new Graph<Character>();

    graph.addNode(new Node<Character>('A'));
    graph.addNode(new Node<Character>('B'));
    graph.addNode(new Node<Character>('C'));

    graph.addEdge(0, 1);
    graph.addEdge(1, 2);
    graph.addEdge(2, 0);
    
    graph.print();

    System.out.println("------------");
    System.out.println("Connection between A and B: " + graph.checkEdge(0, 1));

  }
}
