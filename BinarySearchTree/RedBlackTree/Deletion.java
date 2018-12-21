package BinarySearchTree.RedBlackTree;
/*
* Explains the insertion
* and
* deletion of Deletion*/

public class Deletion {

    public static void main(String[] args) {
        Insertion.insert(10);
        Insertion.insert(20);
        Insertion.insert(30);
        Insertion.insert(15);
        Node root = Insertion.getRoot();
        Insertion.preorder(root);

        System.out.println("After deleting 15");
        delete(root, 15);
        Insertion.preorder(root);

        boolean isValid = RBTHelper.validateRedBlackRelation(Insertion.getRoot());


        System.out.println("After deleting 15, check validity of Red-Black Relation " + (isValid ? "TRUE" : "FALSE"));
    }

    private static void delete(Node root, int key) {
        if(root == null || root.isNullLeaf()) {
            System.out.println("Node not present");
            return;
        }

        if(root.getData() == key) {
            //convert it to 0/1 child node
            if(isInternalNode(root)) {
                //case to convert the internal node to 0/1 child node

                //find the min node in the right subtree
                Node minNode = findMin(root.getRight());
                root.setData(minNode.getData());
                delete(root.getRight(), minNode.getData());
            } else {
                deleteOneChild(root);
            }
        } else if(root.getData() > key) {
            delete(root.getLeft(), key);
        } else {
            delete(root.getRight(), key);
        }
    }

    private static void deleteOneChild(Node nodeToDelete) {
        //Here the nodeToDelete has one or zero child
        Node child = nodeToDelete.getRight().isNullLeaf() ? nodeToDelete.getLeft() : nodeToDelete.getRight();

        replaceNode(nodeToDelete, child);
        //if nodeToDelete is red in colour, we do not bother
        //if black, check for the child
        //if child is RED, recolour
        //otherwise double black
        if(nodeToDelete.isColour(Colour.BLACK)) {
            if(child.isColour(Colour.RED)) {
                child.setColour(Colour.BLACK);
            } else {
                //both nodeToDelete and the child are black in colour
                //we are in double black situation now
                deleteFixUp(child);
            }
        }

    }

    private static void deleteFixUp(Node doubleBlackNode) {
        //delete case 1
        //check if double black node is root, if yes, then return

        if(doubleBlackNode.getParent() == null) {
            //if root node
            Insertion.setRoot(doubleBlackNode);
            return;
        }
        deleteCase2(doubleBlackNode);
    }

    private static void deleteCase2(Node doubleBlackNode) {
        //check if sibling is red
        Node sibling = findSibling(doubleBlackNode);
        if(sibling.isColour(Colour.RED)) {
            if(isLeftChild(sibling)) {
                rightRotate(sibling);
            } else {
                leftRotate(sibling);
            }

            //after rotation, check if sibling became root
            //if yes, update tree's root
            if(sibling.getParent() == null) {
                Insertion.setRoot(sibling);
            }
        }
        deleteCase3(doubleBlackNode);
    }

    private static void deleteCase3(Node doubleBlackNode) {
        //case 3: sibling is black, with 2 black children and a black parent
        Node sibling = findSibling(doubleBlackNode);
        if(sibling.isColour(Colour.BLACK) && sibling.getParent().isColour(Colour.BLACK) && sibling.getLeft().isColour(Colour.BLACK) && sibling.getRight().isColour(Colour.BLACK)) {
            // case 3: all black
            sibling.setColour(Colour.RED);
            //make parent as double black node and repeat the process
            deleteFixUp(sibling.getParent());
        } else {
            deleteCase4(doubleBlackNode);
        }
    }

    private static void deleteCase4(Node doubleBlackNode) {
        Node sibling = findSibling(doubleBlackNode);
        Node parent = sibling.getParent();


        if(parent.isColour(Colour.RED) && sibling.isColour(Colour.BLACK) && sibling.getLeft().isColour(Colour.BLACK) && sibling.getRight().isColour(Colour.BLACK)) {
            //case 4: parent is red, sibling and its children are red
            //just recolour the parent and sibling
            parent.setColour(Colour.BLACK);
            sibling.setColour(Colour.RED);
        } else {
            deleteCase5(doubleBlackNode);
        }
    }

    private static void deleteCase5(Node doubleBlackNode) {
        Node sibling = findSibling(doubleBlackNode);

        if(sibling.isColour(Colour.BLACK)) {
            //case 5: parent is black
            //sibling is black and its left child is RED, right child is black with the double black node being left child
            if(isLeftChild(doubleBlackNode) && sibling.getLeft().isColour(Colour.RED) && sibling.getParent().isColour(Colour.BLACK) && sibling.getRight().isColour(Colour.BLACK)) {
                rightRotate(sibling.getLeft());
            } else if(!isLeftChild(doubleBlackNode) && sibling.getRight().isColour(Colour.RED)  && sibling.getParent().isColour(Colour.BLACK) && sibling.getLeft().isColour(Colour.BLACK)){
                leftRotate(sibling.getRight());
            }
        }

        deleteCase6(doubleBlackNode);
    }

    private static void deleteCase6(Node doubleBlackNode) {
        Node sibling = findSibling(doubleBlackNode);
        sibling.setColour(sibling.getParent().getColour());
        sibling.getParent().setColour(Colour.BLACK);
        if(isLeftChild(doubleBlackNode)) {
            sibling.getRight().setColour(Colour.BLACK);
            leftRotate(sibling);
        } else {
            sibling.getLeft().setColour(Colour.BLACK);
            rightRotate(sibling);
        }

        //after rotation, check if sibling became root
        //if yes, update tree's root
        if(sibling.getParent() == null) {
            Insertion.setRoot(sibling);
        }
    }

    private static void leftRotate(Node node) {
        Node parent = node.getParent();
        Node leftTree = node.getLeft();

       if(parent != null) {
           Node grandparent = parent.getParent();
           if(grandparent != null) {
               if(isLeftChild(parent)) {
                   grandparent.setLeft(node);
               } else {
                   grandparent.setRight(node);
               }
           }
           node.setParent(grandparent);

           node.setLeft(parent);
           parent.setParent(node);

           parent.setRight(leftTree);
           leftTree.setParent(parent);
       }
    }

    private static void rightRotate(Node node) {
        Node parent = node.getParent();
        Node rightTree = node.getRight();

        if(parent != null) {
            Node grandParent = parent.getParent();
            if(grandParent != null) {
                if(isLeftChild(parent)) {
                    grandParent.setLeft(node);
                } else {
                    grandParent.setRight(node);
                }
            }

            node.setParent(grandParent);

            node.setRight(parent);
            parent.setParent(node);

            parent.setLeft(rightTree);
            rightTree.setParent(parent);
        }
    }

    private static Node findSibling(Node node) {
        Node parent = node.getParent();
        if(isLeftChild(node)) {
            return parent.getRight();
        } else {
            return parent.getLeft();
        }
    }

    private static void replaceNode(Node nodeToDelete, Node child) {
        child.setParent(nodeToDelete.getParent());

        Node parent = child.getParent();
        if(parent == null) {
            Insertion.setRoot(child);
        } else {
            if(isLeftChild(nodeToDelete)) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }
    }

    private static boolean isLeftChild(Node node) {
        Node parent = node.getParent();
        if(parent !=  null && parent.getLeft() == node) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isInternalNode(Node root) {
        return root.getLeft() != null && !root.getLeft().isNullLeaf() && root.getRight() != null && !root.getRight().isNullLeaf();
    }

    private static Node findMin(Node node) {
        while(!node.getLeft().isNullLeaf()) {
            node = node.getLeft();
        }
        return node;
    }

}
