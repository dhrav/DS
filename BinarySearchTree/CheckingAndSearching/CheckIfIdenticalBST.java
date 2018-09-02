package BinarySearchTree.CheckingAndSearching;

public class CheckIfIdenticalBST {
    public static void main(String[] args) {
        int a[] = {2, 4, 1, 3};
        int b[] = {2, 4, 13, 1};

        System.out.println(checkIfIdentical(a,b));
    }

    private static boolean checkIfIdentical(int[] a, int[] b) {
        int aIndex = 0;
        int bIndex = 0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int size  = a.length;

        if(size != b.length) {
            return false;
        }

        return checkIdenticalUtil(a, b, aIndex, bIndex, min, max, size);
    }

    private static boolean checkIdenticalUtil(int[] a, int[] b, int aIndex, int bIndex, int min, int max, int size) {
        int j, k;
        //find the first element which lies between the min and max
        for(j = aIndex; j < size; j++) {
            if(a[j] > min && a[j] < max) {
                break;
            }
        }

        for(k = bIndex; k < size; k++) {
            if(b[k] > min && b[k] < max) {
                break;
            }
        }

        //check if both reached the end of array
        if(j== size && k == size) {
            return true;
        }


        //check if either of them reached end of array or the first element match found in both array is not same
        if( (j == size || k == size) || (a[j] != b[k])) {
            return false;
        }

        //recur for both left and right subtree
        //change the min and max accordingly

        return checkIdenticalUtil(a, b, j, k, min, a[j], size) &&
                checkIdenticalUtil(a, b, j, k, a[j], max, size);
    }
}
