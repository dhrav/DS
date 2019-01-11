package Heap;


/*
 * binomial heap is a collection of binomial trees
 *each Binomial tree has nodes of order 2^n
 * in a binomial heap, only one binomial tree of order 2^n can be present
 * it follows parent - one child - siblingRight representation
 * */

public class BinomialHeapNode {
    private int data;
    private int degree;
    private BinomialHeapNode parent;
    private BinomialHeapNode sibling;
    private BinomialHeapNode child;

    public BinomialHeapNode(int data) {
        this.data = data;
        degree = 0;
        parent = null;
        sibling = null;
        child = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public BinomialHeapNode getParent() {
        return parent;
    }

    public void setParent(BinomialHeapNode parent) {
        this.parent = parent;
    }

    public BinomialHeapNode getSibling() {
        return sibling;
    }

    public void setSibling(BinomialHeapNode sibling) {
        this.sibling = sibling;
    }

    public BinomialHeapNode getChild() {
        return child;
    }

    public void setChild(BinomialHeapNode child) {
        this.child = child;
    }

    public BinomialHeapNode findANodeWithKey(int value) {
       BinomialHeapNode curr = this;
       BinomialHeapNode result = null;

       while(curr != null) {
           if(curr.getData() == value) { //if matches with same node , return
               result = curr;
               break;
           } else {
               // check for child, if yes recur for child. If not found, make siblingRight as curr
               if(curr.getChild() != null) {
                   result = curr.getChild().findANodeWithKey(value);
                   if(result == null) {
                       curr = curr.getSibling();
                   } else {
                       break;
                   }
               } else { // if child is null, make siblingRight as curr
                   curr = curr.getSibling();
               }
           }
       }
       return result;
    }

    public BinomialHeapNode findMinNode() {
        BinomialHeapNode curr = this;
        int min = Integer.MAX_VALUE;
        BinomialHeapNode resultNode = null;
        while(curr != null) {
            if(curr.getData() < min) {
                min = curr.getData();
                resultNode = curr;
            }
            curr = curr.getSibling();
        }
        return resultNode;
    }

    public int getSize() {
        BinomialHeapNode curr = this;
        // get Child's size and gt siblingRight's size and add 1
        int childSize = curr.getChild() == null ? 0 : curr.getChild().getSize();
        int siblingSize = curr.getSibling() == null ? 0 : curr.getSibling().getSize();

        return 1 + childSize + siblingSize;
    }
}
