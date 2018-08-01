package BinaryTree.CheckingPrinting;

import BinaryTree.Node;

public class PrintDiameterNodes {
    class DiameterNode {
        Node root;
        int leftHeight;
        int rightHeight;
        int result;
    }

    int flag = 0;

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        root.left.left.right = new Node(8);
        root.left.left.right.left = new Node(9);
        PrintDiameterNodes object = new PrintDiameterNodes();

        object.printDiameter(root);
    }

    private void printDiameter(Node root) {
        if(root == null) {
            return;
        }
        DiameterNode result = new DiameterNode();

        heightWithDiameterNode(root, result);
        printPathForDiameter(result.root.left, result.leftHeight, new int[100], 0);
        System.out.print(result.root.data + " ");
        flag = 1;
        printPathForDiameter(result.root.right, result.rightHeight, new int[100], 0);
    }

    private void printPathForDiameter(Node root, int height, int[] path, int index) {
        if(root == null) {
            return;
        }

        path[index++] = root.data;
        if(root.left == null && root.right == null) {
            if(index == height && (flag == 0 || flag == 1)) {
                if(flag == 1) {
                    for (int i = 0; i < index; i++) {
                        System.out.print(path[i] + " ");
                    }
                } else if (flag == 0) {
                    for (int i = index-1; i >=0; i--) {
                        System.out.print(path[i] + " ");
                    }
                }
                flag = 2;
                return;
            }
        }

        printPathForDiameter(root.left, height, path, index);
        printPathForDiameter(root.right, height, path, index);
    }

    private int heightWithDiameterNode(Node root, DiameterNode diameterNode) {
        if(root == null) {
            return 0;
        }

        int leftHeight = heightWithDiameterNode(root.left, diameterNode);
        int rightHeight = heightWithDiameterNode(root.right, diameterNode);

        int currentHeight = 1 + leftHeight + rightHeight;

        //save diameter info
        if(diameterNode.result < currentHeight) {
            diameterNode.result = currentHeight;
            diameterNode.leftHeight = leftHeight;
            diameterNode.rightHeight = rightHeight;
            diameterNode.root = root;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
