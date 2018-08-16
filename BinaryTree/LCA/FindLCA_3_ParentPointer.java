package BinaryTree.LCA;

import java.util.ArrayList;
import java.util.List;

public class FindLCA_3_ParentPointer {
    static class Node {
        int data;
        Node left;
        Node right;
        Node parent;

        Node(int data) {
            this.data = data;
            left = right = parent = null;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.parent = root;

        root.right = new Node(22);
        root.right.parent = root;

        root.left.left = new Node(4);
        root.left.left.parent = root.left;

        root.left.right = new Node(12);
        root.left.right.parent = root.left;

        root.left.right.left = new Node(10);
        root.left.right.left.parent = root.left.right;

        root.left.right.right = new Node(14);
        root.left.right.right.parent = root.left.right;

        Node lca = findLca(root, root.left.right.left, root.left );

        System.out.println(lca == null? "one/more keys not present" : lca.data);

    }

    private static Node findLca(Node root, Node n1, Node n2) {

        if(root == null) {
            return null;
        }

        //store all the ancestor of node1
        List<Integer> ancestor = new ArrayList<>();

        Node current = n1;

        while(current != null) {
            ancestor.add(current.data);
            current = current.parent;
        }

        boolean isFound = false;

        //check whether if n2 or its ancestors appear in node1 ancestor list
        while(n2 != null) {
            if(ancestor.contains(n2.data)) {
                isFound = true;
                break;
            }
            n2 = n2.parent;
        }

        return isFound ? n2 : null;
    }
}
