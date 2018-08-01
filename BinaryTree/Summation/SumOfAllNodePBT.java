package BinaryTree.Summation;

public class SumOfAllNodePBT {
    public static void main(String[] args) {
        //int levelsPresent = 3;
        int levelsPresent = 2;
        System.out.println(getSum(levelsPresent));
    }

    private static int getSum(int levelsPresent) {
        if(levelsPresent == 0) {
            return 0;
        }

        int leafNodeCount = (int)(Math.pow(2, levelsPresent))/2;
        int leafNodeSum = (leafNodeCount * (leafNodeCount + 1)) /2;

        return leafNodeSum * levelsPresent;
    }
}
