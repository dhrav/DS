package BinaryTree;


import java.util.LinkedList;
import java.util.List;

public class InorderPreSucSum {
    List<Integer> inorderlist = new LinkedList<>();
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node temp = root;
        InorderPreSucSum object = new InorderPreSucSum();
        object.populateList(temp);

        int arrSize = object.inorderlist.size()+2;

        int[] arr = new int[arrSize];
        int index = 0;
        //making left predecessor as 0
        arr[index++]=0;
        for(;index < arrSize-1; index++)
        {
            arr[index] = object.inorderlist.get(index-1);
        }
        //making right successor as zero
        arr[index]=0;

        //print the inorderlist to verify
       /* for(int i : arr)
        {
            System.out.println(i);
        }*/
        object.updateNodeVal(root, arr);
        object.preorder(root);

    }

    private void preorder(Node root) {
        if(root == null) {
            return;
        }

        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    static int index = 1;


    private void updateNodeVal(Node root, int[] arr) {

        if(root == null) {
            return;
        }

        updateNodeVal(root.left, arr);
        root.data = arr[index-1] + arr[index+1];
        index++;
        updateNodeVal(root.right, arr);
    }

    private void populateList(Node root) {
        if(root==null) {
            return;
        }
        populateList(root.left);
        //System.out.println(root.data);
        inorderlist.add(root.data);
        populateList(root.right);
    }



}
