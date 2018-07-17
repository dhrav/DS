package BinaryTree;

public class PostOrderFromPreOrderBST {

    public static void main(String[] args) {
        int preOrder[] = { 40, 30, 35, 80, 100 };
       // int preOrder[] = { 12,9,5,4,7,10,15,13,19,16 };
        //int preOrder[] = { 40, 30, 35 };
        printPostOrder(preOrder, 1, preOrder.length-1, 0);
    }

    private static void printPostOrder(int[] preOrder, int low, int high, int preIndex) {
        if(low > high) {
            System.out.println(preOrder[preIndex]);
            return;
        } else if(low == high) {
            System.out.println(preOrder[low]);
            System.out.println(preOrder[preIndex]);
            return;
        }
        int root = preOrder[preIndex];
        int index;
        for(index = low; index <= high; index++) {
            if(root <= preOrder[index]) {
                break;
            }
        }

        //left subtree
        printPostOrder(preOrder, preIndex+ 2, index-1, preIndex+ 1);

        //right subtree
        printPostOrder(preOrder, index+1, high, index);

        //process data
        System.out.println(root);
    }
}
