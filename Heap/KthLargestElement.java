package Heap;

public class KthLargestElement {
    int[] elements;
    int size;
    public static void main(String[] args) {
        int[] input = {7, 10, 4, 3, 20, 15};
        int k = 4;

        KthLargestElement object = new KthLargestElement();

        if(k>= input.length) {
            System.out.println("Not a valid number for k");
        } else {
            int result = object.findKthLargestByHeapSort(input, k);
            System.out.println("\nThe " + k +" largest element  by heap sort method is:" + result);

            //build a max heap and do extractMin
            result = object.findKthLargestByMaxHeapMethod(input, k);
            System.out.println("\nThe " + k +" largest element  by max heap and extract max method is:" + result);
        }

    }

    private int findKthLargestByMaxHeapMethod(int[] input, int k) {
        buildMaxHeap(input, k);
        int count = 1;
        while(count < k) {
            extractMax();
            count++;
        }
        return getMax();
    }

    private int getMax() {
        return elements[0];
    }

    private int extractMax() {
        int result = elements[0];
        elements[0] = elements[size-1];
        size--;
        heapifyDownForMaxHeap(0);
        return result;
    }

    private void buildMaxHeap(int[] input, int k) {
        elements = input;
        size = input.length;
        int lastNonLeafNode = (size-2)/2;

        for(int i= lastNonLeafNode; i>=0; i--) {
            heapifyDownForMaxHeap(i);
        }
    }

    private void heapifyDownForMaxHeap(int index) {
        if(hasLeftChild(index)) {
            int maxVal = elements[index];
            int maxIndex = index;

            int leftChildIndex = getLeftChildIndex(index);
            int leftChildValue = elements[leftChildIndex];

            if(maxVal < leftChildValue) {
                maxVal = leftChildValue;
                maxIndex = leftChildIndex;
            }

            if(hasRightChild(index)) {
                int rightChildIndex = getRightChildIndex(index);
                int rightChildValue = elements[rightChildIndex];

                if(maxVal < rightChildValue) {
                    maxIndex = rightChildIndex;
                }
            }

            if(maxIndex == index) {
                return;
            }

            swap(index, maxIndex);
            heapifyDownForMaxHeap(maxIndex);
        }
    }

    private int findKthLargestByHeapSort(int[] input, int k) {
        //Method 1: Sort and return k-1 element in the sorted array
        elements = input;
        size = input.length;

        //using heap sort method to sort the elements in the descending order
        buildMinHeap(input);

        //sort the array by copying the root element to the end of the array
        int startSize = size;
        for(int i= startSize-1; i >=0; i--) {
            int temp = elements[0];
            elements[0] = elements[i];
            elements[i] = temp;
            size--;
            heapifyDown(0);
        }

        size = startSize;

        //Now the array is sorted in descending order
        //kth largest element is at index k-1 in array
        return elements[k-1];
    }

    private void buildMinHeap(int[] input) {
        int size = input.length;
        int lastLeafNode = (size-2)/2;

        for(int i = lastLeafNode; i >=0;i--) {
            heapifyDown(i);
        }
    }

    private void heapifyDown(int index) {
        while(hasLeftChild(index)) {

            int minIndex = index;
            int minVal = elements[index];

            if(hasLeftChild(index)) {
                int leftChildIndex = getLeftChildIndex(index);
                int leftChildValue = elements[leftChildIndex];
                if(leftChildValue <  minVal) {
                    minVal = leftChildValue;
                    minIndex = leftChildIndex;
                }
            }

            if(hasRightChild(index)) {
                int rightChildIndex = getRightChildIndex(index);
                int rightChildValue = elements[rightChildIndex];
                if(rightChildValue < minVal) {
                    minIndex = rightChildIndex;
                }
            }

            if(minIndex ==index) {
                break;
            }
            swap(index, minIndex);
            index = minIndex;
        }
    }



    private void swap(int sourceIndex, int destinationIndex) {
        int temp = elements[sourceIndex];
        elements[sourceIndex] = elements[destinationIndex];
        elements[destinationIndex] = temp;
    }

    private boolean hasLeftChild(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        return isValid(leftChildIndex);
    }

    private int getLeftChildIndex(int index) {
        return (2*index) + 1;
    }

    private boolean hasRightChild(int index) {
        int rightChildIndex = getRightChildIndex(index);
        return isValid(rightChildIndex);
    }

    private int getRightChildIndex(int index) {
        return (2*index) + 2;
    }

    private boolean isValid(int index) {
        return index >=0 && index < size;
    }
}
