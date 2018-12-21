package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

import java.util.ArrayList;

public class FindPairSumInDiffBST {
    public static void main(String[] args) {
        int tree1[] = {8, 10, 3, 6, 1, 5, 7, 14, 13};
        int tree2[] = {5, 18, 2, 1, 3, 4};

        Node root1 = constructTree(tree1);
        Node root2 = constructTree(tree2);

        int sum = 10;
        findPairSum(root1, root2, sum);

    }

    private static void findPairSum(Node root1, Node root2, int sum) {
        ArrayList<Integer> nodeList1 = new ArrayList<>();
        ArrayList<Integer> nodeList2 = new ArrayList<>();

        inorder(root1, nodeList1);
        inorder(root2, nodeList2);

        int start = 0;
        int end = nodeList2.size()-1;

        int firstTreeSize = nodeList1.size();

        while(start < firstTreeSize && end >= 0) {
            int first = nodeList1.get(start);
            int second = nodeList2.get(end);
            int currentSum = first + second;
            if(currentSum == sum) {
                System.out.println("The pair is " + first + " and " + second);
                start++;
                end--;
            } else if(currentSum < sum) {
                start++;
            } else {
                end--;
            }
        }
    }

    private static void inorder(Node root, ArrayList<Integer> nodeList) {
        if(root == null) {
            return;
        }

        inorder(root.left, nodeList);
        nodeList.add(root.data);
        inorder(root.right, nodeList);
    }

    private static Node constructTree(int[] arr) {
        Node root = null;
        int size = arr.length;
        for(int i = 0; i < size; i++) {
            root = insert(arr[i], root);
        }
        return root;
    }

    private static Node insert(int i, Node root) {
        if(root == null) {
            return new Node(i);
        }

        if(root.data < i) {
            root.right = insert(i, root.right);
        } else if(root.data > i) {
            root.left = insert(i, root.left);
        }

        return root;
    }
}
