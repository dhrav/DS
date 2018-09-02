package BinarySearchTree.CheckingAndSearching;

import java.util.*;

public class MaximumUniqueElements {
    public static void main(String[] args) {
        int a[] = {1, 2, 2, 3, 3};
        int windowSize = 3;

        printMaxUniqueElement(a, windowSize);
    }

    private static void printMaxUniqueElement(int[] arr, int windowSize) {
        int size = arr.length;

        HashMap<Integer, Integer> elementCountMap = new HashMap<>();
        TreeSet<Integer> uniqueElements = new TreeSet<>();

        for(int i = 0; i < windowSize-1; i++) {
            if(elementCountMap.containsKey(arr[i])) {
                int frequency = elementCountMap.get(arr[i]);
                elementCountMap.put(arr[i], frequency+1);
            } else {
                elementCountMap.put(arr[i], 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : elementCountMap.entrySet()) {
            if(entry.getValue() == 1) {
                uniqueElements.add(entry.getKey());
            }
        }

        for(int i = windowSize-1; i < size; i++) {
            if(elementCountMap.containsKey(arr[i])) {
                int frequency = elementCountMap.get(arr[i]);
                if(frequency == 1) {
                    uniqueElements.remove(arr[i]);
                }
                elementCountMap.put(arr[i], frequency+1);
            } else {
                elementCountMap.put(arr[i], 1);
                uniqueElements.add(arr[i]);
            }

            System.out.println(uniqueElements.last());

            int elementToClearIndex = i - (windowSize-1);
            int frequency = elementCountMap.get(arr[elementToClearIndex]);
            if(frequency == 1) {
                elementCountMap.remove(arr[elementToClearIndex]);
                uniqueElements.remove(arr[elementToClearIndex]);
            } else {
                frequency = frequency-1;
                if(frequency == 1) {
                    uniqueElements.add(arr[elementToClearIndex]);
                }
                elementCountMap.put(arr[elementToClearIndex], frequency);
            }
        }
    }
}
