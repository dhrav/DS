package BinaryTree.Summation;

public class SumOfNodeAtKthLevel {
    public static void main(String[] args) {
        String tree = "(0(5(8()())(4()(9()())))(7(1()())(3()())))";
        int k = 2;
        System.out.println(findSum(tree, k));
    }

    private static int findSum(String tree, int k) {
        int result = 0;
        int level = -1;
        int inputLength = tree.length();
        for(int i =0; i < inputLength; i++) {
            char c = tree.charAt(i);
            switch(c) {
                case '(':
                    level++;
                    break;
                case ')':
                    level--;
                    break;
                default:
                    if(level == k) {
                        result += c - '0';
                    }
                    break;
            }
        }
        return result;
    }
}
