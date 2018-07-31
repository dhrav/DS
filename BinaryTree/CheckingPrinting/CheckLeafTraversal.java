package BinaryTree.CheckingPrinting;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class CheckLeafTraversal {
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        Node root2 = new Node(0);
        root2.left = new Node(1);
        root2.right = new Node(5);
        root2.left.right = new Node(4);
        root2.right.left = new Node(6);
        root2.right.right = new Node(7);
        root2.right.right.right = new Node(17);

        System.out.println(checkLeafTraversal(root1, root2));
    }

    private static boolean checkLeafTraversal(Node root1, Node root2) {
        if(root1 != null && root2 != null) {

            List<Integer> firstTreeLeafList = getLeafNodes(root1, new ArrayList<>());
            List<Integer> secondTreeLeafList = getLeafNodes(root2, new ArrayList<>());

            if (firstTreeLeafList.size() == secondTreeLeafList.size()) {
                for (int i = 0; i < firstTreeLeafList.size(); i++) {
                    if (!firstTreeLeafList.get(i).equals(secondTreeLeafList.get(i))) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> getLeafNodes(Node root1, List<Integer> list) {

        if(root1 == null) {
            return list;
        }

        list = getLeafNodes(root1.left, list);
        list = getLeafNodes(root1.right, list);

        if(root1.left == null && root1.right == null) {
            list.add(root1.data);
        }

        return list;
    }
}
