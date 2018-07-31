package BinaryTree.CheckingPrinting;

import BinaryTree.Node;

public class CoveredUncovered {
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);

        root.left.left = new Node(1);
       //root.left.right = new Node(6);
        root.left.right = new Node(36);
        //root.left.right.left = new Node(4);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);

        root.right = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        System.out.println(checkCoveredUncoveredSum(root));
    }

    private static boolean checkCoveredUncoveredSum(Node root) {
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }

        int totalSum = getTotalSum(root);
        int uncoveredSum = 0;

        //find left boundary
        Node current = root;
        while(current != null) {
            uncoveredSum += current.data;
            if(current.left == null) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        current = root.right;
        while(current != null) {
            uncoveredSum += current.data;
            if(current.right == null) {
                current = current.left;
            } else {
                current = current.right;
            }
        }


        return ((totalSum - uncoveredSum) == uncoveredSum);
    }

    private static int getTotalSum(Node root) {
        if(root == null) {
            return 0;
        }

        return root.data + getTotalSum(root.left) + getTotalSum(root.right);
    }
}
