package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class FindMedian {
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right = new Node(70);
        root.right.right = new Node(80);
        root.right.left = new Node(60);

        System.out.println(findMedian(root));
    }

    private static double findMedian(Node root) {
        if(root == null) {
            return -1;
        }

        return findMedian(root, findCount(root));
    }

    private static double findMedian(Node root, int nodeCount) {
        int middleIndex = nodeCount/2;
        double result = 0;
        Node previous = null;
        Node current = root;
        int count=0;

        while(current != null) {
            if(current.left == null) {
                count++;

                if((count-1) == middleIndex) {
                    if(nodeCount % 2 == 0) {
                        result = (previous.data + current.data)/2.0;
                    } else {
                        result = current.data;
                    }
                }
                previous = current;
                current = current.right;
            } else {
                Node prev = current.left;
                while(prev.right != null && prev.right != current) {
                    prev = prev.right;
                }

                if(prev.right == null) {
                    prev.right = current;
                    previous = current;
                    current = current.left;
                } else {
                    prev.right = null;
                    count++;
                    if((count-1) == middleIndex) {
                        if(nodeCount % 2 == 0) {
                            result = (previous.data + current.data)/2.0;
                        } else {
                            result = current.data;
                        }
                    }
                    previous = current;
                    current = current.right;
                }
            }
        }
        return result;

    }

    private static int findCount(Node root) {
        if(root == null) {
            return 0;
        }

        Node current = root;
        int count=0;
        while(current != null) {
            if(current.left == null) {
                count++;
                current = current.right;
            } else {
                Node prev = current.left;
                while(prev.right != null && prev.right != current) {
                    prev = prev.right;
                }

                if(prev.right == null) {
                    prev.right = current;
                    current = current.left;
                } else {
                    prev.right = null;
                    count++;
                    current = current.right;
                }
            }
        }
        return count;
    }


}
