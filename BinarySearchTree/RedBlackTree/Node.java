package BinarySearchTree.RedBlackTree;

public class Node {
   private int data;
    private Colour colour; // R- RED, B - BLACK
    private Node left, right;
    private Node parent;
    private boolean isNullLeaf;
    public Node () {}
    public Node(int data, Colour colour) {
        this.data = data;
        this.colour = colour;
        left = null;
        right = null;
        parent = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public boolean isColour(Colour colour) {
        return this.colour == colour;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void swapColour() {
        if(this.colour == Colour.RED) {
            this.colour = Colour.BLACK;
        } else {
            this.colour = Colour.RED;
        }
    }

    public boolean isNullLeaf() {
        return isNullLeaf;
    }

    public void setNullLeaf(boolean nullLeaf) {
        isNullLeaf = nullLeaf;
    }
}

