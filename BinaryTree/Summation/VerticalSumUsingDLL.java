package BinaryTree.Summation;

import BinaryTree.Node;

public class VerticalSumUsingDLL {
    class DLLNode {
        int data;
        DLLNode prev, next;
        DLLNode(int data) {
            this.data = data;
            prev = next = null;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        VerticalSumUsingDLL object = new VerticalSumUsingDLL();

        object.printVerticalSum(root);
    }

    private void printVerticalSum(Node root) {
        if(root == null) {
            return;
        }

        DLLNode head = new DLLNode(root.data);
        printVerticalSumUtil(root, head);

        DLLNode current = head;
        while(current.prev != null) {
            current = current.prev;
        }

        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    private void printVerticalSumUtil(Node root, DLLNode head) {
        if(root == null) {
            return;
        }

        if(root.left != null) {
            if(head.prev == null) {
                DLLNode temp = new DLLNode(root.left.data);
                head.prev = temp;
                temp.next = head;

                printVerticalSumUtil(root.left, temp);
            } else {
                head.prev.data += root.left.data;
            }
        }

        if(root.right != null) {
            if(head.next == null) {
                DLLNode temp = new DLLNode(root.right.data);
                head.next = temp;
                temp.prev = head;
                printVerticalSumUtil(root.right, temp);
            } else {
                head.next.data += root.right.data;
            }
        }
    }
}
