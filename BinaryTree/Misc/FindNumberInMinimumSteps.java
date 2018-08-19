package BinaryTree.Misc;

import java.util.LinkedList;
import java.util.Queue;

public class FindNumberInMinimumSteps {
    static class Node {
        int number;
        int level;
        public Node(int number, int level) {
            this.number =number;
            this.level = level;
        }
    }
    public static void main(String[] args) {
        //do level order traversal and find the path closest to the root
        int number = -4;
        find(number);
    }

    private static void find(int number) {
        if(number <= Integer.MIN_VALUE || number >= Integer.MAX_VALUE) {
            System.out.println("Invalid input");
        }


        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 1));

        while(!queue.isEmpty()) {
            Node element = queue.remove();
            if(element.number == number) {
                System.out.println("The minimum steps to reach " + number + " is " + (element.level-1));
                return;
            }

            queue.add(new Node(element.number - element.level, element.level+1));
            queue.add(new Node(element.number + element.level, element.level+1));
        }
    }
}
