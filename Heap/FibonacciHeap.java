package Heap;

import java.util.HashMap;
import java.util.Map;

public class FibonacciHeap {

    FibonacciHeapNode min = null;
    int heapSize;

    public void insert(int data) {
        FibonacciHeapNode newNode = new FibonacciHeapNode(data);
        if(min == null) {
            min = newNode;
            return;
        } else {
            FibonacciHeapNode leftNode = min.getSiblingLeft();
            min.setSiblingLeft(newNode);
            newNode.setSiblingRight(min);
            newNode.setSiblingLeft(leftNode);
            leftNode.setSiblingRight(newNode);
        }

        //update min pointer if required
        if(min.getData() > newNode.getData()) {
            min = newNode;
        }
        heapSize++;
    }

    public void displayHeap(FibonacciHeapNode root) {
        if(root != null) {

            do {
                //print the self node
                System.out.println(root.getData());
                if(root.getChild() != null) {
                    displayHeap(root.getChild());
                }

                root = root.getSiblingRight();

            }while(root != null && root != min && root.getSiblingRight() != root);

        } else {
            System.out.println("\n The heap is empty.");
        }
    }

    public void displayHeap() {
        if(min == null) {
            return;
        }

        displayHeap(min);
    }

    public void union(FibonacciHeap newHeap) {
        FibonacciHeap curr = this;

        //combine both the CDLL around min pointer
        FibonacciHeapNode minRight = curr.min.getSiblingRight();
        FibonacciHeapNode newHeapLeft = newHeap.min.getSiblingLeft();

        FibonacciHeapNode temp = newHeapLeft;
        newHeap.min.setSiblingLeft(minRight);
        temp.setSiblingRight(curr.min);
        curr.min.setSiblingLeft(temp);
        newHeap.min.getSiblingLeft().setSiblingRight(newHeap.min);

        updateMin(min);
    }

    public void updateMin(FibonacciHeapNode start) {
        int minValue = Integer.MAX_VALUE;
        FibonacciHeapNode tempMin = null;
        while(start != null && start.getSiblingRight() != start) {
            if(start.getData() < minValue) {
                minValue = start.getData();
                tempMin = start;
            }
            start = start.getSiblingRight();
        }
        min = tempMin;
    }

    public int findMinimum() {
        return (min == null) ? -1 : min.getData();
    }

    public int extractMin() {
        if(min == null) {
            return -1;
        }

        //extract all children and add to root list
        FibonacciHeapNode curr = min.getChild();
        FibonacciHeapNode minNode = min;
        while(curr != null) {
            FibonacciHeapNode next = curr.getSiblingRight();
            curr.setParent(null);
            if(min.getSiblingLeft() != null) {
                min.getSiblingLeft().setSiblingRight(curr);
                curr.setSiblingLeft(min.getSiblingLeft());
                min.setSiblingLeft(curr);
            }
            curr.setSiblingRight(min);
            //update min if necessary
            if(curr.getData() < min.getData()) {
                min = curr;
            }
            curr = next;
        }

        //remove min from root list
        if(minNode.getSiblingLeft() != null) {
            minNode.getSiblingLeft().setSiblingRight(minNode.getSiblingRight());
        }

        if(minNode.getSiblingRight() != null) {
            minNode.getSiblingRight().setSiblingLeft(minNode.getSiblingLeft());
        }

        FibonacciHeapNode temp = minNode.getSiblingRight();
        FibonacciHeapNode currNode = minNode.getSiblingRight();

        minNode.setSiblingLeft(minNode);
        minNode.setSiblingRight(minNode);

        //update min
        int minVal = Integer.MAX_VALUE;
        do {
            if(currNode.getData() < minVal) {
                min = currNode;
                minVal = currNode.getData();
            }
            currNode = currNode.getSiblingRight();

        }while(currNode != temp);



        //check if its not a one node case
        if(min != min.getSiblingRight()) {
            consolidate();
        }

        heapSize--;
        return minNode.getData();
    }

    private void consolidate() {
        //int arrSize = (int)Math.log(heapSize)/(int)Math.log10(2);
        //FibonacciHeapNode[] degree = new FibonacciHeapNode[arrSize];
        Map<Integer, FibonacciHeapNode> degreeMap = new HashMap<>();
       /* for(int i = 0; i < arrSize; i++) {
            degree[i] = null;
        }*/

        FibonacciHeapNode temp = min;
        FibonacciHeapNode curr = temp;
        FibonacciHeapNode ptr, ptr1;
        int nodeDegree;
        do {
            ptr = curr;
            nodeDegree = ptr.getDegree();
            // while(degree[nodeDegree] != null) {
            while(degreeMap.containsKey(nodeDegree)) {
                // ptr1 = degree[nodeDegree];
                ptr1 = degreeMap.get(nodeDegree);

                //now we have ptr and ptr1 with same degree
                // so we check the data and make the node with bigger data as child of smaller one


                //step1: always keep ptr as smaller node
                if(ptr.getData() > ptr1.getData()) {
                    FibonacciHeapNode t = ptr;
                    ptr = ptr1;
                    ptr1 = t;

                    //update min if required
                    if(ptr1 == min) {
                        ptr = min;
                    }
                }

                //step 2: merge two nodes by making one as child of another
                makeLink(ptr, ptr1);
                //make the entry as empty and proceed further
                //degree[nodeDegree] = null;
                degreeMap.remove(nodeDegree);
                nodeDegree = ptr.getDegree();
            }
            // degree[nodeDegree] = curr;
            degreeMap.put(ptr.getDegree(), ptr);
            ptr = ptr.getSiblingRight();
            curr = ptr;

        }while(ptr != temp);

        //create root list and update min
        min = null;
        //for(int i = 0; i < arrSize; i++) {
        for(int i = 0; i < degreeMap.size(); i++) {
            //FibonacciHeapNode currentNode = degree[nodeDegree];
            FibonacciHeapNode currentNode = degreeMap.get(nodeDegree);
            currentNode.setSiblingRight(currentNode);
            currentNode.setSiblingLeft(currentNode);

            //already some nodes exist in the created root list, so attach this to the list
            if(min != null) {
                //attach before min
                if(min.getSiblingLeft() != null) {
                    min.getSiblingLeft().setSiblingRight(currentNode);
                }
                currentNode.setSiblingRight(min);
                currentNode.setSiblingLeft(min.getSiblingLeft());
                min.setSiblingLeft(currentNode);

                if(currentNode.getData() < min.getData()) {
                    min = currentNode;
                }
            } else { // newly created list is empty
                min = currentNode;
            }
        }

    }

    private void makeLink(FibonacciHeapNode root, FibonacciHeapNode childToBe) {
        //extract childToBe from rootList
        if(childToBe.getSiblingLeft() != null) {
            childToBe.getSiblingLeft().setSiblingRight(childToBe.getSiblingRight());
        }

        if(childToBe.getSiblingRight() != null) {
            childToBe.getSiblingRight().setSiblingLeft(childToBe.getSiblingLeft());
        }

        childToBe.setParent(root);
        if(root.getChild() == null) {
            root.setChild(childToBe);
            childToBe.setSiblingRight(childToBe);
            childToBe.setSiblingLeft(childToBe);
        } else {
            FibonacciHeapNode currentChild = root.getChild();
            currentChild.setSiblingLeft(childToBe);
            childToBe.setSiblingRight(currentChild);
        }
        //update the degree of parent
        root.setDegree(root.getDegree() + 1);
    }

    public void decreaseKey(int curVal, int newVal) {
        //find the node with curVal
        FibonacciHeapNode curValNode = findNode(curVal);

        if(curValNode == null) {
            System.out.println("\nThe node with value " + curVal + " is not present");
            return;
        }

        curValNode.setData(newVal);

        FibonacciHeapNode curNodeParent = curValNode.getParent();
        if(curNodeParent != null && curNodeParent.getData() > newVal) {
            //means the min heap property is violated
            cut(curValNode);
        } else if(curNodeParent == null) {
            if(newVal < min.getData()) {
                min = curValNode;
            }
        }
    }

    private void cut(FibonacciHeapNode node) {
        FibonacciHeapNode parent = node.getParent();

        //handle the case for only node
        if(node.getSiblingRight() == node) {
            parent.setChild(null);
        } else {
            node.getSiblingRight().setSiblingLeft(node.getSiblingLeft());
            node.getSiblingLeft().setSiblingRight(node.getSiblingRight());
        }

        //update parent pointer if found node is the first child in the list
        if(parent.getChild() == node) {
            parent.setChild(node.getSiblingRight());
        }
        parent.setDegree(parent.getDegree()-1);

        node.setParent(null);
        node.setSiblingLeft(min.getSiblingLeft());
        node.setSiblingRight(min);
        min.setSiblingLeft(node);
        if(min.getSiblingRight() == min) {
            min.setSiblingRight(node);
        }
        if(node.getData() < min.getData()) {
            min = node;
        }
        if(parent.isMarked) {
            cut(parent);
        } else {
            parent.setMarked(true);
        }
    }

    private FibonacciHeapNode findNode(int key) {
        return findNode(min, key);
    }

    private FibonacciHeapNode findNode(FibonacciHeapNode curr, int key) {
        FibonacciHeapNode nodeToFind;
        do {
            if(curr == null || curr.getData() == key) {
                return curr;
            }

            nodeToFind = findNode(curr.getChild(), key);
            if(nodeToFind != null) {
                return nodeToFind;
            }
            curr = curr.getSiblingRight();
        }while(curr != min);
        return nodeToFind;
    }

    public void delete(int key) {
        decreaseKey(key, Integer.MIN_VALUE);
        extractMin();
    }

}
