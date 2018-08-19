package BinaryTree.Misc;

import BinaryTree.Node;

public class FactorTree {
    public static void main(String[] args) {
        Node root = buildFactorTree(48);
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

    private static Node buildFactorTree( int number) {
       Node root = new Node(number);

        //run a loop for divisor
        //by rule, it can be only of 2 to half of the original number
        for(int i = 2; i < number/2 ; i++) {
            if(number % i != 0) {
                continue;
            }

            //quotient
            root.left = buildFactorTree( number/i);
            //divisor
            root.right = buildFactorTree( i);

            //end the loop for minimum divisor
            //if not the loop will continue for other divisors too
            //say if a number is divisible by both 2 & 3
            //we need to divide only be 2 and skip the rest
            return root;
        }
        return root;
    }
}
