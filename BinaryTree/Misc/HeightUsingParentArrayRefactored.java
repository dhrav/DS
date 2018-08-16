package BinaryTree.Misc;

public class HeightUsingParentArrayRefactored {
    static boolean[] visited;
    static  int[] depth;
    public static void main(String[] args) {
        int parent[] = { -1, 0, 0, 0, 3, 1, 1, 2 };
        System.out.println(findTreeDepth(parent));
    }

    private static int findTreeDepth(int[] parent) {
        int size = parent.length;
        visited = new boolean[size];
        depth = new int[size];

        for(int i=0; i < size; i++) {
            if(!visited[i]) {
                depth[i] = fillDepth(parent, i);
            }
        }
        int maxDepth = Integer.MIN_VALUE;
        for(int i : depth) {
            if(maxDepth < i) {
                maxDepth = i;
            }
        }
        return maxDepth;
    }

    private static int fillDepth(int[] parent, int index) {
        if(parent[index] == -1) {
            visited[index] = true;
            return 0;
        }

        if(depth[index] != 0) {
            return depth[index];
        }

        visited[index] = true;
        return 1+ fillDepth(parent, parent[index]);
    }
}
