package Heap;

public class LeftistNode {
    int data;
    int distance;
    LeftistNode left, right;
    public LeftistNode(int data) {
        this.data = data;
        left = null;
        right = null;
        distance = 0;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public LeftistNode getLeft() {
        return left;
    }

    public void setLeft(LeftistNode left) {
        this.left = left;
    }

    public LeftistNode getRight() {
        return right;
    }

    public void setRight(LeftistNode right) {
        this.right = right;
    }

    public void updateDistance() {
        LeftistNode curr = this;
        this.distance = updateDistance(curr);
    }

    private int updateDistance(LeftistNode curr) {
        if(curr == null) {
            return 0;
        } else {
            return 1 + updateDistance(curr.getRight());
        }
    }

    public boolean isLeftist() {
        LeftistNode curr = this;

        if(curr.getLeft() == null && curr.getRight() != null) {
            return false;
        }
        int leftDistance = curr.getLeft() == null ? 0 : curr.getLeft().getDistance();
        int rightDistance = curr.getRight() == null ? 0 : curr.getRight().getDistance();
        return leftDistance >= rightDistance;
    }

    public void swapChildTrees() {
        LeftistNode curr = this;
        LeftistNode leftTree = curr.getLeft();
        LeftistNode rightTree = curr.getRight();
        curr.setLeft(rightTree);
        curr.setRight(leftTree);
    }
}
