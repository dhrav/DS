package BinaryTree;

import java.util.*;

public class LevelOrderReverseAlternate {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        Node temp = root;
        levelOrder(temp);
        inorder(temp);
    }

    private static void inorder(Node temp) {
        if(temp == null) {
            return;
        }

        inorder(temp.left);
        System.out.println(temp.data);
        inorder(temp.right);
    }

    private static void levelOrder(Node temp) {
        if(temp == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(temp);
        queue.add(null);
        List<Node> levelNodeList = new ArrayList();
        List<Integer> levelDataList = new ArrayList();
        boolean isReverse = false;

        while(!queue.isEmpty()) {
            Node element = queue.remove();
            if(element == null) {
               if(isReverse) {
                   Collections.reverse(levelDataList);
                   for(int i=0; i< levelDataList.size(); i++) {
                       levelNodeList.get(i).data = levelDataList.get(i);
                   }
               }

               isReverse = !isReverse;
               if(queue.size() > 1) {
                   queue.add(null);
               }
                levelDataList.clear();
                levelNodeList.clear();
            } else {
                levelDataList.add(element.data);
                levelNodeList.add(element);
                if(element.left != null) {
                    queue.add(element.left);
                }

                if(element.right != null) {
                    queue.add(element.right);
                }

            }
        }
    }
}
