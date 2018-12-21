package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

import java.util.Stack;

public class FindPairSumInBalancedBST {
    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(18);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);

        int sum = 33;
        System.out.println(findPair(root, sum));
    }

    private static boolean findPair(Node root, int sum) {
        Stack<Node> tree1 = new Stack<>();
        Stack<Node> tree2 = new Stack<>();

        boolean result = false;
        Node current1 = root;
        Node current2 = root;

        while(true) {
            if(current1 != null || current2 != null) {
                if(current1 != null) {
                    while(current1 != null) {
                        tree1.push(current1);
                        current1 = current1.left;
                    }
                }

                if(current2 != null) {
                    while(current2 != null) {
                        tree2.push(current2);
                        current2 = current2.right;
                    }
                }
            } else {
                if(tree1.isEmpty() || tree2.isEmpty()) {
                    break;
                }

                Node tree1Top = tree1.peek();
                Node tree2Top = tree2.peek();

                int currentSum = tree1Top.data + tree2Top.data;
                if(currentSum == sum) {
                    result = true;
                    break;
                }else if(currentSum < sum) {
                    current1 = tree1.pop();
                    current1 = current1.right;
                } else {
                    current2 = tree2.pop();
                    current2 = current2.left;
                }

            }
        }
        return result;
    }
}
