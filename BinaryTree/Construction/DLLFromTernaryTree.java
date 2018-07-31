package BinaryTree.Construction;

class TernaryNode {
    int data;
    TernaryNode left, middle, right;

    TernaryNode(int data) {
        this.data = data;
        left = null;
        middle = null;
        right = null;
    }
}

class DLLNode {
    int data;
    DLLNode prev, next;
    DLLNode(int data) {
        this.data = data;
        prev = null;
        next = null;
    }
}

public class DLLFromTernaryTree {
    static DLLNode prev = null;
    static DLLNode head = null;
    static DLLNode tail = null;
    public static void main(String[] args) {
        TernaryNode root = new TernaryNode(30);
        root.left = new TernaryNode(5);
        root.middle = new TernaryNode(11);
        root.right = new TernaryNode(63);
        root.left.left = new TernaryNode(1);
        root.left.middle = new TernaryNode(4);
        root.left.right = new TernaryNode(8);
        root.middle.left = new TernaryNode(6);
        root.middle.middle = new TernaryNode(7);
        root.middle.right = new TernaryNode(15);
        root.right.left = new TernaryNode(31);
        root.right.middle = new TernaryNode(55);
        root.right.right = new TernaryNode(65);

        buildList(root);
        printList(head);
    }

    private static void buildList(TernaryNode root) {
        if(root == null) {
            return;
        }

        DLLNode newNode = new DLLNode(root.data);
        addToList(newNode);
        buildList(root.left);
        buildList(root.middle);
        buildList(root.right);
    }

    private static void addToList(DLLNode newNode) {
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
           tail.next = newNode;
           newNode.prev = tail;
           tail = newNode;
        }
    }

    private static void printList(DLLNode head) {
        DLLNode current = head;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }


}
