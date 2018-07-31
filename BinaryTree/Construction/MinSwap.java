package BinaryTree.Construction;

import java.util.Arrays;

class Element implements Comparable<Element>{
    int value;
    int index;
    Element(int v, int i) {
        value = v;
        index = i;
    }


    @Override
    public int compareTo(Element o) {
        return this.value - o.value;
    }
}

public class MinSwap {
    public static void main(String[] args) {
        int[] arr = {1,5,4,3,2};
        System.out.println(findMinSwap(arr));
    }

    private static int findMinSwap(int[] arr) {
        int size = arr.length;
        Element[] elementArr = new Element[size];
        for(int i = 0; i < size; i++) {
            elementArr[i] = new Element(arr[i], i);
        }

        Arrays.sort(elementArr);

        boolean[] visited = new boolean[size];
        int result = 0;

        for(int i =0; i< size; i++) {
            if(visited[i] || elementArr[i].index == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;
            while(!visited[j]) {
                visited[j] = true;
                j = elementArr[j].index;
                cycleSize++;
            }

            result+=(cycleSize-1);
        }
        return result;
    }
}
