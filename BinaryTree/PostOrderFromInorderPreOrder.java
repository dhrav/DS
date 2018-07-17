package BinaryTree;

public class PostOrderFromInorderPreOrder {
    int preIndex=0;
    public static void main(String[] args) {
        int[] inOrder = {4, 2, 5, 1, 3, 6};
        int[] preOrder = {1, 2, 4, 5, 3, 6};
        PostOrderFromInorderPreOrder object = new PostOrderFromInorderPreOrder();
        object.printPostOrder(preOrder, inOrder, 0, inOrder.length - 1);
    }

    private void printPostOrder(int[] preOrder, int[] inOrder, int low, int high) {
        if (low > high) {
            return;
        } else if(low == high) {
            System.out.println(preOrder[preIndex++]);
            return;
        }

        int root = preOrder[preIndex++];
        int index;
        for(index =low; index < high; index++) {
            if(root == inOrder[index]) {
                break;
            }
        }

        //left subtree
        printPostOrder(preOrder, inOrder, low, index-1);
        //right subtree
        printPostOrder(preOrder, inOrder, index+1, high);
        //print data
        System.out.println(root);

    }
}
