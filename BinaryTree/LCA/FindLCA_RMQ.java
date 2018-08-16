package BinaryTree.LCA;

import BinaryTree.Node;

public class FindLCA_RMQ {
    static int totalNodeCount = 7;
    static int[] euler, level, firstOccurence;
    static int eulerTourDistance;
    static Node root;

    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        eulerTourDistance = (2 * totalNodeCount) - 1;
        euler = new int[eulerTourDistance];
        level = new int[eulerTourDistance];
        firstOccurence = new int[totalNodeCount];

        //assuming both keys are present in tree
        findLca(4,5);
    }

    private static void findLca(int key1, int key2) {
        preprocess();

        //Using segment tree for RMQ
        rangeMinQuery(key1, key2);
    }

    private static void rangeMinQuery(int key1, int key2) {

        if(key1 > 0 && key1 < totalNodeCount && key2 > 0 && key2 <totalNodeCount) {

            int[] segmentTree = SegmentTreeForRMQ.createSegmentTree(level);
            int qlow = firstOccurence[key1-1];
            int qhigh = firstOccurence[key2-1];
            int minElement = SegmentTreeForRMQ.rangeMinQuery(segmentTree, qlow, qhigh, 0, level.length-1, 0 );
            System.out.println("LCA is " + euler[minElement]);
        }


    }

    private static void preprocess() {
       populateEulerWalk(root, 0, 0);

       //Euler Walk + levels
       for(int i=0; i < eulerTourDistance; i++) {
           System.out.println(euler[i] + " --- " + level[i]);
       }

       buildFirstOccurenceArray();
    }

    private static void buildFirstOccurenceArray() {
        //populate with default values
        for(int i = 0; i< totalNodeCount; i++) {
            firstOccurence[i] = -1;
        }

        //loop through the euler tour and update the index if visited for first time
        for(int i =0; i < eulerTourDistance; i++) {
            if(firstOccurence[euler[i]-1] == -1) {
                firstOccurence[euler[i]-1] = i;
            }
        }

        //first occurence array
        for(int i=0; i < totalNodeCount; i++) {
            System.out.println("Element " + (i+1) + " --- " + firstOccurence[i]);
        }
    }

    private static int populateEulerWalk(Node root, int currentLevel, int index) {
        if(root == null) {
            return 0;
        }

        euler[index] = root.data;
        level[index] = currentLevel;
        if(root.left != null) {
           index = populateEulerWalk(root.left, currentLevel+1, index+1);
        }
        euler[index] = root.data;
        level[index] = currentLevel;
        if(root.right != null) {
            index = populateEulerWalk(root.right, currentLevel+1, index+1);
        }
        euler[index] = root.data;
        level[index] = currentLevel;
        return index+1;
    }
}
