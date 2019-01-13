package Heap;

public class CheckArrayIsBinaryHeap {
    public static void main(String[] args) {
        int[] input = {90, 15, 10, 7, 12, 2};
        CheckArrayIsBinaryHeap object = new CheckArrayIsBinaryHeap();
        System.out.println("\nThe given array is binary heap or not : " + object.isBinaryHeap(input));
    }

    /*Check whether the given array represents a max heap or not*/
    private Boolean isBinaryHeap(int[] input) {
        int size = input.length;

        for(int i= 0; i < size; i++) {
            int curVal = input[i];
            int leftChildIndex = 2*i + 1;
            int rightChildIndex = 2*i + 2;

            if(leftChildIndex >= 0 && leftChildIndex < size) {
                int leftChildVal = input[leftChildIndex];
                if(curVal < leftChildVal) {
                    return false;
                }
            }

            if(rightChildIndex >=0 && rightChildIndex < size) {
                int rightChildVal = input[rightChildIndex];
                if(curVal < rightChildVal) {
                    return false;
                }
            }

        }
        return true;
    }


}
