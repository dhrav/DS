package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class KLargestUsingMorris {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        int k=2;
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
            if(current.right == null) {
                count++;
                if(count == k) {
                   result = current.data;
                   break;
                }
                current = current.left;
            } else {
                Node succ = current.right;
                //find the inorder successor and link it to current
                while(succ.left != null && succ.left != current) {
                    succ = succ.left;
                }

                //not visited left subtree yet, so build the link
                if(succ.left == null) {
                    succ.left = current;
                    current = current.right;
                } else {
                    //already visited the left subtree, so remove the built link, consider current node and move to right
                    succ.left = null;
                    count++;
                    if(k==count) {
                        result = current.data;
                        break;
                    }
                    current = current.left;
                }
            }
        }
        return result;
    }
}
