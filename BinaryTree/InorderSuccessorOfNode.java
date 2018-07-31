package BinaryTree;

public class InorderSuccessorOfNode {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        // Case 1
        inorderSuccesor(root, root.right);

        // case 2
        inorderSuccesor(root, root.left.left);

        // case 3
        inorderSuccesor(root, root.right.right);
    }

    private static void inorderSuccesor(Node root, Node key) {
        if(key.right != null) {
            Node inorderSucc = leftMostNode(key.right);
            System.out.println("Inorder successor of " + key.data + " is " + inorderSucc.data);
            return;
        } else {
            Node rightNode = rightMostNode(root);
            if(rightNode == key) {
                System.out.println("RightMost Node , No inorder successor");
            }
            else {
                findInorderSuccRecursive(root, key);
            }
        }

    }

    private static Node findInorderSuccRecursive(Node root, Node key) {
        if(root == null || root == key) {
            return root;
        }

        Node leftTreeNode = findInorderSuccRecursive(root.left, key);
        Node rightTreeNode = findInorderSuccRecursive(root.right, key);

        if(leftTreeNode != null || rightTreeNode != null) {
            if(root.left == leftTreeNode || root.left == rightTreeNode) {
                System.out.println("Inorder successor of " + key.data + " is " + root.data);
                //return null;
            }
        }
        return null;
    }



    private static Node rightMostNode(Node temp) {
        while(temp != null && temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    private static Node leftMostNode(Node temp) {
        while(temp!= null && temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }
}
