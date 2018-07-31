package BinaryTree;

public class NumberOfBTUsingPreorder {
    public static void main(String[] args) {
        int nodeCount = 5;
        System.out.println(findCountofTrees(nodeCount));
    }

    private static int findCountofTrees(int nodeCount) {
        int[] treeLevels = new int[nodeCount+1];
        treeLevels[0] = 1;
        treeLevels[1] = 1;
        for(int i = 2; i<= nodeCount; i++) {
            for(int j = 0; j < i; j++) {
                treeLevels[i] += treeLevels[j] * treeLevels[i-j-1];
            }
        }
        return treeLevels[nodeCount];
    }
}
