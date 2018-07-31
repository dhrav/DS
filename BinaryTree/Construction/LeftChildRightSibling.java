package BinaryTree.Construction;

class NodeLCRS {
    int data;
    NodeLCRS left, sibling;
    NodeLCRS(int data) {
        this.data = data;
        left = null;
        sibling = null;
    }
}

public class LeftChildRightSibling {
    public static void main(String[] args) {
        NodeLCRS root = new NodeLCRS(10);
        NodeLCRS child1 = addChild(root, 2);
        NodeLCRS child2 = addChild(root, 3);
        NodeLCRS child3 = addChild(root, 4);
        NodeLCRS child4 = addChild(root, 5);
        NodeLCRS child5 = addChild(child3, 6);
        NodeLCRS child6 = addChild(child4, 7);
        NodeLCRS child7 = addChild(child4, 8);
        NodeLCRS child8 = addChild(child4, 9);

        traverseTree(root);
    }

    private static void traverseTree(NodeLCRS root) {
        if(root == null) {
            return;
        }

        System.out.println(root.data);
        if(root.left != null) {
            traverseTree(root.left);
        }
        if(root.sibling != null) {
            traverseTree(root.sibling);
        }

    }

    private static NodeLCRS addChild(NodeLCRS root, int childData) {
        NodeLCRS child = new NodeLCRS(childData);

        if(root.left == null) {
            root.left = child;
        } else {
            NodeLCRS current = root.left;
            while(current.sibling != null) {
                current = current.sibling;
            }
            current.sibling = child;
        }
        return child;
    }
}
