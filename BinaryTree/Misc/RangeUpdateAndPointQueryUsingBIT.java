package BinaryTree.Misc;

public class RangeUpdateAndPointQueryUsingBIT {
    static int[] binaryIndexTree;
    public static void main(String[] args) {
        int size = 5;
        int[] input = new int[size];
        RangeUpdateAndPointQueryUsingBIT object = new RangeUpdateAndPointQueryUsingBIT();
        binaryIndexTree = new int[input.length + 1];

        //updateBIT(3, 1);
        updateRangeInBIT(3, 1, 3);
        System.out.println(getSum(1));
        System.out.println(getSum(2));
        System.out.println(getSum(3));
        System.out.println(getSum(4));
        System.out.println(getSum(0));
    }

    private static void updateRangeInBIT(int value, int startIndex, int endIndex) {
        updateBIT(value, startIndex);
        updateBIT(-value, endIndex+ 1);
    }

    private static int getSum(int index) {
        int bitIndex = index + 1;
        int sum = 0;
        while(bitIndex > 0) {
            sum += binaryIndexTree[bitIndex];
            bitIndex = bitIndex - (bitIndex & -bitIndex); // to go to parent
        }
        return sum;

    }

    private static int[] updateBIT(int value, int index) {
        int bitIndex = index + 1; //to eliminate dummy index
        int validIndex = binaryIndexTree.length;
        while(bitIndex < validIndex) {
            binaryIndexTree[bitIndex] += value;
            bitIndex = bitIndex + (bitIndex & -bitIndex); //next element
        }
        return binaryIndexTree;
    }
}
