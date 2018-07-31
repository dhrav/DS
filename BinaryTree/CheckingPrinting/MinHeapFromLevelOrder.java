package BinaryTree.CheckingPrinting;

public class MinHeapFromLevelOrder {
    public static void main(String[] args) {
       // int level[] = {10, 15, 14, 25, 30};
        int level[] = {30, 56, 22, 49, 30, 51, 2, 67};
        System.out.println(isMinHeap(level));
    }

    private static boolean checkForMinHeapProperty(int rootVal, int childVal) {
        return rootVal < childVal;
    }

    private static boolean isMinHeap(int[] level) {
        int size = level.length;
        int firstChild, secondChild;

        for(int i = 0; i < size; i++) {
            firstChild = (2*i) + 1;
            if(firstChild < size) {
                if(!checkForMinHeapProperty(level[i], level[firstChild])) {
                    return false;
                }
            }

            secondChild = (2*i) + 2;
            if(secondChild < size) {
                if(!checkForMinHeapProperty(level[i], level[secondChild])) {
                    return false;
                }
            }
        }
        return true;
    }
}
