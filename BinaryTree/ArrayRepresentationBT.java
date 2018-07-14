package BinaryTree;

public class ArrayRepresentationBT {
    String[] tree;
    int root;

    public ArrayRepresentationBT(int size) {
        tree = new String[size];
        root = 0;
    }

    public void setRoot(String key) {
        tree[0] = key;
    }

    public void setLeft(String key, int root) {
        int index = (2 * root) + 1 ;
        tree[index] = key;
    }

    public void setRight(String key, int root) {
        int index = (2 * root) + 2;
        tree[index] = key;
    }

    public void printTree()
    {
        int size = tree.length;
        for(int i = 0; i < size; i++) {
            if(tree[i] != null) {
                System.out.println(tree[i]);
            }
            else {
                System.out.println("Empty");
            }
        }
    }

    public static void main(String[] args) {
        ArrayRepresentationBT arrayRepObject = new ArrayRepresentationBT(7);
        arrayRepObject.setRoot("A");
        arrayRepObject.setLeft("B", 0);
        arrayRepObject.setRight("C", 0);
        arrayRepObject.setLeft("D", 1);
        arrayRepObject.setRight("E", 1);
        arrayRepObject.setRight("F", 2);

        arrayRepObject.printTree();
    }

}
