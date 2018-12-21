package BinarySearchTree.Misc;

public class PrintSortedOrderBST {
    public static void main(String[] args) {
        int arr[] = {4, 2, 5, 1, 3};
        printSortedOrder(arr, 0, arr.length-1);
    }

    private static void printSortedOrder(int[] arr, int start, int end) {
        if(start > end) {
            return;
        }

        //process left child
        printSortedOrder(arr, (2*start)+1, end);

        //process root
        System.out.print(arr[start] + " ");

        //process right child
        printSortedOrder(arr, (2*start) + 2, end);


    }
}
