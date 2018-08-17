package BinaryTree.Misc;



public class ConnectNodesAtSameLevel {
    static class Node {
        int data;
        Node left, right, nextRight;
        public Node(int data) {
            this.data = data;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left        = new Node(8);
        root.right       = new Node(2);
        root.left.left  = new Node(3);
        root.right.right       = new Node(90);

        connect(root);

        // Let us check the values of nextRight pointers
        int a = root.nextRight != null ?
                root.nextRight.data : -1;
        int b = root.left.nextRight != null ?
                root.left.nextRight.data : -1;
        int c = root.right.nextRight != null ?
                root.right.nextRight.data : -1;
        int d = root.left.left.nextRight != null ?
                root.left.left.nextRight.data : -1;
        int e = root.right.right.nextRight != null ?
                root.right.right.nextRight.data : -1;

        // Now lets print the values
        System.out.println("Following are populated nextRight pointers in "
                + " the tree(-1 is printed if there is no nextRight)");
        System.out.println("nextRight of " + root.data + " is " + a);
        System.out.println("nextRight of " + root.left.data
                + " is " + b);
        System.out.println("nextRight of " + root.right.data +
                " is " + c);
        System.out.println("nextRight of " + root.left.left.data +
                " is " + d);
        System.out.println("nextRight of " + root.right.right.data +
                " is " + e);
    }

    private static void connect(Node root) {
        if(root == null){
            return;
        }

        Node current = root;
        current.nextRight = null;

        Node element;

        while(current != null) {
            element = current;

            while(element != null) {
                if(element.left != null) {
                    if(element.right != null) {
                        element.left.nextRight = element.right;
                    } else {
                        element.left.nextRight = getNextRight(element);
                    }
                }

                if(element.right != null) {
                    element.right.nextRight = getNextRight(element);
                }

                element = element.nextRight;
            }

            if(current.left != null) {
                current = current.left;
            } else if(current.right != null) {
                current = current.right;
            } else {
                current = getNextRight(current);
            }
        }
    }

    private static Node getNextRight(Node element) {
        Node temp =element.nextRight;
        while(temp!= null) {
            if(temp.left != null) {
                return temp.left;
            } else if(temp.right != null) {
                return temp.right;
            } else {
                temp = temp.nextRight;
            }

        }
        return null;
    }
}
