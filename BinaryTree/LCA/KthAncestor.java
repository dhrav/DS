package BinaryTree.LCA;

import BinaryTree.Node;

public class KthAncestor {
    static int k;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        k = 3;
        Node result = findKthAncestor(root, 4);
        if(result != null) {
            System.out.println("Not Present");
        }
    }

    private static Node findKthAncestor(Node root, int key) {
        if(root == null) {
            return null;
        }

        if(root.data == key ||
                (findKthAncestor(root.left, key) != null) ||
                (findKthAncestor(root.right, key)) != null) {
            if(k>0) {
                k--;
            } else if(k==0){
                System.out.println(root.data);
                return null;
            }
            return root;
        }
        return root;
    }
}
