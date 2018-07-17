package BinaryTree;

public class PostOrderNth {
    static int count = 0;
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(9);
        root.left.left = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        Node temp = root;
        postorder(temp, 5);
    }

    private static void postorder(Node temp, int nth) {
        if(temp == null) {
            return;
        }

        postorder(temp.left, nth);
        postorder(temp.right, nth);
        count++;
        if(count==nth) {
            System.out.println(temp.data);
        }
    }
}
