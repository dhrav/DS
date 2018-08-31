package BinarySearchTree;

import BinaryTree.Node;

public class MergeBST {
    static int index;
    static Node root;
    public static void main(String[] args) {
        Node root1  = new Node(100);
        root1.left         = new Node(50);
        root1.right        = new Node(300);
        root1.left.left   = new Node(20);
        root1.left.right  = new Node(70);

        System.out.println("Tree1 :");
        inorder(root1);

        Node root2  = new Node(80);
        root2.left         = new Node(40);
        root2.right        = new Node(120);

        System.out.println();
        System.out.println("Tree2: ");
        inorder(root2);

        int arr1Size = getSize(root1);
        int arr2Size = getSize(root2);

        Node root = mergeBst(root1, root2, arr1Size, arr2Size);
        System.out.println();
        System.out.println("Merged Tree: ");
        inorder(root);
    }

    private static int getSize(Node root1) {
        if(root1 == null) {
            return 0;
        }

        return 1 + getSize(root1.left) + getSize(root1.right);
    }

    private static Node mergeBst(Node root1, Node root2, int arr1Size, int arr2Size) {
        if(root1 == null) {
            return root2;
        }

        if(root2 == null) {
            return root1;
        }

        int arr1[] = new int[arr1Size];
        getInorderArray(root1, arr1);
        index = 0;
        int arr2[] = new int[arr2Size];
        getInorderArray(root2, arr2);

        int arr[] = mergeArray(arr1, arr2);

        return constructBSTFromSortedArray(arr, 0, arr.length-1);

    }

    private static void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    private static Node constructBSTFromSortedArray(int[] arr, int low, int high) {
        if(low > high || high >= arr.length || low < 0) {
            return null;
        }

        if(low == high) {
            return new Node(arr[low]);
        }

        int middle = (high + low)/2;
        Node root = new Node(arr[middle]);
        root.left = constructBSTFromSortedArray(arr, low, middle-1);
        root.right = constructBSTFromSortedArray(arr, middle+1, high);
        return root;
    }

    private static int[] mergeArray(int[] arr1, int[] arr2) {
        int size1 = arr1.length;
        int size2 = arr2.length;

        int size = size1 + size2;
        int result[] = new int[size];
        int arrIndex = 0, i = 0, j=0;

        for( i = 0, j = 0; i < size1 && j < size2; ) {
            if(arr1[i] < arr2[j]) {
                result[arrIndex++] = arr1[i++];
            } else {
                result[arrIndex++] = arr2[j++];
            }
        }

        while(i < size1) {
            result[arrIndex++] = arr1[i++];
        }

        while(j < size2) {
            result[arrIndex++] = arr2[j++];
        }
        return result;
    }

    private static void getInorderArray(Node root, int[] arr) {
        if(root == null) {
            return;
        }

        getInorderArray(root.left, arr);
        arr[index++] = root.data;
        getInorderArray(root.right, arr);
    }
}
