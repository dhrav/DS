package BinaryTree.Construction;

public class BTToLogicalAND {
    public static void main(String[] args) {
        Node root=new Node(0);
        root.left=new Node(1);
        root.right=new Node(0);
        root.left.left=new Node(0);
        root.left.right=new Node(1);
        root.right.left=new Node(1);
        root.right.right=new Node(1);

        convertTree(root);
        postorder(root);
    }

    private static void postorder(Node root) {
        if(root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    private static Node convertTree(Node root) {
        if(root == null) {
            return null;
        }

        Node left = convertTree(root.left);
        Node right = convertTree(root.right);

        if(left != null && right != null) {
            root.data = left.data & right.data;
        }
        return root;
    }
}
