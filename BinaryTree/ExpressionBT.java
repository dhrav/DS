package BinaryTree;

import java.util.Stack;

public class ExpressionBT {

    static class ExpNode{
        String data;
        ExpNode left, right;

        public ExpNode(String c) {
            data = c;
            left = null;
            right = null;
        }
    }

    String postfixExp;
    ExpNode root;

    public ExpressionBT(String exp) {
        postfixExp = exp;
    }


    public boolean isOperator(String c) {
        return c.equals("+")  || c.equals("-") || c.equals("*") || c.equals("/") || c.equals("^");
    }

    public void buildExpression(){
        String input[] = postfixExp.split(" ");
        Stack<ExpNode> stack = new Stack<>();
        int size = input.length;
        for(int i = 0; i < size; i++) {
            if(!isOperator(input[i])) {
                stack.push(new ExpNode(input[i]));
            }
            else {
                ExpNode opr = new ExpNode(input[i]);

                opr.right = stack.pop();
                opr.left = stack.pop();

                stack.push(opr);
            }
        }
        root = stack.pop();

    }

    public int evaluateExpression(ExpNode root) {
        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) {
            return Integer.parseInt(root.data);
        }

        int leftSum = evaluateExpression(root.left);
        int rightSum = evaluateExpression(root.right);
        int result = 0;
        if(isOperator(root.data))
        {
            switch(root.data)
            {
                case "+":
                    result = leftSum + rightSum;
                    break;
                case "-":
                    result =  leftSum - rightSum;
                    break;
                case "*":
                    result =  leftSum * rightSum;
                    break;
                case "/":
                    result =  leftSum / rightSum;
                    break;
                case "^":
                    result =  leftSum ^ rightSum;
                    break;

            }
        }
        return result;
    }

    public void inorder(ExpNode root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }
    public static void main(String[] args) {
        String postfix = "5 4 * 100 20 - +";
        ExpressionBT expObject = new ExpressionBT(postfix);
        expObject.buildExpression();
        expObject.inorder(expObject.root);
        System.out.println();
        System.out.println(expObject.evaluateExpression(expObject.root));

    }
}
