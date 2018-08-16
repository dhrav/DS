package BinaryTree.Misc;

public class ColorSkewedTree {
    public static void main(String[] args) {
        int nodeCount = 3;
        int colors = 3;

        double ways = getNumberOfWaysToColor(nodeCount, colors);
        System.out.println(ways);
    }

    private static double getNumberOfWaysToColor(int nodeCount, int colors) {
        return colors * Math.pow((colors-1),(nodeCount-1));
    }
}
