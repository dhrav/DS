package BinaryTree.Summation;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class BTWithInorderPreSucSum {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        updateTree(root);
        preorder(root);

    }

    private static void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    private static void updateTree(Node root) {
        if(root == null) {
            return;
        }

        List<Integer> nodeList = new ArrayList<>();
        nodeList.add(0);

        preorder(root, nodeList);

        nodeList.add(0);

        updateTreeUtil(root, nodeList);
    }
    static int index = 1;

    private static void updateTreeUtil(Node root, List<Integer> nodeList) {
        if(root == null) {
            return;
        }

        updateTreeUtil(root.left, nodeList);

        root.data = nodeList.get(index-1) + nodeList.get(index+1);
        index++;

        updateTreeUtil(root.right, nodeList);
    }

    private static void preorder(Node root, List<Integer> nodeList) {
        if(root == null) {
            return;
        }

        preorder(root.left, nodeList);
        nodeList.add(root.data);
        preorder(root.right, nodeList);
    }
}
