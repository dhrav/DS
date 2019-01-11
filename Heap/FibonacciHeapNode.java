package Heap;

public class FibonacciHeapNode {
    int data;
    int degree;
    boolean isMarked;
    FibonacciHeapNode parent, siblingRight, child, siblingLeft;

    public FibonacciHeapNode(int data) {
        this.data = data;
        degree = 0;
        isMarked = false;
        parent = null;
        //because in fibonacci heap, the root level nodes are in CLL form
        siblingLeft = this;
        siblingRight = this;
        child  = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked(boolean marked) {
        isMarked = marked;
    }

    public FibonacciHeapNode getParent() {
        return parent;
    }

    public void setParent(FibonacciHeapNode parent) {
        this.parent = parent;
    }

    public FibonacciHeapNode getSiblingRight() {
        return siblingRight;
    }

    public void setSiblingRight(FibonacciHeapNode siblingRight) {
        this.siblingRight = siblingRight;
    }

    public FibonacciHeapNode getSiblingLeft() {
        return siblingLeft;
    }

    public void setSiblingLeft(FibonacciHeapNode siblingLeft) {
        this.siblingLeft = siblingLeft;
    }

    public FibonacciHeapNode getChild() {
        return child;
    }

    public void setChild(FibonacciHeapNode child) {
        this.child = child;
    }

}
