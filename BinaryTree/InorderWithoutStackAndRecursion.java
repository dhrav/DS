package BinaryTree;

public class InorderWithoutStackAndRecursion {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(9);
        root.left.left = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        Node temp = root;
        inorder(temp);
    }

    private static void inorder(Node root) {
        if(root == null) {
            return;
        }

        Node current = root;
        while(current != null) {
            if(current.left == null) {
                System.out.println(current.data);
                current = current.right;
            } else {
                Node temp = current;
                Node leftSubTree = current.left;

                while(leftSubTree.right != null && leftSubTree.right != current) {
                    leftSubTree = leftSubTree.right;
                }

                if(leftSubTree.right != null) {
                    System.out.println(current.data);
                    current = current.right;
                } else {
                    leftSubTree.right = temp;
                    current = temp.left;
                }
            }
        }
    }
}
