package BinaryTree.Misc;



public class CreateEvenOddLoop {
    static class Node {
        int data;
        Node left, right, arb;
        public Node(int data) {
            this.data = data;
            left = right =arb = null;
        }
    }
    static class Result {
        Node oddListHead;
        Node evenListHead;
        Node oddListTail;
        Node evenListTail;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        createLoops(root);
    }

    private static void createLoops(Node root) {
        if(root == null) {
            return;
        }

        Result result = new Result();
        createLoopsUtil(root, result);

        result.oddListTail.arb = result.oddListHead;
        result.evenListTail.arb = result.evenListHead;
        System.out.println("Odd List");
        traverseAndPrintLoop(result.oddListHead);
        System.out.println("Even List");
        traverseAndPrintLoop(result.evenListHead);
    }

    private static void traverseAndPrintLoop(Node head) {
        Node current = head;
        do {
            System.out.println(current.data);
            current = current.arb;
        }while(current != head);
    }

    private static void createLoopsUtil(Node root, Result result) {
        if(root == null) {
            return;
        }

        if(root.data % 2 == 0) {
            if(result.evenListHead == null) {
                result.evenListHead = root;
                result.evenListTail = root;
            } else {
                result.evenListTail.arb = root;
                result.evenListTail = root;
            }
        } else {
            if(result.oddListHead == null) {
                result.oddListHead = root;
                result.oddListTail = root;
            } else {
                result.oddListTail.arb = root;
                result.oddListTail = root;
            }
        }
        createLoopsUtil(root.left, result);
        createLoopsUtil(root.right, result);
    }
}
