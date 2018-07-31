package BinaryTree.Construction;

public class LevelOrderArr {
    public static void main(String[] args) {
        int[] level = {1, 2, 3, 4, 5, 6};
        LevelOrderArr object = new LevelOrderArr();
        Node root = null;
        root = object.buildTree(level, root, 0);
        object.inorder(root);
    }

    private Node buildTree(int[] level, Node root, int index) {
       if(index < level.length) {
           root = new Node(level[index]);

           root.left = buildTree(level, root.left, (2*index) + 1);
           root.right = buildTree(level, root.right, (2*index) + 2);
       }
       return root;
    }

    private void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
}
