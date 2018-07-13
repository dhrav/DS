package LL;

/**
 * Created by IntelliJ IDEA.
 * User: sbalaguruna
 * Date: 11/22/2017
 * Time: 3:26 PM
 */
public class AddOne {

    Node head;
     Node result;

    int carryOver = 0;
        int sum = 0, units = 0;

     static class Node
     {
         int data;
         Node next;

         Node(int d)
         {
             data = d;
             next = null;
         }
     }

     void printlist(Node head)
     {
         Node node = head;
         while (node != null)
         {
             System.out.print(node.data + " ");
             node = node.next;
         }
     }
        private void pushToResult(int data)
        {
            Node n = new Node(data);
            if(result == null)
            {
                result = n;
            }
            else
            {
                n.next = result;
                result = n;
            }

        }
    	public void addOne(Node head){
                if(head.next == null)
               {
                  sum = head.data + 1;
                  units = sum % 10;
                  carryOver = sum / 10;
                  pushToResult(units);
               }
               else
               {
                   addOne(head.next);
                   sum = head.data + carryOver;
                   units = sum % 10;
                   carryOver = sum / 10;
                   pushToResult(units);
               }
             }





     public static void main(String[] args)
     {
         AddOne list = new AddOne();

         list.head = new Node(9);
         list.head.next = new Node(9);
         list.head.next.next = new Node(9);
         list.head.next.next.next = new Node(9);
         list.head.next.next.next.next = new Node(9);
         System.out.println("List before change :");
         list.printlist(list.head);
         list.addOne(list.head);
         list.propagateCarry();
         System.out.println("");
         System.out.println("List after change :");
         list.printlist(list.result);
     }

    private void propagateCarry() {

        if(carryOver > 0 && carryOver < 10)
        {
            pushToResult(carryOver);
        }

    }
}

