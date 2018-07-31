package BinaryTree.CheckingPrinting;



class Reference {
    int i;
}

public class CheckBTIsSubTree {
   static class Node {
        char data;
        Node left, right;
        Node(char c) {
            data = c;
            left = null;
            right = null;
        }
    }
    public static void main(String[] args) {
        Node T = new Node('a');
        T.left = new Node('b');
        T.right = new Node('d');
        T.left.left = new Node('c');
        T.right.right = new Node('e');

        Node S = new Node('a');
        S.left = new Node('b');
        S.left.left = new Node('c');
        S.right = new Node('d');

        System.out.println(isSubTree(T,S));
    }

    private static boolean isSubTree(Node T, Node S) {
        if(S == null) {
            return true;
        }

        if(T == null) {
            return false;
        }

        char[] inorderT = new char[100];
        storeInorder(T, inorderT, new Reference());

        char[] inorderS = new char[100];
        storeInorder(S, inorderS, new Reference());

        String inT = String.valueOf(inorderT);
        String inS = String.valueOf(inorderS);

        if(!strstr(inT, inS)) {
            return false;
        }

        char[] preorderT = new char[100];
        storePreorder(T, preorderT, new Reference());

        char[] preorderS = new char[100];
        storePreorder(S, preorderS, new Reference());

        String preT = String.valueOf(preorderT);
        String preS = String.valueOf(preorderS);

        return strstr(preT, preS);

    }

    private static boolean strstr(String source, String pattern) {
        int sourceLength = source.length();
        int patternLength = pattern.length();

        if(sourceLength < patternLength) {
            return false;
        }

        for(int i = 0; i <= sourceLength-patternLength; i++) {
            if(source.charAt(i) == pattern.charAt(0)) {
                for(int j = 0; j < patternLength; j++) {
                    if(source.charAt(j+i) != pattern.charAt(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void storePreorder(Node root, char[] preorderT, Reference reference) {
        if(root == null) {
            preorderT[reference.i++] = '$';
            return;
        }

        preorderT[reference.i++] = root.data;
        storeInorder(root.left, preorderT, reference);
        storeInorder(root.right, preorderT, reference);
    }

    private static void storeInorder(Node root, char[] inorderT, Reference reference) {
        if(root == null) {
            inorderT[reference.i++] = '$';
            return;
        }

        storeInorder(root.left, inorderT, reference);
        inorderT[reference.i++] = root.data;
        storeInorder(root.right, inorderT, reference);
    }


}
