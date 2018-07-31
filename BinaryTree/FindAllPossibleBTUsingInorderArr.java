package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class FindAllPossibleBTUsingInorderArr {
    public static void main(String[] args) {
        int inorder[] = {4, 5, 7}; //output is catalan number format so if n=3, output = 5 trees
        FindAllPossibleBTUsingInorderArr object = new FindAllPossibleBTUsingInorderArr();
        List<Node> trees = object.getPossibleTrees(inorder, 0, inorder.length-1);

        for(Node root : trees) {
            System.out.println("*************");
            object.preOrder(root);
        }
    }

    public List<Node> getPossibleTrees(int[] inorder, int low, int high) {
        List<Node> result = new ArrayList<>();

        if(low > high) {
            result.add(null);
            return result;
        }

        for(int i = low; i <= high; i++) {
            List<Node> leftSubTreeList = getPossibleTrees(inorder, low, i -1);
            List<Node> rightSubTreeList = getPossibleTrees(inorder, i+1, high);


            for(int j = 0; j < leftSubTreeList.size(); j++) {
                for(int k =0; k < rightSubTreeList.size(); k++) {
                    Node root = new Node(inorder[i]);
                    root.left = leftSubTreeList.get(j);
                    root.right = rightSubTreeList.get(k);

                    result.add(root);
                }
            }

        }
        return result;
    }

    public void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }


}
