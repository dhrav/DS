package BinaryTree.Misc;

public class CountFullBTSubTreeFromArray {
    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 6};
        System.out.println(countFullBTWithNodeAsProductOfChildren(arr));
    }

    private static int countFullBTWithNodeAsProductOfChildren(int[] arr) {
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        int size = arr.length;
        //find the min and max value in input array
        for(int i= 0; i<size;i++) {
            if(arr[i] < minValue) {
                minValue = arr[i];
            }

            if(arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        int mark[] = new int[maxValue+2];
        int value[] = new int[maxValue+2];

        //mark all input as 1
        for(int i=0; i<size; i++) {
            mark[arr[i]] = 1;
            value[arr[i]] = 1;
        }

        int ans = 0;

        for(int i= minValue; i <= maxValue; i++) {
            if(mark[i] == 0) {
                continue;
            }
            //loop for the i's multiple
            for(int j = i + i; j <= maxValue && (j/i) <= i; j++) {

                if(mark[j] == 0) {
                    continue;
                }

                value[j] = value[j] + (value[j/i] * value[i]);

                if(i != (j/i)) {
                    value[j] = value[j] + (value[j/i] * value[i]);
                }
            }
            ans += value[i];
        }
        return ans;
    }
}
