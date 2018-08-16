package BinaryTree.LCA;

import BinaryTree.NextPowerOf2;

public class SegmentTreeForRMQ {
    public static void main(String[] args) {
        int[] input = {0,3,4,2,1,6,-1};
        int[] segmentTree = createSegmentTree(input);
        System.out.println(rangeMinQuery(segmentTree, 1, 6,0, input.length-1, 0));
    }

    public static int[] createSegmentTree(int[] input) {
        NextPowerOf2 nextPowerOf2 = new NextPowerOf2();
        int size = nextPowerOf2.getNextPowerOf2(input.length);

        int segmentTree[] = new int[(2*size)-1];
        createSegmentTreeUtil(input, segmentTree, 0, input.length-1, 0);
        return segmentTree;
    }

    private static void createSegmentTreeUtil(int[] input, int[] segmentTree, int low, int high, int position) {
        if(low == high) {
            segmentTree[position] = input[low];
            return;
        }

        int mid = (low + high)/2;
        createSegmentTreeUtil(input, segmentTree, low, mid, (2*position)+1);
        createSegmentTreeUtil(input, segmentTree, mid+1, high, (2*position)+2);

        segmentTree[position] = Math.min(segmentTree[(2*position) + 1], segmentTree[(2*position) + 2]);
    }


    public static int rangeMinQuery(int[] segmentTree, int qlow, int qhigh, int low, int high, int position) {
        //no overlap
        if(qlow >= high || qhigh <=low) {
            return Integer.MAX_VALUE;
        }

        //total overlap
        if(qlow <= low && qhigh >= high) {
            return segmentTree[position];
        }

        //partial overlap
        int mid = (low + high)/2;
        return Math.min(rangeMinQuery(segmentTree, qlow, qhigh, low, mid, (2*position)+1),
                rangeMinQuery(segmentTree, qlow, qhigh, mid+1, high, (2*position)+2));

    }
}
