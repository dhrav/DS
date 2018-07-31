package BinaryTree.CheckingPrinting;

import java.util.LinkedList;

public class Graph {
    int vertices;
    LinkedList[] adjacencyList;
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for(int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source);
    }
}
