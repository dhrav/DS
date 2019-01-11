package Heap;

import java.util.Arrays;

public class MinBinaryHeap {
    private int capacity;
    private int[] items;
    private int size;

    public MinBinaryHeap(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
        size = 0;
    }

    public void ensureExtraCapacity() {
        if(size < capacity) {
            return;
        }

        capacity = capacity * 2;
        items = Arrays.copyOf(items, capacity);
    }

    public int getParentIndex(int curIndex) {
        return (curIndex-1)/2;
    }

    public int getLeftChildIndex(int curIndex) {
        return (2*curIndex) + 1;
    }

    public int getRightChildIndex(int curIndex) {
        return (2*curIndex) + 2;
    }

    public boolean hasParent(int curIndex) {
        int parentIndex = getParentIndex(curIndex);
        return parentIndex >= 0;
    }

    public boolean hasLeftChild(int curIndex) {
        int leftChildIndex = getLeftChildIndex(curIndex);
        return leftChildIndex >=0  && leftChildIndex < size;
    }

    public boolean hasRightChild(int curIndex) {
        int rightChildIndex = getRightChildIndex(curIndex);
        return rightChildIndex >= 0 && rightChildIndex < size;
    }

    public void swap(int indexSource, int indexDestination) {
        int temp = items[indexSource];
        items[indexSource] = items[indexDestination];
        items[indexDestination] = temp;
    }


    public void heapifyUp(int curIndex) {
        while(hasParent(curIndex) && items[getParentIndex(curIndex)] > items[curIndex]) {
            int parentIndex = getParentIndex(curIndex);
            swap(parentIndex, curIndex);
            curIndex = parentIndex;
        }
    }

    public void heapifyDown(int curIndex) {
        while(hasLeftChild(curIndex)) {

            int smallerIndex = curIndex;
            if(hasLeftChild(curIndex)) {
                int leftChildValue = items[getLeftChildIndex(curIndex)];
                if(items[smallerIndex] > leftChildValue) {
                    smallerIndex = getLeftChildIndex(curIndex);
                }
            }

            if(hasRightChild(curIndex)) {
                int rightChildValue = items[getRightChildIndex(curIndex)];
                if(items[smallerIndex] > rightChildValue) {
                    smallerIndex = getRightChildIndex(curIndex);
                }
            }

            if(smallerIndex == curIndex) {
                return;
            }

            swap(smallerIndex, curIndex);
            curIndex = smallerIndex;
        }

    }


    public void insert(int key) {
        ensureExtraCapacity();
        items[size] = key;
        heapifyUp(size);
        size++;
    }

    public int extractMin() {
        if(size == 0) {
            throw new IllegalStateException();
        }
        int result = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown(0);
        return result;
    }

    public int[] getItems() {
        return items;
    }

    public int getMin() {
        if(size == 0) {
            throw new IllegalStateException();
        }
        return items[0];
    }

    public void printMinHeap() {
        int[] items = getItems();
        for(int i = 0; i < size; i++) {
            System.out.println(items[i]);
        }

        System.out.println("items length : " + items.length);
    }

    public void deleteKey(int index) {
        decreaseKey(index, Integer.MIN_VALUE);
        extractMin();
    }

    //this will update the value of the key as INT_MIN
    private void decreaseKey(int index, int valueToUpdate) {
        if(index >= size) {
            throw new IllegalArgumentException();
        }

        items[index] = valueToUpdate;
        heapifyDown(0);
    }

    public static void main(String[] args) {
        MinBinaryHeap minHeap = new MinBinaryHeap(5);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(3);
        minHeap.insert(4);
        minHeap.insert(7);
        minHeap.insert(10);
        minHeap.printMinHeap();

        System.out.println("Deleting Minimum val : " + minHeap.getMin());
        minHeap.extractMin();
        minHeap.printMinHeap();

        System.out.println("Deleting element at index 1 : ");
        int index = 1;
        minHeap.deleteKey(index);
        minHeap.printMinHeap();
    }
}
