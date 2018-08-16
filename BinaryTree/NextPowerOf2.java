package BinaryTree;

public class NextPowerOf2 {
    public static void main(String[] args) {
        NextPowerOf2 object = new NextPowerOf2();
        System.out.println(object.getNextPowerOf2(4));
    }

    public int getNextPowerOf2(int n) {
        if(n == 0 || ((n & (n-1)) == 0 )) {
            return n;
        }

        int p = 1;
        while(p < n) {
            p <<= 1;
        }

        return p;
    }
}
