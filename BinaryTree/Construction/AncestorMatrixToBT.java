package BinaryTree.Construction;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AncestorMatrixToBT {
    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 1, 0 },
                { 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 0 }
        };
        Node root = constructTree(matrix);
        inorder(root);
    }

    private static Node constructTree(int[][] matrix) {
        int size = matrix.length;
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        int rowSum;

        for(int i=0;i<size;i++) {
            rowSum =0;
            for(int j=0; j<size;j++) {
                if(matrix[i][j] == 1){
                    rowSum++;
                }
            }
            if(map.get(rowSum) == null) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);

                map.put(rowSum, list);
            } else {
                List<Integer> list = map.get(rowSum);
                list.add(i);
            }
        }

        int[] parent = new int[size];
        Node[] allNode = new Node[size];
        Node root = null;

        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()) {
            for(int nodeIndex : entry.getValue()) {
                allNode[nodeIndex] = new Node(nodeIndex);

                root = allNode[nodeIndex];

                if(entry.getKey() > 0) {

                    for(int i=0; i < size; i++) {
                        if(parent[i] == 0 && matrix[nodeIndex][i] == 1) {

                            if(allNode[nodeIndex].left == null) {
                                allNode[nodeIndex].left =   allNode[i];
                            } else {
                                allNode[nodeIndex].right = allNode[i];
                            }
                            parent[i]=1;

                        }
                    }
                }
            }
        }
        return root;
    }

    private static void inorder(Node root) {
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
}
