package BinaryTree;

public class DepthFromPreorderString {
    public static void main(String[] args) {
        //String preorderStr = "nlnll";
        //String preorderStr = "nlnll";
        String preorderStr = "nlnnlll";
        System.out.println(findDepth(preorderStr.toCharArray(), 0));
    }

    private static int findDepth(char[] preorder, int index) {

        if(index >= preorder.length || preorder[index] == 'l') {
            return 0;
        }

        index++;
        int left = findDepth(preorder, index);

        index++;
        int right = findDepth(preorder, index);

        return Math.max(left, right) + 1;


    }
}
