package BinaryTree;

public class BoundaryTraversal {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);
        Node temp = root;
        printBoundary(temp);
    }

    private static void printBoundary(Node temp) {
        if(temp == null) {
            return;
        }
        System.out.println(temp.data);

        printBoundaryLeft(temp.left);
        printLeaves(temp);
        printBoundaryRight(temp.right);
    }

    private static void printBoundaryRight(Node root) {
        if(root != null) {
            if(root.right != null) {
                printBoundaryRight(root.right);
                System.out.println(root.data);
            } else if(root.left != null) {
                printBoundaryRight(root.left);
                System.out.println(root.data);
            }
            //dont do anything in leaves
        }
    }

    private static void printLeaves(Node root) {
        if(root == null) {
            return;
        }

        printLeaves(root.left);
        if(root.left == null && root.right == null) {
            System.out.println(root.data);
        }
        printLeaves(root.right);
    }

    private static void printBoundaryLeft(Node root) {
        if(root != null) {
            if(root.left != null) {
                System.out.println(root.data);
                printBoundaryLeft(root.left);
            } else if(root.right != null) {
                System.out.println(root.data);
                printBoundaryLeft(root.right);
            }
            //dont do anything for leaves
        }
    }

}
