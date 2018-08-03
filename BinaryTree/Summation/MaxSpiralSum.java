package BinaryTree.Summation;

import BinaryTree.Node;

import java.util.*;

public class MaxSpiralSum {
    public static void main(String[] args) {
        Node root = new Node(-2);
        root.left = new Node(-3);
        root.right = new Node(4);
        root.left.left = new Node(5);
        root.left.right = new Node(1);
        root.right.left = new Node(-2);
        root.right.right = new Node(-1);
        root.left.left.left = new Node(-3);
        root.right.right.right = new Node(2);

        System.out.println(findMaxSpiralSum(root));
    }

    private static int findMaxSpiralSum(Node root) {
        if(root == null) {
            return 0;
        }

        List<Integer> spiralNodeTraversalList = new ArrayList<>();

        boolean isCurrentLevelReverse = true;
        Stack<Node> currentLevelStack = new Stack<>();
        Stack<Node> nextLevelStack = new Stack<>();
        currentLevelStack.push(root);

        while(!currentLevelStack.isEmpty()) {
            Node element = currentLevelStack.pop();
            spiralNodeTraversalList.add(element.data);

            if(isCurrentLevelReverse) {
                if(element.right != null) {
                    nextLevelStack.push(element.right);
                }

                if(element.left != null) {
                    nextLevelStack.push(element.left);
                }
            } else {
                if(element.left != null) {
                    nextLevelStack.push(element.left);
                }

                if(element.right != null) {
                    nextLevelStack.push(element.right);
                }
            }

            if(currentLevelStack.isEmpty()) {
                Stack<Node> temp = currentLevelStack;
                currentLevelStack = nextLevelStack;
                nextLevelStack = temp;
                isCurrentLevelReverse = !isCurrentLevelReverse;
            }

        }

        int maxSoFar = 0, currentMax = 0;

        for(int i= 0; i < spiralNodeTraversalList.size(); i++) {
            currentMax = currentMax+spiralNodeTraversalList.get(i);
            if(currentMax < 0) {
                currentMax = 0;
            } else {
                maxSoFar = Math.max(maxSoFar, currentMax);
            }
        }

        //to be corrected
        return maxSoFar;
    }
}
