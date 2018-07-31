package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class DensityBT {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(9);
        root.left.left = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        Node temp = root;
        System.out.println("Density of tree :" + density(temp));
    }

    private static float density(Node root) {
        if(root == null) {
            return -1;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        float height = 0, size = 0;

        while(!queue.isEmpty()) {
            Node element = queue.remove();

            if(element == null) {
                height++;
                if(queue.size() >= 1) {
                    queue.add(null);
                }
            } else {
                size++;
                if(element.left != null) {
                    queue.add(element.left);
                }

                if(element.right != null) {
                    queue.add(element.right);
                }
            }
        }
        System.out.println("Size of tree :" + size);
        System.out.println("Height of tree :" + height);
        return size/height;
    }
}
