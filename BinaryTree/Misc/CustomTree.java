package BinaryTree.Misc;

public class CustomTree {
    static class Link {
        char start;
        char end;

        public Link(char start, char end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Tree {
        TreeNode root;
        public Tree(TreeNode root) {
            this.root =root;
        }
    }

    static class TreeNode {
        char data;
        TreeNode[] children;

        public TreeNode(char c) {
            data =c;
            children = new TreeNode[26];
        }

        public void addChild(TreeNode child, int index) {
            children[index] = child;
        }

        public void printTree(String indent) {
            System.out.println(indent + "-->" + data);
            for(TreeNode child : children) {
                if(child != null) {
                    child.printTree(indent + "  |");
                }
            }
        }
    }
    public static void main(String[] args) {
        Link[] links = new Link[4];
        links[0] = new Link('a','b');
        links[1] = new Link('b','c');
        links[2] = new Link('b','d');
        links[3] = new Link('a','e');

        System.out.println("-------------Forest 1-------------");
        Tree[] forestArray =  buildForest(links);
        printForest(forestArray);

        Link[] links2 = new Link[9];
        links2[0] = new Link('a','b');
        links2[1] = new Link('a','g');
        links2[2] = new Link('b','c');
        links2[3] = new Link('c','d');
        links2[4] = new Link('c','f');
        links2[5] = new Link('d','e');
        links2[6] = new Link('z','y');
        links2[7] = new Link('y','x');
        links2[8] = new Link('x','w');

        System.out.println("-------------Forest 2-------------");
        forestArray =  buildForest(links2);
        printForest(forestArray);
    }

    private static void printForest(Tree[] forestArray) {
        for(Tree tree : forestArray) {
            if(tree != null) {
                tree.root.printTree(" ");
            }
        }
    }

    private static Tree[] buildForest(Link[] links) {
        TreeNode[] nodeArray = new TreeNode[26];
        Tree[] forestArray = new Tree[26];

        for(Link link : links) {
            char start = link.start;
            char end = link.end;

            int startIndex = start - 'a';
            int endIndex = end - 'a';

            if(nodeArray[startIndex] == null) {
                TreeNode node =  new TreeNode(start);
                nodeArray[startIndex] = node;
                forestArray[startIndex] = new Tree(node);
            }

            if(nodeArray[endIndex] == null) {
                TreeNode node = new TreeNode(end);
                nodeArray[endIndex] = node;
            } else {
                forestArray[endIndex] = null;
            }

            nodeArray[startIndex].addChild(nodeArray[endIndex], endIndex);
        }
        return forestArray;
    }
}
