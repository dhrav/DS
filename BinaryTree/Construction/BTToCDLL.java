package BinaryTree.Construction;

public class BTToCDLL {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);

        root = convertToList(root);
        printList(root);
    }

    private static void printList(Node root) {
        Node current = root;
        do {
            System.out.println(current.data);
            current = current.right;
        }
        while(current != root);
    }

    private static Node convertToList(Node root) {
        if(root == null) {
            return root;
        }

        Node left = convertToList(root.left);
        Node right = convertToList(root.right);

        root.left = root;
        root.right = root;

        return concateList(concateList(left, root), right);

    }

    private static Node concateList(Node left, Node root) {
        if(left == null) {
            return root;
        }

        if(root == null) {
            return left;
        }

        Node leftTail = left.left;
        Node rightTail = root.left;

        leftTail.right = root;
        root.left = leftTail;
        left.left = rightTail;
        rightTail.right = left;

        return left;

    }

}
