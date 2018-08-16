package BinaryTree.Misc;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class SuccinctEncodingDecoding {
    class Result {
        List<Integer> bitStructure = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
    }

    public static void main(String[] args) {
        Node root         = new Node(10);
        root.left         = new Node(20);
        root.right        = new Node(30);
        root.left.left   = new Node(40);
        root.left.right  = new Node(50);
        root.right.right = new Node(70);
        SuccinctEncodingDecoding object = new SuccinctEncodingDecoding();

        Result result = object.doSuccinctEncoding(root);
        System.out.println();
        System.out.println("Printing Decoded Tree");
        Node decodedTree = object.doSuccinctDecoding(result.bitStructure, result.data);
        object.preorder(decodedTree);
    }

    private void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    private Result doSuccinctEncoding(Node root) {
        Result result = new Result();
        encodeUtil(root, result);
        System.out.println("Encoding of binary tree");
        for(int i=0; i < result.bitStructure.size(); i++) {
            System.out.print(result.bitStructure.get(i));
        }
        return result;
    }

    private Node doSuccinctDecoding(List<Integer> bitStructure, List<Integer> data) {
        Node rootResult = null;
        while(bitStructure.size() > 0) {

            int bit = bitStructure.remove(0);
            if(bit == 1) {
                Node root = new Node(data.remove(0));
                if(rootResult == null) {
                    rootResult = root;
                }
                root.left = doSuccinctDecoding(bitStructure, data);
                root.right = doSuccinctDecoding(bitStructure, data);
                return root;
            } else {
                return null;
            }
        }
        return rootResult;
    }

    private void encodeUtil(Node root, Result result) {
        if(root == null) {
            result.bitStructure.add(0);
            return;
        }

        result.data.add(root.data);
        result.bitStructure.add(1);

        encodeUtil(root.left, result);
        encodeUtil(root.right, result);
    }
}
