package BinaryTree;

class NodeCustom {
    int data;
    boolean visited;
    NodeCustom left, right;
    NodeCustom(int data) {
        this.data = data;
        left = null;
        right = null;
        visited = false;
    }
}

public class PostOrderWIthoutStack {
    public static void main(String[] args) {
        NodeCustom root = new NodeCustom(10);
        root.left = new NodeCustom(11);
        root.right = new NodeCustom(9);
        root.left.left = new NodeCustom(7);
        root.right.left = new NodeCustom(15);
        root.right.right = new NodeCustom(8);
        NodeCustom temp = root;
        postorder(temp);
    }

    private static void postorder(NodeCustom temp) {
       if(temp == null) {
           return;
       }

        NodeCustom current = temp;
       while(current != null && current.visited == false) {

           //check if left tree is visited
           if(current.left != null && current.left.visited == false) {
               current = current.left;
           } //check if right tree is visited
           else if(current.right != null && current.right.visited == false) {
               current = current.right;
           }
           else {
               //process the tree
               System.out.println(current.data);
               current.visited = true;
               current = temp;
           }




       }

    }
}
