package BinaryTree.Misc;

import BinaryTree.Node;

public class SubTreeWithOddCountOfEvenNumbers {
    static class Result {
        int subTreeWithOddCountOfEvenNumber;
    }
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left        = new Node(1);
        root.right       = new Node(3);
        root.left.left  = new Node(4);
        root.left.right = new Node(10);
        root.right.left  = new Node(8);
        root.right.right = new Node(5);
        root.left.right.left = new Node(6);


        Result result = new Result();
        countSubTree(root, result);
        System.out.println(result.subTreeWithOddCountOfEvenNumber);
    }

    private static int countSubTree(Node root, Result result) {
        if(root == null) {
            return 0;
        }

        int leftSubTreeCount = countSubTree(root.left,result);
        int rightSubTreeCount = countSubTree(root.right, result);
        int currentCount = 0;
        if(root.data % 2 == 0) {
            currentCount = 1;
        }

        int subTreeEvenCount = currentCount + leftSubTreeCount + rightSubTreeCount;
        if(subTreeEvenCount % 2 != 0) {
            result.subTreeWithOddCountOfEvenNumber += 1;
        }
        return subTreeEvenCount;
    }
}
