package BinaryTree.CheckingPrinting;

import BinaryTree.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IterativePrintPath {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);

        printPath(root, new HashMap<>());
    }

    private static void printPath(Node root, Map<Node, Node> parentMap) {
        //iterative preorder
        if(root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        parentMap.put(root, null);

        while(!stack.isEmpty()) {
            Node element = stack.pop();

            if(element.left == null && element.right ==  null) {
                printPathUtil(element, parentMap);
            }

          //  System.out.println(element.data);

            if(element.right != null) {
                stack.push(element.right);
                parentMap.put(element.right, element);
            }

            if(element.left != null) {
                stack.push(element.left);
                parentMap.put(element.left, element);
            }
        }
    }

    private static void printPathUtil(Node element, Map<Node,Node> parentMap) {
        Stack<Integer> stack = new Stack<>();

        while(element != null) {
            stack.push(element.data);
            element = parentMap.get(element);
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
