package BinarySearchTree.Misc;

public class SingleReservationSystem {
    static class Node {
        int time;
        Node left, right;
        public Node(int data) {
            this.time = data;
            this.left = this.right = null;
        }
    }
    public static void main(String[] args) {
        //each job takes k units of time
        int kUnits = 4;
        Node root = null;
        root = insert(root, 2, 4);
        System.out.println("After request 2");
        inorder(root);
        root = insert(root, 7, 4);
        System.out.println("After request 7");
        inorder(root);
        root = insert(root, 3, 4);
        System.out.println("After request 3");
        inorder(root);
        root = insert(root, 15, 4);
        System.out.println("After request 15");
        inorder(root);
        root = insert(root, 20, 4);
        System.out.println("After request 20");
        inorder(root);
    }

    private static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.time);
        inorder(root.right);
    }

    private static Node insert(Node root, int futureJobTime, int kUnits) {
        if(root == null) {//no job exists
            return new Node(futureJobTime);
        }

        //check whether it is conflicting
        if(((futureJobTime-kUnits) < root.time) && ((futureJobTime+kUnits) > root.time)) {
            return root;
        }

        if(futureJobTime < root.time) {
            root.left = insert(root.left, futureJobTime, kUnits);
        } else if(futureJobTime > root.time) {
            root.right = insert(root.right, futureJobTime, kUnits);
        }

        return root;
    }
}
