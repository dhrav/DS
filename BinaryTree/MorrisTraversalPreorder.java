package BinaryTree;

public class MorrisTraversalPreorder {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(9);
        root.left.left = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        Node temp = root;
        preorder(temp);
    }

    private static void preorder(Node temp) {
        if(temp == null) {
            return;
        }

        Node current = temp;
        while(current != null) {
            if(current.left == null) {
                System.out.println(current.data);
                current = current.right;
            } else {
                //find predecessor
                Node predecessor = current.left;
                while(predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if(predecessor.right == null) {
                    System.out.println(current.data);
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
    }
}
