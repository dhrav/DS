package Heap;

public class SortAlmostSortedArray {
    public static void main(String[] args) {
        int[] input = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;

        /*
        * The above array is k sorted- means every element is atmost k distance from its destination
        * index. There are three methods to solve
        * Method1: Use any sorting algorithm like Quick Sort, Merge Sort : O(nlogn)
        * Method2: Use Insertion Sort algorithm because the inner loop will run for k times as it is
        * k sorted array : O(nk)
        * Method3: Use MinHeap method to build a heap of k+1 elements. extract Min to fill the array and insert new elements
        * from array at the same time
        * */

        SortAlmostSortedArray object = new SortAlmostSortedArray();

        //METHOD : 2
        System.out.println("\nArray before sorting");
        object.printArray(input);
        int[] result = object.sortByInsertionSort(input);
        System.out.println("\nArray after sorting by insertion sort");
        object.printArray(result);

        //METHOD : 3
        System.out.println("\nArray before sorting by minHeap");
        int[] input1 = {10, 9, 8, 7, 4, 70, 60, 50};
        object.printArray(input1);
        result = object.sortByMinHeap(input1, k);
        System.out.println("\nArray after sorting by min heap method");
        object.printArray(result);
    }

    private int[] sortByMinHeap(int[] input, int k) {
        int inputSize = input.length;
        int[] result = new int[inputSize];
        int resultIndex = 0;

        //build Min Heap of k+1 elements
        int size = k + 1;
        int lastLeafNode = (size - 2) / 2;
        for (int i = lastLeafNode; i >= 0; i--) {
            heapifyDown(input, size, i);
        }

        int count = 1;
        while((size + count) <= inputSize) {
            result[resultIndex++] = input[0];
            input[0] = input[(size+count)-1];
            heapifyDown(input, size, 0);
            count++;
        }

        while(resultIndex < inputSize && size !=0) {
            result[resultIndex++] = extractMin(input, size);
            size--;
        }

        return result;
    }

    private int extractMin(int[] input, int size) {
        if(size <= 1) {
            return input[0];
        }


        int result = input[0];
        input[0] = input[size-1];
        size--;
        heapifyDown(input, size, 0);
        return result;
    }

    private void heapifyDown(int[] input, int size, int index) {
        while(hasLeftChild(size, index)) {
            int minValue = input[index];
            int minIndex = index;

            int leftChildIndex = getLeftChildIndex(index);
            int leftChildValue = input[leftChildIndex];

            if(leftChildValue < minValue) {
                minValue = leftChildValue;
                minIndex = leftChildIndex;
            }

            if(hasRightChild(size, index)) {
                int rightChildIndex = getRightChildIndex(index);
                int rightChildValue = input[rightChildIndex];

                if(rightChildValue < minValue) {
                    minIndex = rightChildIndex;
                    minValue = rightChildValue;
                }
            }

            if(minIndex ==index) {
                return;
            }

            //swap two elements
            int temp = input[index];
            input[index] = input[minIndex];
            input[minIndex] = temp;

            index = minIndex;
        }
    }

    private boolean hasRightChild(int size, int index) {
        int rightChildIndex = getRightChildIndex(index);
        return isValid(size, rightChildIndex);
    }

    private int getRightChildIndex(int index) {
        return (2*index) + 2;
    }

    private boolean hasLeftChild(int size, int index) {
        int leftChildIndex = getLeftChildIndex(index);
        return isValid(size, leftChildIndex);
    }

    private boolean isValid(int size, int index) {
        return index >=0 && index < size;
    }

    private int getLeftChildIndex(int index) {
        return (2*index) + 1;
    }

    private void printArray(int[] result) {
        System.out.println("\nThe array contents are:");
        for(int i : result) {
            System.out.println(i);
        }
    }

    private int[] sortByInsertionSort(int[] input) {
        int size = input.length;
        for(int i = 0; i <size; i++) {
            for(int j=i; j>0; j--) {
                if(input[j] < input[j-1]) {
                    int temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                } else {
                    break;
                }
            }
        }
        return input;

    }
}
