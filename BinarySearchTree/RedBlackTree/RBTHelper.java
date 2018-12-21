package BinarySearchTree.RedBlackTree;

import java.util.concurrent.atomic.AtomicInteger;

public class RBTHelper {
    public static boolean noRedRedRelation(Node root, Colour parentColour) {
        if(root == null) {
            return true;
        }

        if(root.isColour(Colour.RED) && parentColour.equals(Colour.RED)) {
            return false;
        }

        return noRedRedRelation(root.getLeft(), root.getColour()) && noRedRedRelation(root.getRight(), root.getColour());
    }

    public static boolean checkBlackNodeCount(Node root, AtomicInteger blackNodeCount, int currentCount) {
        if(root == null) {
            return currentCount == blackNodeCount.get();
        }

        if(root.isColour(Colour.BLACK)) {
            currentCount++;
        }

        if(root.getLeft() == null && root.getRight() == null) {
            //we are in a leaf/end of a path

            //if blackNode count is empty, then it is the first path to be evaluated
            //so set the current count as black count to check later
            if(blackNodeCount.get() == 0) {
                blackNodeCount.set(currentCount);
                return true;
            } else {
                //we are in second path from root node to leaf
                return blackNodeCount.get() == currentCount;
            }
        }

        return checkBlackNodeCount(root.getLeft(), blackNodeCount, currentCount) && checkBlackNodeCount(root.getRight(), blackNodeCount, currentCount);


    }

    public static boolean validateRedBlackRelation(Node root) {
        if(root == null) {
            return true;
        }

        if(!root.isColour(Colour.BLACK)) {
            System.out.println("Root is not black");
            return false;
        }

        AtomicInteger blackNodeCount = new AtomicInteger(0);
        return checkBlackNodeCount(root, blackNodeCount, 0) && noRedRedRelation(root, Colour.BLACK);
    }


}
