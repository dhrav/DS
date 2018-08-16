package BinaryTree.Misc;

public class PossibleEdge {
    public static void main(String[] args) {
        //int n=5, d=3, h=2;
        int  n = 8, d = 4, h = 2;
        printEdges(n,d,h);
    }

    private static void printEdges(int node, int diameter, int height) {
        if(diameter == 1) {
            if(node == 2 && height == 1) {
                System.out.println("1 2");
            } else {
                System.out.println("-1");
            }
            return;
        }

        if(diameter > Math.pow(2,height)) {
            System.out.println("-1");
            return;
        }

        int curNode = 1;

        for(int i = 0; i < height; i++) {
            System.out.println(curNode + " " + (curNode+1));
            curNode+=1;
        }

        int startNode;
        if(diameter > height) {
            startNode = 1;
            curNode = height + 2;
            for(int i = 0; i < (diameter - height); i++) {
                System.out.println(startNode + " " + curNode);
                startNode = curNode;
                curNode = curNode+1;
            }
        }
        if(diameter == height) {
            startNode = 2;
        } else {
            startNode = 1;
        }

        for(int i = curNode; i <=node; i++) {
            System.out.println(startNode + " " + i);
        }
    }
}
