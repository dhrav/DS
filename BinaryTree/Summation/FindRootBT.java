package BinaryTree.Summation;



public class FindRootBT {
    public static void main(String[] args) {
        Pair[] input = new Pair[6];
        input[0] = new Pair(1,5);
        input[1] = new Pair(2,0);
        input[2] = new Pair(3,0);
        input[3] = new Pair(4,0);
        input[4] = new Pair(5,5);
        input[5] = new Pair(6,5);

        findRoot(input, 6);

    }

    private static void findRoot(Pair[] input, int size) {
        int root =0;
        for(int i=0; i < size; i++) {
            root +=  input[i].first - input[i].second;
        }
        System.out.println(root);
    }
}

class Pair {
    int first;
    int second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
