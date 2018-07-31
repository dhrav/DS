package BinaryTree.Construction;

public class BTToMirror {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        Node temp = root;
        System.out.println("Before conversion");
        inorder(temp);


        convertToMirror(root);
        System.out.println("After conversion");
        inorder(temp);
    }

    private static Node convertToMirror(Node root) {
        if(root == null) {
            return root;
        }

        Node left = convertToMirror(root.left);
        Node right = convertToMirror(root.right);


        root.left = right;
        root.right = left;

        return root;
    }

    private static void inorder(Node root) {
        if(root== null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
}
