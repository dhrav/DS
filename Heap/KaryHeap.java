package Heap;

import java.util.Arrays;

public class KaryHeap {
    int[] elements;
    int capacity;
    int size;
    int k;

    public KaryHeap(int k, int capacity) {
        this.k = k;
        this.capacity = capacity;
        elements = new int[capacity];
    }

    private void ensureCapacity() {
        if(size < capacity) {
            return;
        }

        //increase the array size
        capacity = capacity * 2;
        elements = Arrays.copyOf(elements, capacity);
    }

    private int getParentIndex(int index) {
        return (index-1)/k;
    }

    private boolean hasParent(int index) {
        int parentIndex = getParentIndex(index);
        return isValidIndex(parentIndex);
    }

    private int getNthChildIndex(int index, int n) {
        if(n < 0 || n >= k) {
            return -1;
        }
        return (k*index) + (k-n);
    }

    private boolean hasNthChild(int index, int n) {
        int childIndex = getNthChildIndex(index, n);
        return isValidIndex(childIndex);

    }

    private boolean hasChildren(int index) {
        return hasNthChild(index, k-1);
    }

    private boolean isValidIndex(int index) {
        return index >=0 && index < size;
    }

    public void insert(int value) {
        ensureCapacity();
        elements[size] = value;
        heapifyUp(size);
        size++;
    }

    public int extractMin() {
        int minValue = elements[0];
        elements[0] = elements[size-1];
        size--;
        heapifyDown(0);
        return minValue;
    }

    private void heapifyDown(int index) {

        while(hasChildren(index)) {
            int minVal = elements[index];
            int minIndex = index;

            // find the smallest index and value from the children
            int count = 0;
            while(count < k) {
                if(hasNthChild(index, count)) {
                    int childIndex = getNthChildIndex(index, count);
                    int childValue = elements[childIndex];
                    if(childValue < minVal) {
                        minVal = childValue;
                        minIndex = childIndex;
                    }
                }
                count++;
            }

            if(minIndex == index) {
                break;
            }

            swap(minIndex, index);
            index = minIndex;
        }
    }

    private void swap(int sourceIndex, int destinationIndex) {
        int temp = elements[sourceIndex];
        elements[sourceIndex] = elements[destinationIndex];
        elements[destinationIndex] = temp;
    }

    private void heapifyUp(int index) {
        while(hasParent(index) && elements[getParentIndex(index)] > elements[index]) {
            int parentIndex = getParentIndex(index);
            swap(parentIndex, index);
            index = parentIndex;
        }
    }

    public void decreaseKey(int index, int key) {
        if(!isValidIndex(index)) {
            System.out.println("\nNot a valid index");
            return;
        }

        elements[index] = key;
        heapifyDown(0);
    }

    public void deleteKey(int index) {
        decreaseKey(index, Integer.MIN_VALUE);
        extractMin();
    }

    public int[] getElements() {
        return elements;
    }

    public void printHeap() {
        for(int i = 0; i < size; i++) {
            System.out.println(elements[i]);
        }

        System.out.println("items length : " + size);
    }

    public int getMin() {
        return elements[0];
    }

    public static void main(String[] args) {
        KaryHeap minHeap = new KaryHeap(3, 5);
        minHeap.insert(4);
        minHeap.insert(5);
        minHeap.insert(6);
        minHeap.insert(7);
        minHeap.insert(8);
        minHeap.insert(9);
        minHeap.insert(10);
        minHeap.printHeap();

        System.out.println("\nHeap after inserting 3");
        minHeap.insert(3);
        minHeap.printHeap();

        System.out.println("Deleting Minimum val : " + minHeap.getMin());
        minHeap.extractMin();
        minHeap.printHeap();

        System.out.println("Deleting element at index 1 : ");
        int index = 1;
        minHeap.deleteKey(index);
        minHeap.printHeap();
    }


}
