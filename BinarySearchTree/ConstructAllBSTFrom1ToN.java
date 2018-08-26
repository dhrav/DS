package BinarySearchTree;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class ConstructAllBSTFrom1ToN {
    public static void main(String[] args) {
        List<Node> treeList = constructAllBST(1,3);
        System.out.println("Number of possible binary search trees are : " + treeList.size());

        for(Node root : treeList) {
            System.out.println("Preorder of tree is : ");
            preorder(root);
            System.out.println();
        }
    }

    private static List<Node> constructAllBST(int low, int high) {
         List<Node> treeList = new ArrayList<>();

         if(low > high) {
            treeList.add(null);
            return treeList;
        }

        for(int i = low; i <= high; i++) {
            List<Node> leftTreeList = constructAllBST(low, i-1);
            List<Node> rightTreeList = constructAllBST(i + 1, high);

            for(int j = 0; j < leftTreeList.size(); j++) {
                for(int k =  0; k < rightTreeList.size(); k++) {
                    Node root = new Node(i);
                    root.left = leftTreeList.get(j);
                    root.right = rightTreeList.get(k);

                    treeList.add(root);
                }
            }
        }

        return treeList;
    }

    private static void preorder(Node root) {
        if(root== null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
}
