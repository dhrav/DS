package BinaryTree.Misc;

import BinaryTree.Node;

public class GetMirror {
    public static void main(String[] args) {
        Node root           = new Node(1);
        root. left                 = new Node(2);
        root.left.left            = new Node(4);
        root.left.left.right     = new Node(7);
        root.right                 = new Node(3);
        root.right.left           = new Node(5);
        root.right.right          = new Node(6);
        root.right.left.left     = new Node(8);
        root.right.left.right    = new Node(9);

        //int target = root.left.left.data;
        int target = root.left.data;

        System.out.println(findMirror(root, target));
    }

    private static int findMirror(Node root, int target) {
        if(root == null) {
            return 0;
        }

        if(root.data == target) {
            return target;
        }

        return findMirrorNode(root.left, root.right, target);
    }

    private static int findMirrorNode(Node left, Node right, int target) {
        if(left == null || right == null) {
            return 0;
        }

        if(left.data == target) {
            return right.data;
        }

        if(right.data == target) {
            return left.data;
        }

        //find for external /one branch
        int mirrorValue = findMirrorNode(left.left, right.right, target);

        //if not found, recur for internal nodes
        if(mirrorValue == 0 ) {
            mirrorValue = findMirrorNode(left.right, right.left, target);
        }

        return mirrorValue;
    }
}
