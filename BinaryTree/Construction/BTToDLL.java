package BinaryTree.Construction;

public class BTToDLL {
    static DLLNode head = null;
    static DLLNode prev = null;

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);

        convertToList(root);
        printList(head);

    }

    private static void printList(DLLNode head) {
        DLLNode current = head;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    private static void convertToList(Node root) {
        if(root == null) {
            return;
        }
        convertToList(root.left);

        DLLNode listNode = new DLLNode(root.data);

        if(head == null) {
            head = listNode;
        }

        if(prev != null) {
            prev.next = listNode;
        }
        listNode.prev = prev;
        prev = listNode;

        convertToList(root.right);
    }
}
