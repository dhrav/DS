package LL;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: sbalaguruna
 * Date: 11/24/2017
 * Time: 9:28 PM
 */
public class AlternateSort {

    	// Function to rearrange a given list such that it
    	// consists of alternating minimum maximum elements
    	// using LinkedList
    	public static void alternateSort(LinkedList<Integer> ll)
    	{
    		Collections.sort(ll);

    		for (int i = 1; i < (ll.size() + 1)/2; i++)
    		{
    			Integer x = ll.getLast();
    			ll.removeLast();
    			ll.add(2*i - 1, x);
    		}

    		System.out.println(ll);
    	}

       private static void doMinMaxSort(LinkedList<Integer> ll)
       {
           Collections.sort(ll);
           System.out.println("Before sort minmax:");
           System.out.println(ll);
           for(int i = 0; i <( (ll.size()/2)); i++)
           {
               int element = ll.removeLast();
               ll.add((2* i) + 1, element);
           }
           System.out.println("After sort:");
           System.out.println(ll);
       }

    	public static void main (String[] args) throws java.lang.Exception
    	{
    		// input list
    		//Integer arr[] = {1, 3, 8, 2, 7, 5, 6, 4};
    		//Integer arr[] = {1, 2, 3, 4, 5, 6, 7};
    		Integer arr[] = {1, 6, 2, 5, 3, 4};

    		// convert array to LinkedList
    		LinkedList<Integer> ll = new LinkedList<>(Arrays.asList(arr));

    		// rearrange the given list
    		//alternateSort(ll);
            doMinMaxSort(ll);
    	}




}
