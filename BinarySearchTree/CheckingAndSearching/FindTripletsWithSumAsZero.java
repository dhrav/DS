package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class FindTripletsWithSumAsZero {
    static Node head, tail;
    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(-13);
        root.right = new Node(14);
        root.left.right = new Node(-8);
        root.right.left = new Node(13);
        root.right.left.left = new Node(7);
        root.right.right = new Node(15);

        System.out.println(checkIfTripletExists(root));
    }

    private static boolean checkIfTripletExists(Node root) {
        if(root == null) {
            return true;
        }

        //Requirement :O(n^2) complexity and O(log n) space
        //convert the bst to dll and for each element, find if sum of any two element in the list is -element
        convertBSTToDLL(root);

        //search from head to tail whether an element with value of (-element) exists
        while(head.right != null && head.data < 0) {
            if(isPresentInDLL(head.right, tail, -1*head.data)) {
                return true;
            } else{
                head = head.right;
            }
        }
        return false;
    }

    private static boolean isPresentInDLL(Node head, Node tail, int key) {
        while(head != tail) {
            int sum = head.data + tail.data;
            if(sum < key) {
                head = head.right;
            } else if(sum > key) {
                tail = tail.left;
            } else {
                return true; //if key is found
            }
        }
        return false;
    }

    private static void convertBSTToDLL(Node root) {
        if(root == null) {
            return;
        }

        convertBSTToDLL(root.left);
        //process root
        if(tail != null) {
            tail.right = root;
            root.left = tail;
        } else {
            head = root;
        }

        tail = root;

        convertBSTToDLL(root.right);
    }
}
