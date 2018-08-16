package BinaryTree.LCA;

public class FindLCA_ParentPointer_NoExtraSpace {
    static class Node {
        int data;
        Node left;
        Node right;
        Node parent;

        Node(int data) {
            this.data = data;
            left = right = parent = null;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.parent = root;

        root.right = new Node(22);
        root.right.parent = root;

        root.left.left = new Node(4);
        root.left.left.parent = root.left;

        root.left.right = new Node(12);
        root.left.right.parent = root.left;

        root.left.right.left = new Node(10);
        root.left.right.left.parent = root.left.right;

        root.left.right.right = new Node(14);
        root.left.right.right.parent = root.left.right;

        Node lca = findLca(root, root.left.right.left, root.right );

        System.out.println(lca == null? "one/more keys not present" : lca.data);

    }

    private static Node findLca(Node root, Node node1, Node node2) {
        if(root == null) {
            return null;
        }

       /* int node1Level = findLevel(root, node1, 0);
        int node2Level = findLevel(root, node2, 0);*/

        int node1Level = findLevelUsingParentPointer(node1);
        int node2Level = findLevelUsingParentPointer(node2);

        int diff = node1Level - node2Level;
        if(diff < 0) {
            Node temp = node2;
            node2 = node1;
            node1 = temp;
        }
        diff = Math.abs(diff);

        while(diff != 0 && node1 != null) {
            node1 = node1.parent;
            diff--;
        }

        boolean isFound = false;

        while(node1 != null && node2 != null) {
            if(node1 == node2) {
                isFound = true;
                break;
            }

            node1 = node1.parent;
            node2 = node2.parent;
        }

        return isFound ? node1 : null;
    }

    private static int findLevel(Node root, Node node1, int level) {
        if(root == null) {
            return 0;
        }

        if(root.data == node1.data) {
            return level;
        }

        int leftlevel = findLevel(root.left, node1, level++);
        if(leftlevel != 0) {
            return leftlevel;
        }

        return findLevel(root.right, node1, level++);
    }

    private static int findLevelUsingParentPointer(Node node) {
        int level = -1;
        while(node!= null) {
            level++;
            node = node.parent;
        }
        return level;
    }
}
