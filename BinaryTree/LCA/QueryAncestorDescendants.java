package BinaryTree.LCA;

import BinaryTree.CheckingPrinting.Graph;

import java.util.List;

public class QueryAncestorDescendants {
    static int count;
    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(4,6);
        graph.addEdge(5,7);

        System.out.println(preProcessAndFindIfAncestor(graph, 1, 6));
    }

    private static boolean preProcessAndFindIfAncestor(Graph graph, int startVertex, int endVertex) {
        int vertices = graph.getVertices();
        int[] timeIn = new int[vertices];
        int[] timeOut = new int[vertices];
        boolean[] visited = new boolean[vertices];

        dfs(graph, 0, timeIn, timeOut, visited);

        return isAncestor(timeIn, timeOut, startVertex, endVertex);
    }

    private static boolean isAncestor(int[] timeIn, int[] timeOut, int startVertex, int endVertex) {
        if(timeIn[startVertex] < timeIn[endVertex] &&
                timeOut[endVertex] < timeOut[startVertex]) {
            return true;
        }
        return false;
    }

    private static void dfs(Graph graph, int startVertice, int[] timeIn, int[] timeOut, boolean[] visited) {
        visited[startVertice] = true;
        timeIn[startVertice] = count++;

        List<Integer> adjacencyList = graph.getAdjacencyList()[startVertice];
        for(int vertice : adjacencyList) {
            if(!visited[vertice]) {
                dfs(graph, vertice, timeIn, timeOut, visited);
            }
        }

        timeOut[startVertice] = count++;
    }
}
