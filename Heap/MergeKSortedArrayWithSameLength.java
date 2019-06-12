package Heap;

public class MergeKSortedArrayWithSameLength {
    public static void main(String[] args) {
        MergeKSortedArrayWithSameLength object = new MergeKSortedArrayWithSameLength();
        int[][] arr = {{1,3,4,55},
                {11,13,14,15},
                {21,23,24,25}};
        int[] result = object.mergeSortedArrays(arr);
        object.printArray(result);
    }

    private int[] mergeSortedArrays(int[][] arr) {
        int rowLength = arr.length;
        int columnLength = arr[0].length;
        MinHeap minHeap = new MinHeap(rowLength);
        for(int arrIndex = 0; arrIndex < rowLength; arrIndex++) {
                minHeap.insert(arr[arrIndex][0], arrIndex, 1);
        }

        int totalElements = rowLength * columnLength;
        int[] result = new int[totalElements];
        int index= 0;
        while(index < totalElements) {
            MinHeapNode extractedNode = minHeap.extractMin();
            result[index++] = extractedNode.data;
            int toInsertRow = extractedNode.i;
            int toInsertColumn = extractedNode.j;
            if(toInsertRow < rowLength && toInsertColumn < columnLength) {
                minHeap.insert(arr[toInsertRow][toInsertColumn], toInsertRow, toInsertColumn + 1);
            }
        }
        return result;

    }

    private void printArray(int[] array) {
        int length = array.length;
        for(int i = 0; i< length; i++) {
            System.out.println(array[i]);
        }
    }

    class MinHeapNode {
        int data;
        int i; // which array it refers to
        int j; // which element in the array is next to be used

        public MinHeapNode(int data, int i, int j) {
            this.data = data;
            this.i = i;
            this.j = j;
        }
    }

    class MinHeap {
        int size;
        int capacity;
        MinHeapNode[] array;

        public MinHeap(int capacity) {
            this.capacity = capacity;
            array = new MinHeapNode[capacity];
        }

        public void insert(int data, int arrayIndex, int nextElement) {
            if(size == capacity) {
                System.out.println("Heap is full");
                return;
            }

            MinHeapNode newNode = new MinHeapNode(data, arrayIndex, nextElement);
            array[size] = newNode;
            heapifyUp(size);
            size++;
        }

        public MinHeapNode extractMin() {
            MinHeapNode resultNode = array[0];
            array[0] = array[size-1];
            size--;
            heapifyDown(0);
            return resultNode;
        }

        private void heapifyDown(int index) {
            int minIndex = index;

            int leftChildIndex = getLeftChildIndex(index);
            if(isValidIndex(leftChildIndex) && array[leftChildIndex].data < array[minIndex].data) {
                minIndex = leftChildIndex;
            }

            int rightChildIndex = getRightChildIndex(index);
            if(isValidIndex(rightChildIndex) && array[rightChildIndex].data < array[minIndex].data) {
                minIndex = rightChildIndex;
            }

            if(minIndex == index) {
                return;
            }

            swap(minIndex, index);
            heapifyDown(minIndex);
        }

        private int getRightChildIndex(int index) {
            return (2* index) + 2;
        }

        private int getLeftChildIndex(int index) {
            return (2* index) + 1;
        }

        private void heapifyUp(int index) {
            while(index >= 0 && isValidIndex(getParentIndex(index)) && array[getParentIndex(index)].data > array[index].data) {
                int parentIndex = getParentIndex(index);
                swap(parentIndex, index);
                index = parentIndex;
            }
        }

        private int getParentIndex(int index) {
            return (index-1)/2;
        }

        private boolean isValidIndex(int index) {
            return index >= 0 && index < size;
        }

        private void swap(int index1, int index2) {
            MinHeapNode temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }
    }
}

