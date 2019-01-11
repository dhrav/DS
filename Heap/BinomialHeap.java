package Heap;

public class BinomialHeap {
    BinomialHeapNode root;
    int size;

    public void delete(int value) {
        if(root != null && root.findANodeWithKey(value) != null) {
            decreaseKeyValue(value, Integer.MIN_VALUE);
            extractMin();
        }
    }

    public int getSize() {
        return size;
    }

    private int extractMin() {
        //check if root is null
        if(root == null) {
            return -1;
        }

        BinomialHeapNode curr = root;
        BinomialHeapNode prev = null;

        BinomialHeapNode minNode = root.findMinNode();
        //navigate to minNode
        while(curr.getData() != minNode.getData()) {
            prev = curr;
            curr = curr.getSibling();
        }

        //remove the minNode from the list
        if(prev == null) {
            root = root.getSibling();
        } else {
            prev.setSibling(curr.getSibling());
        }

        //process the minNode tree
        //ignore minNode and consider its child
        curr  = curr.getChild();
        BinomialHeapNode temp = curr;

        //reverse the order of the child and make a new heap
        BinomialHeapNode newHead = null;
        BinomialHeapNode next = null;

        //reverse a list logic
        while(temp != null) {
            temp.setParent(null);
            next = temp.getSibling();
            temp.setSibling(newHead);
            newHead = temp;
            temp = next;
        }
        //and do union with main heap
        unionNodes(newHead);

        //update the size of the new heap combined
        if(root == null) {
            size = 0;
        } else {
            size = root.getSize();
        }

        //return the minNode value
        return minNode.getData();
    }

    private void decreaseKeyValue(int value, int minValue) {
        BinomialHeapNode minNode = root.findANodeWithKey(value);
        if(minNode == null) {
            return;
        }
        minNode.setData(minValue);
        BinomialHeapNode parent = minNode.getParent();

        //bubble up the min Node value
        while(parent != null && parent.getData() > minNode.getData()) {
            // swap data of minNode and parent
            int temp = parent.getData();
            parent.setData(minNode.getData());
            minNode.setData(temp);

            // continue upwards
            minNode = parent;
            parent = parent.getParent();
        }
    }

    public void insert(int newElement) {
        if(newElement > 0) {
            BinomialHeapNode newNode = new BinomialHeapNode(newElement);
            if(root == null) {
                root = newNode;
                size = 1;
            } else {
                unionNodes(newNode);
                size++;
            }
        }
    }

    private void unionNodes(BinomialHeapNode newNode) {

        if(newNode == null) {
            return;
        }

        merge(newNode);

        //make sure there is only one binomial tree of a specific order
        BinomialHeapNode prev = null;
        BinomialHeapNode curr = root;
        BinomialHeapNode next = root.getSibling();

        while(next != null) {
            //if curr and next degree are not same or curr and next's next is of same degree, then move ahead
            if((curr.getDegree() != next.getDegree()) || (curr.getDegree() == next.getSibling().getDegree())) {
                prev = curr;
                curr = next;
            } else {
                if(curr.getDegree() <= next.getDegree()) {

                    //make the next as child of curr
                    //change the following - next's siblingRight becomes curr's siblingRight
                    //next's parent becomes curr
                    //next's siblingRight becomes curr's child
                    //curr's child becomes next
                    //increase the degree of curr
                    curr.setSibling(next.getSibling());
                    next.setParent(curr);
                    next.setSibling(curr.getChild());
                    curr.setChild(next);
                    curr.setDegree(curr.getDegree() + 1);
                } else {
                    //make the curr as child of next

                    if(prev == null) { // adjust root if curr is first node
                        root = next;
                    } else {
                        prev.setSibling(next);
                    }

                    curr.setSibling(next.getChild());
                    curr.setParent(next);
                    next.setChild(curr);
                    next.setDegree(next.getDegree() + 1);
                    curr = next;
                }
            }
            next = curr.getSibling();
        }
    }

    /*
     * Merges the new Node to a binomial heap */

    private void merge(BinomialHeapNode newNode) {

        BinomialHeapNode first = root;
        BinomialHeapNode second = newNode;

        while(first != null && second != null) {
            if(first.getDegree() == second.getDegree()) {
                //merge the current second to first's list
                BinomialHeapNode temp = second;
                second = second.getSibling();
                temp.setSibling(first.getSibling());
                first.setSibling(temp);
                first = first.getSibling();
            } else {
                if(first.getDegree() < second.getDegree()) {
                    //if no siblingRight or first's next if of higher degree than current second
                    if(first.getSibling() == null || first.getSibling().getDegree() > second.getDegree()) {
                        //merge the current second to first's list
                        BinomialHeapNode temp = second;
                        second = second.getSibling();
                        temp.setSibling(first.getSibling());
                        first.setSibling(temp);
                        first = first.getSibling();
                    } else {
                        first = first.getSibling();
                    }
                } else {
                    //if second's degree is less, add it to first's list
                    BinomialHeapNode temp = first;
                    first = second;
                    second = second.getSibling();
                    first.setSibling(temp);
                    if(root == temp) {
                        temp = first;
                    }
                }
            }
        }

        if(first == null) {

            //if one of the list becomes empty, then merge both into one
            first = root;
            while(first.getSibling() != null) {
                first = first.getSibling();
            }
            first.setSibling(second);
        }
    }

    public void displayHeap() {
        if( root == null) {
            System.out.println("The heap is empty\n");
            return;
        }
        System.out.println("\nThe heap values are :");
        displayHeap(root);
        System.out.println("\n");
    }

    public void displayHeap(BinomialHeapNode root) {
        if(root != null) {
            //print data
            System.out.println(root.getData());
            //recur for child
            displayHeap(root.getChild());
            //recur for siblingRight
            displayHeap(root.getSibling());
        }
    }


}
