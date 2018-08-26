package BinarySearchTree;

import BinaryTree.Node;

public class SortedLLToBalancedBSTLeafToRoot {
    static Node root;
    static ListNode head;
    static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        constructBST(head);

    }

    private static void constructBST(ListNode head) {
        root = constructBSTUtil(countNode(head));
        inorder(root);
    }

    private static void inorder(Node root) {
        if(root== null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    private static Node constructBSTUtil(int count) {
        if(count <= 0) {
            return null;
        }
        //take n/2 nodes and make it as left subtree
        Node leftSubTree = constructBSTUtil(count/2);

        //make root link
        Node root = new Node(head.data);
        head = head.next;
        // take the rest and make it as right subtree
        Node rightSubTree = constructBSTUtil(count - (count/2) - 1);

        root.left = leftSubTree;
        root.right = rightSubTree;
        return root;
    }

    private static int countNode(ListNode head) {
        ListNode current = head;
        int count = 0;
        while(current != null) {
            count+=1;
            current = current.next;
        }
        return count;
    }
}
