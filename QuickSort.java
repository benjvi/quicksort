package com.benjvi.quicksort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveAction;

public class QuickSort<T extends Comparable<T>> extends RecursiveAction {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private T[] list;
    private int high;
    private int low;
    
	QuickSort(T[] t, int low, int high) {
		this.list = t;
		this.high = high;
		this.low = low;
	}
	
	QuickSort(T[] t) {
		this(t, 0, t.length-1);
	}
	
	@Override
	protected void compute() {
		System.out.println("Computing quicksort");
		System.out.println("low: "+low);
		System.out.println("high: "+high);
		System.out.println("list: "+Arrays.toString(list));
		int i = low, j = high;
	    // Get the pivot element from the middle of the list
	    T pivot = list[low + (high-low)/2];

	    // Divide into two lists
	    while (i <= j) {
	      // If the current value from the left list is smaller then the pivot
	      // element then get the next element from the left list
	      while (list[i].compareTo(pivot)==-1) {
	        i++;
	        System.out.println(i);
	      }
	      // If the current value from the right list is larger then the pivot
	      // element then get the next element from the right list
	      while (list[j].compareTo(pivot)==1) {
	        j--;
	        System.out.println(j);
	      }

	      // If we have found a values in the left list which is larger then
	      // the pivot element and if we have found a value in the right list
	      // which is smaller then the pivot element then we exchange the
	      // values.
	      // As we are done we can increase i and j
	      if (i < j) {
	        exchange(i, j);
	        QuickSort l = new QuickSort(list, low, j);
	    	QuickSort r = new QuickSort(list, i, high);
	    	invokeAll(l, r);
	        i++;
	        j--;
	      }
	    }

	}

	  private void exchange(int i, int j) {
		    T temp = list[i];
		    list[i] = list[j];
		    list[j] = temp;
	  }
}
