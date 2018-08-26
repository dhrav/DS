package BinaryTree.Misc;

public class FindRightSibling {
    static class Node {
        int data;
        Node left, right, parent;
        public Node(int data, Node parent) {
            this.data = data;
            this.parent = parent;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1, null);
        root.left = new Node(2, root);
        root.right = new Node(3, root);
        root.left.left = new Node(4, root.left);
        root.left.right = new Node(6, root.left);
        root.left.left.left = new Node(7, root.left.left);
        root.left.left.left.left = new Node(10, root.left.left.left);
        root.left.right.right = new Node(9, root.left.right);
        root.right.right = new Node(5, root.right);
        root.right.right.right = new Node(8, root.right.right);
        root.left.right.right.right = new Node(12, root.left.right.right);


        Node res = findRightSibling(root.left.left.left.left, 0);
        if(res == null) {
            System.out.println("No right sibling present");
        } else {
            System.out.println("The Right sibling is " + res.data);
        }
    }

    private static Node findRightSibling(Node startNode, int level) {
        if(startNode == null || startNode.parent == null) {
            return null;
        }

        while(startNode.parent.right == startNode || (startNode.parent.right == null && startNode.parent.left == startNode)) {
            startNode = startNode.parent;
            level--;
            if(startNode.parent == null) {
                return null;
            }
        }

        startNode = startNode.parent.right;

        while(level < 0) {
            if(startNode.left != null) {
                startNode = startNode.left;
            } else if(startNode.right != null) {
                startNode = startNode.right;
            } else {
                return null;
            }
            level++;
        }

        if(level == 0) {
            return startNode;
        }

        return null;
    }
}
