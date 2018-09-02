package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

import java.util.Stack;

public class CountPairs {
    public static void main(String[] args) {
        Node root1 = new Node(5);       /*       5        */
        root1.left = new Node(3); /*           /   \      */
        root1.right = new Node(7); /*         3     7     */
        root1.left.left = new Node(2); /*    / \   / \    */
        root1.left.right = new Node(4); /*  2   4 6   8    */
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);

        // formation of BST 2
        Node root2 = new Node(10);        /*     10         */
        root2.left = new Node(6); /*           /   \        */
        root2.right = new Node(15); /*        6     15      */
        root2.left.left = new Node(3); /*    / \   /  \     */
        root2.left.right = new Node(8); /*  3  8  11  18    */
        root2.right.left = new Node(11);
        root2.right.right = new Node(18);

        int key = 5;

        System.out.println(countPairs(root1, root2, key));
    }

    private static int countPairs(Node root1, Node root2, int key) {
        if(root1 == null || root2 == null) {
            return -1;
        }

        Node current1 = root1, current2 = root2;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        int count = 0;
        while(true) {
            //populate stack1 from tree1
            while(current1 != null) {
                stack1.push(current1);
                current1 = current1.left;
            }

            //populate stack2 from tree2
            while(current2 != null) {
                stack2.push(current2);
                current2 = current2.right;
            }


            if(stack1.isEmpty() || stack2.isEmpty()) {
                break;
            } else {
                Node stack1top = stack1.peek();
                Node stack2top = stack2.peek();

                int sum = stack1top.data + stack2top.data;
                if(sum == key) {
                    current1 = stack1.pop().right;
                    current2 = stack2.pop().left;
                    count++;
                } else if(sum < key) {
                    current1 = stack1.pop().right;
                } else {
                    current2 = stack2.pop().left;
                }
            }
        }

        return count;
    }
}
