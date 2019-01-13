package Heap;

import java.util.ArrayList;
import java.util.List;

public class SecondSmallestInArray {
    public static void main(String[] args) {
        int[] input = {61, 6, 11, 19, 100, 12, 17};
        SecondSmallestInArray object = new SecondSmallestInArray();
        object.printArray(input);
        System.out.println("The second smallest element in the array is:" + object.findSecondMin(input));
    }

    private void printArray(int[] input) {
        for(int i : input) {
            System.out.println(i);
        }
    }

    private int findSecondMin(int[] input) {
        int size = input.length;
        Node newNode, root;
        List<Node> minNodeList = new ArrayList<>();
        for(int i = 0; i < size; i+=2) {
            newNode = new Node(input[i]);

            if(i+1 < size) {
                Node secondNode = new Node(input[i+1]);
                int rootValue;
                if(newNode.getData() < secondNode.getData()) {
                    rootValue = newNode.getData();
                } else {
                   rootValue = secondNode.getData();
                }
                root = new Node(rootValue);
                root.setLeft(newNode);
                root.setRight(secondNode);
            } else {
                root = new Node(newNode.getData());
                root.setLeft(newNode);
                root.setRight(null);
            }

            minNodeList.add(root);
        }

        //We found the first level winners from the list of players
        //From this we might need to construct the tournament tree
        int winnerSize = minNodeList.size();
        int counter = 0;
        while(counter + 1 < winnerSize) {
            Node first = minNodeList.get(counter++);
            Node second = minNodeList.get(counter++);

            int rootVal = first.getData() < second.getData() ? first.getData(): second.getData();
            root = new Node(rootVal);
            root.setLeft(first);
            root.setRight(second);
            minNodeList.add(root);


            if(counter == winnerSize) {
                int curNodeSize = minNodeList.size();

                if((curNodeSize-winnerSize) == 1) {
                    break;
                } else {
                    winnerSize = curNodeSize;
                }
            }
        }

        Result result = new Result(Integer.MAX_VALUE);
        int lastIndex = minNodeList.size()-1;
        traverseTree(minNodeList.get(lastIndex), result);
        return result.data;

    }

    private void traverseTree(Node node, Result result) {
        if(node == null || (node.getLeft() == null && node.getRight() == null)) {
            return;
        }

        if(node.getLeft() != null) {
            if(node.getData() < node.getLeft().getData()) {
                int leftData = node.getLeft().getData();
                if(leftData < result.data) {
                    result.data = leftData;
                }
                traverseTree(node.getRight(), result);
            }
        }

        if(node.getRight() != null) {
            if(node.getData() < node.getRight().getData()) {
                int rightData = node.getRight().getData();
                if(rightData < result.data) {
                    result.data = rightData;
                }
                traverseTree(node.getLeft(), result);
            }
        }
    }
}

class Result {
    int data;

    public Result(int data) {
        this.data = data;
    }
}

class Node {
    private int data;
    private Node left, right;

    public Node(int data) {
        this.data = data;
        left= null;
        right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
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
}
