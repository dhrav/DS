package BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class InorderNth {
    static int count = 0;
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(9);
        root.left.left = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        Node temp = root;
        inorder(temp, 3);
    }

    private static void inorder(Node temp, int nth) {
        if(temp == null) {
            return;
        }


        inorder(temp.left, nth);
        count++;
        if(count == nth) {
            System.out.println(temp.data);
        }
        inorder(temp.right, nth);

    }
}
