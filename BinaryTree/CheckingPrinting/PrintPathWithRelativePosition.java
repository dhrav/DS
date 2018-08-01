package BinaryTree.CheckingPrinting;


public class PrintPathWithRelativePosition {
    static class Node {
        char data;
        Node left, right;
        Node(char c) {
            this.data = c;
            left = null;
            right = null;
        }
    }

   static class PathNode {
        int horizontalDistance;
        char key;
    }

    public static void main(String[] args) {
        Node root = new Node('A');
        root.left = new Node('B');
        root.right = new Node('C');
        root.left.left = new Node('D');
        root.left.right = new Node('E');
        root.right.left = new Node('F');
        root.right.right = new Node('G');

        printPath(root);
    }

    private static void printPath(Node root) {
        if(root == null) {
            return;
        }

        printPathUtil(root, new PathNode[100], 0, 0);
    }

    private static void printPathUtil(Node root, PathNode[] path, int index, int horizontalDistance) {
        if(root == null) {
            return;
        }
        PathNode pathNode = new PathNode();
        pathNode.key = root.data;
        pathNode.horizontalDistance = horizontalDistance;

        path[index++] = pathNode;
        if(root.left == null && root.right == null) {
            int minHorizontalDistance = Integer.MAX_VALUE;
            for(int i = 0; i< index; i++) {
                if(path[i].horizontalDistance < minHorizontalDistance) {
                    minHorizontalDistance = path[i].horizontalDistance;
                }
            }
            for(int i = 0; i < index; i++) {
                // form the underscore string
                int count = Math.abs(path[i].horizontalDistance - minHorizontalDistance);
                StringBuilder underscore = new StringBuilder();
                for(int j = 0; j < count; j++) {
                    underscore.append("_");
                    underscore.append(" ");
                }
                System.out.println(underscore.toString()+ path[i].key);
            }
            System.out.println("========================================");
        } else {
            printPathUtil(root.left, path, index, horizontalDistance-1);
            printPathUtil(root.right, path, index, horizontalDistance+1);
        }
    }
}
