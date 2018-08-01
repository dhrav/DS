package BinaryTree.CheckingPrinting;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintCousins {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(15);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        printCousins(root, root.left.right);
    }

    private static void printCousins(Node root, Node key) {
        if(root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean isKeyFound = false;
        int keyLevel = 0;
        int currentLevel = 0;
        List<Integer> cousinList = new ArrayList<>();

        while(!queue.isEmpty()) {
            Node element = queue.remove();
            if(element == null) {
                currentLevel++;
                if(isKeyFound && currentLevel > keyLevel) {
                    for(int i : cousinList) {
                        System.out.println(i);
                    }
                    return;
                }

                if(isKeyFound) {
                    keyLevel = currentLevel;
                }
                if(queue.size() > 1) {
                    queue.add(null);
                }
            } else {

                if(element.left != null) {
                    if(!isKeyFound && element.left.data == key.data) {
                        isKeyFound= true;
                    } else if(isKeyFound) {
                        cousinList.add(element.left.data);
                    }

                }
                queue.add(element.left);

                if(element.right != null) {
                    if(!isKeyFound && element.right.data == key.data) {
                        isKeyFound= true;
                    }else if(isKeyFound) {
                        cousinList.add(element.right.data);
                    }
                }
                queue.add(element.right);
            }
        }
    }

}