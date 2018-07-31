package BinaryTree.Construction;

class NodeForChar {
    char data;
    NodeForChar left, right;
    NodeForChar(char c) {
        data = c;
    }
}
public class ConstructBTFromTernaryString {
    public static void main(String[] args) {
        String input = "a?b?d?f:g:e:c";
        NodeForChar root = null;
        root = buildTree(input, 0, input.length(), root);
        preorder(root);
    }

    private static NodeForChar buildTree(String input, int low, int high, NodeForChar root) {
        if(low > high || high > input.length() ) {
            return null;
        }
        char current = input.charAt(low);
        root = new NodeForChar(current);
        input = input.substring(low, high);
        if(input.length() > 1) {
            root.left = buildTree(input, input.indexOf('?') + 1, input.lastIndexOf(':'), root.left);
            root.right = buildTree(input, input.lastIndexOf(':') + 1, input.length(), root.right);
        }
        return root;
    }

    private static void preorder(NodeForChar root) {
        if(root == null) {
            return;
        }

        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }
}
