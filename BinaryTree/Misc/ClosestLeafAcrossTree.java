package BinaryTree.Misc;

public class ClosestLeafAcrossTree {

    static class Result {
        int distance = Integer.MAX_VALUE;
        char closestNodeData = Character.MIN_VALUE;
    }

    static class NearestLeaf {
        int level = Integer.MAX_VALUE;
        char leaf;
    }

    static class Node {
        char data;
        Node left, right;

        public Node(char data) {
            this.data = data;
        }
    }
    public static void main(String[] args) {
        Node root        = new Node('A');
        root.left               = new Node('B');
        root.right              = new Node('C');
        root.right.left        = new Node('E');
        root.right.right       = new Node('F');
        root.right.left.left  = new Node('G');
        root.right.left.left.left  = new Node('I');
        root.right.left.left.right = new Node('J');
        root.right.right.right      = new Node('H');
        root.right.right.right.left = new Node('K');

        findClosest(root, 'H');
        findClosest(root, 'C');
        findClosest(root, 'E');
        findClosest(root, 'B');

    }

    private static void findClosest(Node root, char key) {
        if(root == null) {
            return;
        }

        Result result = new Result();
        Node[] path = new Node[100];
        int index = 0;
        findClosestUtil(root, key, result, path, index);
        System.out.println(result.closestNodeData + " at distance of " + result.distance);
    }



    private static int findClosestUtil(Node root, char key, Result result, Node[] path, int index) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }

        if(root.data == key) {
            //find the closest leaf rooted at this node
            NearestLeaf leaf = new NearestLeaf();
            int distance = findClosestLeaf(root, leaf, 0);
            if(result.distance > distance) {
                result.distance = distance;
                result.closestNodeData = leaf.leaf;
            }

            for(int i = index - 1; i >=0; i--) {
                NearestLeaf ancLeaf = new NearestLeaf();
                int curAncestorDistance = index - i + findClosestLeaf(path[i], ancLeaf, 0);

                if(curAncestorDistance < result.distance) {
                    result.distance = curAncestorDistance;
                    result.closestNodeData =  ancLeaf.leaf;
                }
            }
            return distance;
        }
        path[index++] = root;
        return Math.min(findClosestUtil(root.left, key, result, path, index),
                findClosestUtil(root.right, key, result, path, index));
    }

    private static int findClosestLeaf(Node root, NearestLeaf leaf, int level) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }

        if(root.left == null && root.right == null) {
            if(leaf.level > level) {
                leaf.leaf = root.data;
                leaf.level = level;
            }

            return 0;
        }

        return 1 + Math.min(findClosestLeaf(root.left, leaf, level+ 1), findClosestLeaf(root.right, leaf, level+ 1));
    }
}
