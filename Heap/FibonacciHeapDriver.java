package Heap;

public class FibonacciHeapDriver {
    public static void main(String[] args) {
        FibonacciHeap fibonacciHeap = new FibonacciHeap();

        System.out.println("\nInserting 2,3,7");
        //Adding new entries to fibonacci heap
        fibonacciHeap.insert(2);
        fibonacciHeap.insert(3);
        fibonacciHeap.insert(7);

        System.out.println("The heap values are:");
        fibonacciHeap.displayHeap();

        System.out.println("\nThe minimum entry in fibo heap is " + fibonacciHeap.findMinimum());

        //deleting some entries from fibonacci heap
        System.out.println("\nExtracted Min element is : " + fibonacciHeap.extractMin());

        System.out.println("The heap values are:");
        fibonacciHeap.displayHeap();

        System.out.println("\nDecreasing value of 7 as 0");
        fibonacciHeap.decreaseKey(7, 0);

        System.out.println("The heap values are:");
        fibonacciHeap.displayHeap();

        fibonacciHeap.delete(3);
        System.out.println("After deleting 3, The heap values are:");
        fibonacciHeap.displayHeap();



    }
}
