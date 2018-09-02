package BinarySearchTree.CheckingAndSearching;

public class CheckIfInternalNodeHasOneChildren {
    public static void main(String[] args) {
        //int[] preorder = {8, 3, 5, 7, 6};
        int[] preorder = {20, 10, 9, 11, 13, 12};
        System.out.println(checkIfBSThasOnlyOneChild(preorder));
    }

    private static boolean checkIfBSThasOnlyOneChild(int[] preorder) {
        int size = preorder.length;
        if(size == 1 || size == 2) {
            return true;
        }

        int min, max;
        if(preorder[size-1] < preorder[size-2]) {
            min = preorder[size-1];
            max = preorder[size-2];
        } else {
            max = preorder[size-1];
            min = preorder[size-2];
        }

        for(int i = size -3; i >= 0; i--) {
            if(preorder[i] < min) {
                min = preorder[i];
            } else if(preorder[i] > max) {
                max = preorder[i];
            } else {
                return false;
            }
        }
        return true;
    }
}
