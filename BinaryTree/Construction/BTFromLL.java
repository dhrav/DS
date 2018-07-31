package BinaryTree.Construction;

import java.util.LinkedList;
import java.util.Queue;

public class BTFromLL {
    ListNode list = null;
    public static void main(String[] args) {
        BTFromLL object = new BTFromLL();
        object.addToList(36);
        object.addToList(30);
        object.addToList(25);
        object.addToList(15);
        object.addToList(12);
        object.addToList(10);

        Node root = object.buildTree();
        object.inorder(root);

    }

    private Node buildTree() {
        Queue<Node> queue = new LinkedList<>();
        ListNode temp = list;
        Node root = new Node(temp.data);
        queue.add(root);


        while(temp != null) {
            Node element = queue.remove();
            if(temp.next == null) {
                temp = temp.next;
                continue;
            }
            if(temp.next != null) {
                element.left = new Node(temp.next.data);
                temp = temp.next;
                queue.add(element.left);
            }
            if(temp.next != null) {
                element.right = new Node(temp.next.data);
                temp = temp.next;
                queue.add(element.right);
            }
        }
        return root;
    }

    private void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public void addToList(int data) {
        ListNode newNode = new ListNode(data);
        if(list == null) {
            list = newNode;
            list.next = null;
            return;
        } else {
            newNode.next = list;
            list = newNode;
        }


    }
}
