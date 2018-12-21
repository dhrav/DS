package BinarySearchTree.RedBlackTree;

public class Insertion {
    static Node rbtRoot = null;
    public static void main(String[] args) {
        insert(10);
        preorder(rbtRoot);
        System.out.println("---------------------After 10---------------------");
        insert( 20);
        preorder(rbtRoot);
        System.out.println("---------------------After 20---------------------");
        insert( 30);
        preorder(rbtRoot);
        System.out.println("---------------------After 30---------------------");
        insert( 40);
        preorder(rbtRoot);
        System.out.println("---------------------After 40---------------------");
        insert( 50);
        preorder(rbtRoot);
        System.out.println("---------------------After 50---------------------");
        insert( 25);
        preorder(rbtRoot);
        System.out.println("---------------------After 25---------------------");

        System.out.println("Preorder traversal of the constructed tree is:");
        preorder(rbtRoot);
    }

    public static Node getRoot() {
        return rbtRoot;
    }

    public static void setRoot(Node newRoot) {
        rbtRoot= newRoot;
    }

    public static void preorder(Node root) {
        if(root == null || root.isNullLeaf()) {
            return;
        }

        printColour(root);
        System.out.println(root.getData());
        preorder(root.getLeft());
        preorder(root.getRight());
    }

    private static void printColour(Node node) {
        if(node != null) {
            if(node.getColour() == Colour.RED) {
                System.out.print("R");
            } else {
                System.out.print("B");
            }
        }
    }

    public static Node insert(int key) {
        Node newNode = createRedNode(key);
        Node temp = rbtRoot;
        Node prev = null;
        while(null != temp && !temp.isNullLeaf()) {
            prev = temp;
            if(newNode.getData() < temp.getData()) {
                temp = temp.getLeft();
            } else if(newNode.getData() > temp.getData()){
                temp = temp.getRight();
            } else {
                break;
            }
        }

        newNode.setParent(prev);
        //if tree is empty, mark the node as black and return
        if(rbtRoot == null) {
            newNode.setColour(Colour.BLACK);
            rbtRoot = newNode;
            return newNode;
        }
        if(prev.getData() < newNode.getData()) {
            prev.setRight(newNode);
        } else {
            prev.setLeft(newNode);
        }

        return fixUp(newNode);
    }

    private static Node fixUp(Node curNode) {
        while(curNode != rbtRoot && curNode.isColour(Colour.RED) && curNode.getParent().isColour(Colour.RED)) {

            //check uncle
            Node parent = curNode.getParent();
            Node grandParent = parent.getParent();
            Node uncle = null;
            if(grandParent != null && parent == grandParent.getLeft()) {
                uncle = grandParent.getRight();
            } else if(grandParent != null && parent == grandParent.getRight()){
                uncle = grandParent.getLeft();
            }
            if(uncle != null && uncle.isColour(Colour.RED)) {
                //do recolour
                parent.setColour(Colour.BLACK);
                uncle.setColour(Colour.BLACK);
                uncle.getParent().setColour(Colour.RED);
                curNode = parent.getParent();
            } else {
                //uncle is black or null
                // do rotation
                //and recolor if needed


                //check LL case
                if(curNode == parent.getLeft() && parent == parent.getParent().getLeft()) {
                    Node node = rightRotate(parent.getParent());
                    node.swapColour();
                    node.getRight().swapColour();
                } else if(curNode == parent.getRight() && parent == parent.getParent().getLeft()) {
                    // check LR case
                    parent = leftRotate(parent);
                    curNode = parent.getLeft();
                    Node node = rightRotate(parent.getParent());
                    node.swapColour();
                    node.getRight().swapColour();
                } else if(curNode == parent.getRight() && parent == parent.getParent().getRight()) {
                    //check RR case
                    Node node = leftRotate(parent.getParent());
                    node.swapColour();
                    node.getLeft().swapColour();
                } else if(curNode == parent.getLeft() && parent == parent.getParent().getRight()) {
                    //check RL case
                    parent = rightRotate(parent);
                    curNode = parent.getRight();
                    Node node = leftRotate(parent.getParent());
                    node.swapColour();
                    node.getLeft().swapColour();
                }
            }


        }
        rbtRoot.setColour(Colour.BLACK);
        return rbtRoot;
    }

    private static Node leftRotate(Node node) {

        Node newRoot = node.getRight();
        Node newRootLeftTree = newRoot.getLeft();

        newRoot.setLeft(node);
        node.setRight(newRootLeftTree);

        newRoot.setParent(node.getParent());
        if(newRoot.getParent() != null) {
            Node parent = newRoot.getParent();
            if(newRoot.getData() > parent.getData()) {
                parent.setRight(newRoot);
            } else {
                parent.setLeft(newRoot);
            }
        }

        node.setParent(newRoot);
        if(node == rbtRoot) {
            rbtRoot = newRoot;
        }
        return newRoot;
    }

    private static Node rightRotate(Node node) {

        Node newRoot = node.getLeft();
        Node newRootRightTree = newRoot.getRight();

        newRoot.setRight(node);
        node.setLeft(newRootRightTree);

        newRoot.setParent(node.getParent());
        if(newRoot.getParent() != null) {
            Node parent = newRoot.getParent();
            if(newRoot.getData() > parent.getData()) {
                parent.setRight(newRoot);
            } else {
                parent.setLeft(newRoot);
            }
        }
        node.setParent(newRoot);

        if(node == rbtRoot) {
            rbtRoot = newRoot;
        }
        return newRoot;
    }

    public static Node createNullNode() {
        Node nullNode = new Node();
        nullNode.setColour(Colour.BLACK);
        nullNode.setLeft(null);
        nullNode.setRight(null);
        nullNode.setNullLeaf(true);
        return nullNode;
    }

    public static Node createRedNode(int data) {
        Node redNode = new Node();
        redNode.setColour(Colour.RED);
        redNode.setLeft(createNullNode());
        redNode.setRight(createNullNode());
        redNode.setData(data);
        redNode.setNullLeaf(false);
        return redNode;
    }


}
