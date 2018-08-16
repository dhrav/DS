package BinaryTree.Misc;

import BinaryTree.Node;

import java.util.HashSet;

public class VerticalWidth {
    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(6);
        root.right = new Node(5);
        root.left.left = new Node(4);
        root.left.right = new Node(3);
        root.right.left = new Node(2);
        root.right.right = new Node(1);

        System.out.println(findVerticalWidth(root));
    }

    private static int findVerticalWidth(Node root) {
        if(root == null) {
            return 0;
        }

        HashSet<Integer> horizontalDistanceSet = new HashSet<>();

        findVerticalWidthUtil(root, horizontalDistanceSet, 0);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i :horizontalDistanceSet) {
            if(i < min) {
                min = i;
            }

            if(i > max) {
                max = i;
            }
        }

        return Math.abs(min) + max + 1;
    }

    private static void findVerticalWidthUtil(Node root, HashSet<Integer> horizontalDistanceSet, int horizDistance) {
        if(root == null) {
            return;
        }

        if(!horizontalDistanceSet.contains(horizDistance)) {
            horizontalDistanceSet.add(horizDistance);
        }

        findVerticalWidthUtil(root.left, horizontalDistanceSet, horizDistance-1);
        findVerticalWidthUtil(root.right, horizontalDistanceSet, horizDistance+1);
    }
}
