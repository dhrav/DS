package BinaryTree.CheckingPrinting;

public class GraphIsTree {
    public static void main(String[] args) {
        int vertices = 5;
        Graph graph = new Graph(vertices);
        graph.addEdge(1,0);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(3,4);

        System.out.println(isTree(graph));


        Graph g2 = new Graph(5);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);

        System.out.println(isTree(g2));

    }

    private static boolean isTree(Graph graph) {
        boolean[] visited = new boolean[graph.vertices];

        //Check if cycle is present in the graph
        boolean isCyclePresent = isCyclePresent(graph, 0, visited, -1);
        if(isCyclePresent) {
            return false;
        }


        //Check if all of the vertices are connected
        for(int i=0; i< graph.vertices; i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCyclePresent(Graph graph, int startVertice, boolean[] visited, int parent) {
        visited[startVertice] = true;

        for(Object v : graph.adjacencyList[startVertice]) {
            int vertice = (Integer)v;
            if (!visited[vertice]) {
                if (isCyclePresent(graph, vertice, visited, startVertice)) {
                    return true;
                }
            } else if (parent != vertice) {
                return true;
            }

        }
        return false;
    }
}
