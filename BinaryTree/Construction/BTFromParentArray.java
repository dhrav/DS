package BinaryTree.Construction;

public class BTFromParentArray {
    public static void main(String[] args) {
        int[] parent = {-1, 0, 0, 1, 1, 3, 5};
        //int[] parent = {1, 5, 5, 2, 2, -1, 3};
        Node root = null;
        root = buildTree(parent);
        inorder(root);
    }

    private static Node buildTree(int[] parent) {
        Node[] created = new Node[parent.length];
        Node root = null;
        for(int i = 0; i < parent.length; i++) {
            created[i] = createNode(parent, i, created);
            if(parent[i] == -1) {
                root = created[i];
            }
        }
        return root;


    }

    private static Node createNode(int[] parent, int i, Node[] created) {

        if(created[i] != null) {
            return created[i];
        }

        Node newNode = new Node(i);
        created[i] = newNode;

        if(parent[i] != -1) {

            Node parentNode = null;

            if (created[parent[i]] == null) {
                parentNode = createNode(parent, parent[i], created);
            } else {
                parentNode = created[parent[i]];
            }


            if (parentNode.left == null) {
                parentNode.left = newNode;
            } else if (parentNode.right == null) {
                parentNode.right = newNode;
            }
        }

        return newNode;
    }

    private static void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
}
