package Heap;

public class BinomialHeapDriver {
    public static void main(String[] args) {
        System.out.println("Binomial Heap Test\n");
        BinomialHeap binomialHeap = new BinomialHeap();

        //Insertion into the heap
        binomialHeap.insert(1);
        binomialHeap.displayHeap();
        System.out.println(binomialHeap.getSize());

        //delete the inserted element from heap
        binomialHeap.delete(1);
        binomialHeap.displayHeap();
        System.out.println(binomialHeap.getSize());
    }
}
