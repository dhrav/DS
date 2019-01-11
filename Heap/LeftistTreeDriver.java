package Heap;

public class LeftistTreeDriver {
    public static void main(String[] args) {
        LeftistHeap heap = new LeftistHeap();

        System.out.println("\nInserting 2");
        heap.insert(2);

        System.out.println("\nInserting 7");
        heap.insert(7);

        System.out.println("\nInserting 3");
        heap.insert(3);

        heap.displayLeftistTree();

        System.out.println("\nFind the minimum" + heap.findMinimum());

        System.out.println("\nDeleting Min");
        heap.extractMin();
        heap.displayLeftistTree();

        System.out.println("\nDeleting Min");
        heap.extractMin();
        heap.displayLeftistTree();
    }
}
