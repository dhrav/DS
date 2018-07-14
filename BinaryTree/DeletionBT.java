package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class DeletionBT {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(9);
        root.left.left = new Node(7);
        root.left.right = new Node(12);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        Node temp = root;
        System.out.println("Inorder before deletion");
        inorder(temp);

        temp = root;
        deleteFromTree(temp, 11);
        System.out.println("Final output");

        inorder(root);
    }

    private static Node deleteFromTree(Node root, int deleteVal) {
        Node temp = root;

        if(root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);

        Node element = null, nodeToDelete = null;

        while(!queue.isEmpty()) {
            element = queue.remove();

            if(element.data == deleteVal) {
                nodeToDelete = element;
            }


            if(element.left != null) {
                queue.add(element.left);
            }

            if(element.right != null) {
                queue.add(element.right);
            }

        }
        if(nodeToDelete != null) {
            int replacementVal = element.data;
           root= deleteDeepest(root, element);
            nodeToDelete.data = replacementVal;

        }
        else
        {
            System.out.println("Delete key is not present");
        }
        return root;
    }

    private static Node deleteDeepest(Node root, Node delNode) {
        if(root == null)
        {
           return root;
        }
        Node temp = root, element = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);

        while(!queue.isEmpty())
        {
           element = queue.remove();
           if(element.data == delNode.data) {
               return null;
           }

           if(element.left != null)
           {
               if(element.left.data == delNode.data) {
                   element.left = null;
                   return root;
               }
               else
               {
                   queue.add(element.left);
               }
           }

           if(element.right != null) {
               if(element.right.data == delNode.data) {
                   element.right = null;
                   return root;
               }
               else {
                   queue.add(element.right);
               }
           }
        }
        return root;
    }


    private static void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
}
