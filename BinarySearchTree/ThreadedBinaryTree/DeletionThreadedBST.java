package BinarySearchTree.ThreadedBinaryTree;

public class DeletionThreadedBST {
    static class Node {
        int data;
        boolean isLeftThreaded;
        boolean isRightThreaded;
        Node left, right;
        public Node(int data) {
            this.data = data;
            this.isLeftThreaded = this.isRightThreaded = false;
            this.left = this.right = null;
        }
    }
    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 20);
        root = insert(root, 10);
        root = insert(root, 30);
        root = insert(root, 5);
        root = insert(root, 16);
        root = insert(root, 14);
        root = insert(root, 17);
        root = insert(root, 13);

        System.out.println("Inorder before deletion");
        inorder(root);

        //node is leaf
        root = deleteBST(root, 17);
        System.out.println("After deleting 17");
        inorder(root);

        //node with one child
        root = deleteBST(root, 14);
        System.out.println("After deleting 14");
        inorder(root);

        //node with two children
        root = deleteBST(root, 20);
        System.out.println("After deleting 20");
        inorder(root);
    }

    private static Node deleteBST(Node root, int key) {
        Node current = root;
        Node parent = null;
        boolean found = false;
        while(current != null) {
            if(current.data == key) {
                found = true;
                break;
            }

            parent = current;
            if(current.data < key) {
                if(current.isRightThreaded) {
                    break;
                } else {
                    current = current.right;
                }
            } else if(current.data > key) {
                if(current.isLeftThreaded) {
                    break;
                } else {
                    current= current.left;
                }
            }
        }

        if(!found) {
            System.out.println("Key not found");
            return root;
        }


        if(current.isLeftThreaded  && current.isRightThreaded ) {
            //node to be deleted is a leaf node
            root = deleteLeaf(parent, current, root);
        } else if(current.isRightThreaded || current.isLeftThreaded) {
            //node to be deleted has only one child
            root = deleteNodeWithOneChild(parent, current, root);
        } else {
            //node to be deleted has two children
            root = deleteNodeWithTwoChildren(parent, current, root);
        }
        return root;
    }

    private static Node deleteNodeWithTwoChildren(Node parent, Node current, Node root) {
       //find the inorder successor and its parent
        Node parentSucc = current;
        Node succ = current.right;
        while(succ.left != null && !succ.isLeftThreaded) {
            parentSucc = succ;
            succ = succ.left;
        }

         //replace the data of root with inorder succ data
        current.data = succ.data;
        //delete inorder succ
        if(succ.isLeftThreaded && succ.isRightThreaded) {
            root = deleteLeaf(parentSucc, succ, root);
        } else {
            root = deleteNodeWithOneChild(parentSucc, succ, root);
        }
        return root;
    }


    private static Node deleteNodeWithOneChild(Node parent, Node current, Node root) {

        Node child = null;
        if(current.isRightThreaded) {
            child = current.left;
        } else {
            child = current.right;
        }
        if(parent == null) {
            root = child;
        } else if(current == parent.left) {
            parent.left = child;
        } else if(current == parent.right) {
            parent.right = child;
        }

        Node successor = findSuccessor(current);
        Node predecessor = findPredecessor(current);

        if(current.isRightThreaded) {
            predecessor.right = successor;
        } else {
            successor.left = predecessor;
        }
        return root;
    }

    private static Node findPredecessor(Node current) {
        if(current.isLeftThreaded) {
            return current.left;
        } else {
            return findRightMost(current.left);
        }
    }

    private static Node findRightMost(Node root) {
        if(root == null) {
            return null;
        }
        while(root.left != null && !root.isLeftThreaded) {
            root = root.left;
        }
        return root;
    }

    private static Node findSuccessor(Node current) {
        if(current.isRightThreaded) {
            return current.right;
        } else {
            return findLeftMost(current.right);
        }
    }

    private static Node deleteLeaf(Node parent, Node current, Node root) {
        if(parent == null) {
            current = null;
            return root;
        } else if(current == parent.left) {
            parent.isLeftThreaded = true;
            parent.left = current.left;
            current = null;
        } else if(current == parent.right) {
            parent.isRightThreaded = true;
            parent.right = current.right;
            current = null;
        }
        return root;
    }

    private static void inorder(Node root) {
        if(root == null) {
            return;
        }

        Node current = findLeftMost(root);
        while(current != null) {
            System.out.println(current.data);
            if(current.isRightThreaded) {
                current = current.right;
            } else {
                current = findLeftMost(current.right);
            }
        }
    }

    private static Node findLeftMost(Node root) {
        if(root == null) {
            return null;
        }

        while(root.left != null && !root.isLeftThreaded) {
            root = root.left;
        }
        return root;
    }

    private static Node insert(Node root, int key) {
        Node current = root;
        Node parent= null;
        while(current != null) {
            if(current.data == key) {
                System.out.println("Duplicate key is present");
                return root;
            }

            parent = current;
            if(current.data <key) {
                if(current.isRightThreaded) {
                    break;
                } else {
                    current = current.right;
                }
            } else {
                if(current.isLeftThreaded) {
                    break;
                } else {
                    current = current.left;
                }
            }
        }

        Node newNode = new Node(key);
        newNode.isLeftThreaded = true;
        newNode.isRightThreaded = true;

        if(parent == null) {
            root = newNode;
        } else if(parent.data > key) {
            parent.isLeftThreaded = false;
            newNode.left = parent.left;
            parent.left = newNode;
            newNode.right =  parent;
        } else {
            parent.isRightThreaded = false;
            newNode.right = parent.right;
            parent.right = newNode;
            newNode.left = parent;
        }
        return root;
    }
}
