package Heap;

import java.util.Stack;

public class LeftistHeap {
    LeftistNode root;
    public void insert(int key) {
        LeftistNode newNode = new LeftistNode(key);
        merge(root, newNode);
    }

    private void merge(LeftistNode root1, LeftistNode root2) {
        if(root1 == null) {
            root = root2;
            return;
        }

        Stack<LeftistNode> stack = new Stack<>();
        while(root1 != null && root2 != null) {
            if(root1.getData() < root2.getData()) {
                stack.push(root1);
                root1 = root.getRight();
            } else {
                stack.push(root2);
                root2 = root2.getRight();
            }
        }
        LeftistNode temp = null;
        if(root1 == null) {
            temp = root2;
        } else {
            temp = root1;
        }

        while(!stack.isEmpty()) {
            LeftistNode top = stack.pop();
            top.setRight(temp);
            if(!top.isLeftist()) {
                top.swapChildTrees();
                top.updateDistance();
            }
            temp = top;
        }
        root = temp;
    }

    public void displayLeftistTree() {
        System.out.println("\nInorder traversal of leftist tree");
        displayTree(root);
    }

    private void displayTree(LeftistNode root) {
        if(root == null) {
            return;
        }
        displayTree(root.getLeft());
        System.out.println(root.getData());
        displayTree(root.getRight());
    }

    public int findMinimum() {
        return root == null ? -1 : root.getData();
    }

    public void extractMin() {
        LeftistNode leftTree = root.getLeft();
        LeftistNode rightTree = root.getRight();

        root = null;
        merge(leftTree, rightTree);
    }
}


