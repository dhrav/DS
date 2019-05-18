package Heap;

public class ConnectRopesWithMinCost {
        int[] ropes;
        int size;
    public static void main(String[] args) {
        int[] ropes = {4,3,2,6};
        ConnectRopesWithMinCost object = new ConnectRopesWithMinCost(ropes);
        System.out.println("\nTotal cost of connecting ropes is : " + object.findCost());

    }

    public ConnectRopesWithMinCost(int[] input) {
        this.ropes = input;
        this.size = input.length;
    }

    private int findCost() {
        int lastNonLeafNode = (size-2)/2;

        //buildHeap
        for(int i = lastNonLeafNode; i>=0; i--) {
            ropes = heapifyDown(i);
        }

        //extractMin and add the combined cost
        //keep track of final cost
        int totalCost = 0;
        int count = 0;

        while(count + 1 < size) {
            int first = extractMin();
            int second = extractMin();
            int currCost = first+ second;
            totalCost += currCost;
            insert(currCost);
        }
        return totalCost;
    }

    private void insert(int value) {
        ropes[size] = value;
        size++;
        heapifyUp(size-1);
    }

    private void heapifyUp(int i) {
        while(hasParent(i) && ropes[getParentIndex(i)] > ropes[i]) {
            int parentIndex = getParentIndex(i);

           //swap parent and i
            int temp = ropes[i];
            ropes[i] = ropes[parentIndex];
            ropes[parentIndex] = temp;

            i = parentIndex;
        }
    }

    private boolean hasParent(int i) {
        int parentIndex = getParentIndex(i);
        return parentIndex >=0 && parentIndex < size;
    }

    private int getParentIndex(int i) {
        return (i-1)/2;
    }


    private int extractMin() {
        int result = ropes[0];
        ropes[0] = ropes[size-1];
        size--;
        heapifyDown(0);
        return result;
    }



    private int[] heapifyDown(int i) {
        while(hasLeftChild(i)) {
            int curVal = ropes[i];
            int minIndex = i;

            int leftChildIndex = getLeftChildIndex(i);
            int leftChildVal = ropes[leftChildIndex];
            if(curVal > leftChildVal) {
                curVal = leftChildVal;
                minIndex = leftChildIndex;
            }

            if(hasRightChild(i)) {
                int rightChildIndex = getRightChildIndex(i);
                int rightChildVal = ropes[rightChildIndex];
                if(curVal > rightChildVal) {
                    minIndex = rightChildIndex;
                }
            }

            if(minIndex == i) {
                break;
            }

            //swap minIndex and i
            int temp = ropes[minIndex];
            ropes[minIndex] = ropes[i];
            ropes[i] = temp;

            i = minIndex;
        }
        return ropes;
    }

    private boolean hasLeftChild(int i) {
        int leftChildIndex = getLeftChildIndex(i);
        return leftChildIndex >=0 && leftChildIndex < size;
    }

    private int getLeftChildIndex(int i) {
        return (2*i)+1;
    }

    private boolean hasRightChild(int i) {
        int rightChildIndex = getRightChildIndex(i);
        return rightChildIndex >=0 && rightChildIndex < size;
    }

    private int getRightChildIndex(int i) {
        return (2*i)+2;
    }

}
