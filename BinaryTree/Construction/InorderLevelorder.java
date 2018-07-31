package BinaryTree.Construction;

public class InorderLevelorder {
    public static void main(String[] args) {
        //int[] inorder = {7, 11, 10, 15, 9, 8};
        // int[] level = {10, 11, 9, 7, 15, 8};

        int[] inorder = {4, 8, 10, 12, 14, 20, 22};
        int[] level = {20, 8, 22, 4, 12, 10, 14};
        InorderLevelorder object = new InorderLevelorder();

        Node root = object.buildTree(inorder, level, 0, level.length-1, null);
        object.inorder(root);
    }

    private Node buildTree(int[] inorder, int[] level, int low, int high, Node startNode) {
        if(low > high) {
            return null;
        } else if(low == high) {
            startNode = new Node(inorder[low]);
            return startNode;
        }

        int index =0;
        int data;
        boolean found = false;
        for(int i = 0; i < level.length -1; i++) {
            data = level[i];
            for(int j = low; j <=high; j++) {
                if(inorder[j] == data) {
                    startNode = new Node(data);
                    index = j;
                    found = true;
                    break;
                }
            }
            if(found) {
                break;
            }
        }

        if(found) {
            startNode.left = buildTree(inorder, level, low, index-1, startNode.left);
            startNode.right = buildTree(inorder, level, index+1, high, startNode.right);
        }

        return startNode;

    }

    private void inorder(Node root) {
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
}
