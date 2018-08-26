package BinarySearchTree;

import BinaryTree.Node;

public class SortedLLToBalancedBST {
    static Node root;
    static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        //form a list which is in sorted order
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        constructBalancedBST(head);
        System.out.println("The constructed Tree is :");
        inorder(root);
    }

    private static ListNode findMiddle(ListNode head) {
        ListNode prev = null, slow = head, fast= head;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        return prev;
    }

    private static Node constructBalancedBST(ListNode head) {
        if(head == null) {
            return null;
        } else if (head.next == null) {
            return new Node(head.data);
        }

        ListNode prevMiddleNode = findMiddle(head);
        if(prevMiddleNode == null) {
            return null;
        }
        ListNode middleNode = prevMiddleNode.next;
        if(middleNode == null) {
            return null;
        }
        Node newNode = new Node(middleNode.data);

        if(root == null) {
            root = newNode;
        }
        ListNode secondHalf = middleNode.next;
        prevMiddleNode.next = null;
        newNode.left = constructBalancedBST(head);
        newNode.right = constructBalancedBST(secondHalf);
        return newNode;
    }

    private static void inorder(Node root) {
        if(root== null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
