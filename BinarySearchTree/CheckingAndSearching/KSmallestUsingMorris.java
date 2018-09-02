package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class KSmallestUsingMorris {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        int k=5;
        System.out.println(findKthByMorris(root, k));
    }

    private static int findKthByMorris(Node root, int k) {
        if(root == null) {
            return -1;
        }
        int count = 0;
        int result = -1;

        Node current = root;
        while(current != null) {
            if(current.left == null) {
                count++;
                if(count == k) {
                   result = current.data;
                   break;
                }
                current = current.right;
            } else {
                Node prev = current.left;
                //find the inorder predecessor and link it to current
                while(prev.right != null && prev.right != current) {
                    prev = prev.right;
                }

                //not visited left subtree yet, so build the link
                if(prev.right == null) {
                    prev.right = current;
                    current = current.left;
                } else {
                    //already visited the left subtree, so remove the built link, consider current node and move to right
                    prev.right = null;
                    count++;
                    if(k==count) {
                        result = current.data;
                        break;
                    }
                    current = current.right;
                }
            }
        }
        return result;
    }
}
