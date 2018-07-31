package BinaryTree.Construction;

import java.util.LinkedList;

public class ForestOfEvenNode {
    static int answer = 0;
    public static void main(String[] args) {
        LinkedList[] nodeList = new LinkedList[10];
        nodeList[0] = new LinkedList<Integer>();
        nodeList[0].add(1);
        nodeList[0].add(5);
        nodeList[0].add(2);

        nodeList[1] = new LinkedList<Integer>();
        nodeList[1].add(6);
        nodeList[1].add(4);

        nodeList[5] = new LinkedList<Integer>();
        nodeList[5].add(7);

        nodeList[2] = new LinkedList<Integer>();
        nodeList[2].add(3);

        nodeList[3] = new LinkedList<Integer>();
        nodeList[3].add(9);
        nodeList[3].add(8);

        nodeList[9] = new LinkedList<Integer>();
        nodeList[8] = new LinkedList<Integer>();
        nodeList[6] = new LinkedList<Integer>();
        nodeList[4] = new LinkedList<Integer>();
        nodeList[7] = new LinkedList<Integer>();

        int result = findMinEdge(nodeList, 10);
        System.out.println("Min Edge to be removed is :" + result);
    }

    private static int findMinEdge(LinkedList[] nodeList, int size) {
        boolean[] visited = new boolean[size];

        dfs(nodeList,  visited, 0);
        return answer;
    }

    private static int dfs(LinkedList[] nodeList, boolean[] visited, int startNode) {
        visited[startNode] = true;
        int current = 0;
        int subTree;

        LinkedList<Integer> edgeList = nodeList[startNode];
        for(Integer node : edgeList) {
            if(!visited[node]) {
                subTree = dfs(nodeList,visited, node);
                if(subTree %2 == 0) {
                   ++answer;
                } else {
                   current+=subTree;
                }
            }
        }
        return current+1;
    }
}
