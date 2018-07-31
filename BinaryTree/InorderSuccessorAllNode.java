package BinaryTree;

class NodeWithSucc {
    int data;
    NodeWithSucc left, right, next;
    public NodeWithSucc(int data) {
        this.data = data;
        left = null;
        right = null;
        next = null;
    }
}

public class InorderSuccessorAllNode {
    NodeWithSucc prev;

    public static void main(String[] args) {
        NodeWithSucc root = new NodeWithSucc(10);
        root.left = new NodeWithSucc(11);
        root.right = new NodeWithSucc(9);
        root.left.left = new NodeWithSucc(7);
        root.right.left = new NodeWithSucc(15);
        root.right.right = new NodeWithSucc(8);

        InorderSuccessorAllNode object = new InorderSuccessorAllNode();
        object.populateNextPointer(root);
        System.out.println("***************************************");
        System.out.println(root.next.data);//15
        System.out.println(root.left.next.data); //10
        System.out.println(root.right.next.data); //8
        System.out.println(root.left.left.next.data);//11

    }

    public void populateNextPointer(NodeWithSucc root) {
        if(root == null) {
            return;
        }

        populateNextPointer(root.right);

        root.next = prev;
        prev = root;

        populateNextPointer(root.left);
    }


}
