package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class CheckIfBSTContainsSortedSequence {
    static class Result {
        int currentIndex;
        boolean isMatchFound;
        boolean isSequencePresent;
        int maxLength;
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.left.right.left = new Node(4);
        root.right.right.left = new Node(13);
        root.left.right.right = new Node(7);

        int[] sequence = {4, 6, 8, 14};
        System.out.println(checkIfSequencePresent(root, sequence));

        int[] sequence2 = {4, 6, 8, 12, 13};
        System.out.println(checkIfSequencePresent(root, sequence2));

    }

    private static boolean checkIfSequencePresent(Node root, int[] sequence) {
        if(root == null){
            return false;
        }
        Result result = new Result();
        result.maxLength = sequence.length;

        checkIfSequencePresentUtil(root, sequence, result);
        return result.isSequencePresent;
    }

    private static void checkIfSequencePresentUtil(Node root, int[] sequence, Result result) {
        if(root == null) {
            return;
        }

        checkIfSequencePresentUtil(root.left, sequence, result);
        //process root
        if(!result.isMatchFound && root.data == sequence[result.currentIndex]) {
            result.isMatchFound = true;
            result.currentIndex+=1;
        } else {
            if(result.currentIndex < result.maxLength && root.data == sequence[result.currentIndex]) {
                result.currentIndex +=1;
            }

            if(result.currentIndex == result.maxLength) {
                result.isSequencePresent = true;
            }
        }
        checkIfSequencePresentUtil(root.right, sequence, result);
    }
}
