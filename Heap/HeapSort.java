package Heap;

public class HeapSort {
     int size;
     int[] input;
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] items = {12, 11, 13, 5, 6, 7};
        heapSort.setInput(items);

        System.out.println("\nElements before sort");
        heapSort.displayHeap();
        heapSort.sort();
        System.out.println("\nElements after sort");
        heapSort.displayHeap();
    }

    public void setInput(int[] items) {
        this.input = items;
        this.size = items.length;
    }

    public void sort() {
        int lastNonLeaftIndex = (size - 2)/2;
        for(int i = lastNonLeaftIndex; i >=0; i--) {
            heapifyDown(i);
        }

        int startSize = size-1;
        for(int i = startSize; i >=0; i--) {
            int temp = input[0];
            input[0] = input[i];
            input[i] = temp;
            size--;
            heapifyDown(0);
        }

        //restore the initial size
        size = startSize;

    }

    private void displayHeap() {
        for(int i = 0; i < size; i++) {
            System.out.println(input[i]);
        }
    }
    private boolean hasParentIndex(int index) {
        int parentIndex = getParentIndex(index);
        return isValid(parentIndex);
    }

    private boolean isValid(int index) {
        return index >=0 && index <size;
    }

    private int getParentIndex(int index) {
        return (index -1 )/2;
    }

    private int getLeftChildIndex(int index) {
        return (2*index) + 1;
    }

    private int getRightChildIndex(int index) {
        return (2*index) +2;
    }

    private boolean hasLeftChild(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        return isValid(leftChildIndex);
    }

    private boolean hasRightChild(int index) {
        int rightChildIndex = getRightChildIndex(index);
        return isValid(rightChildIndex);
    }

    private void swap(int sourceIdx, int destinationIdx) {
        int temp = input[sourceIdx];
        input[sourceIdx] = input[destinationIdx];
        input[destinationIdx] = temp;
    }

    private void heapifyDown(int index) {
        while(hasLeftChild(index)) {
            int maxVal = input[index];
            int maxIndex = index;

            if(hasLeftChild(index)) {
                int leftChildIndex = getLeftChildIndex(index);
                int leftChildValue = input[leftChildIndex];
                if(leftChildValue > maxVal) {
                    maxVal = leftChildValue;
                    maxIndex = leftChildIndex;
                }
            }

            if(hasRightChild(index)) {
                int rightChildIndex = getRightChildIndex(index);
                int rightChildValue = input[rightChildIndex];
                if(rightChildValue > maxVal) {
                    maxIndex = rightChildIndex;
                }
            }

            if(maxIndex == index) {
                break;
            }

            swap(index, maxIndex);
            index = maxIndex;
        }

    }
}
