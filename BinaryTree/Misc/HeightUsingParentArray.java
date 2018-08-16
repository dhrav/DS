package BinaryTree.Misc;

public class HeightUsingParentArray {
    public static void main(String[] args) {
        //int parent[] = new int[]{-1, 0, 0, 1, 1, 3, 5};
        int parent[] = new int[]{1,5,5, 2, 2, -1, 3};
        System.out.println(findHeight(parent));
    }

    private static int findHeight(int[] parent) {
        int length = parent.length;
        int[] depth = new int[length];

        //fill depth array
        for(int i =0; i<length; i++) {
            depth[i] = findHeightUtil(parent, i);
        }

        //loop thru depth array and find the max height/depth
        int maxDepth = Integer.MIN_VALUE;
        for(int i : depth) {
            if(maxDepth < i) {
                maxDepth = i;
            }
        }
        return maxDepth;
    }

    private static int findHeightUtil(int[] parent, int i) {
        if(parent[i] == -1) {
            return 1;
        }

        return 1+ findHeightUtil(parent, parent[i]);
    }
}
