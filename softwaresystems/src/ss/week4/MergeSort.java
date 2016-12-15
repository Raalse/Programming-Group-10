package ss.week4;

import java.util.*;

public class MergeSort {
    
	public static <Elem extends Comparable<Elem>> void mergesort(List<Elem> list) {
		if (list.size() > 1) {
	    	List<Elem> temp = mergeSort(list);
	    	list.clear();
	    	list.addAll(temp);
		}
    }
	
	public static <Elem extends Comparable<Elem>> List<Elem> mergeSort(List<Elem> list) {
    	if (list.size() > 1) {
    		int mid = list.size() / 2;
    		int high = list.size();
    		
			List<Elem> left = list.subList(0, 1);
        	List<Elem> right = list.subList(0, 1);	
        	
        	if (list.size() == 2) {
        		left.set(0, list.get(0));
        		right.set(0, list.get(1));
        	} else {
        		left = list.subList(0, mid);
            	right = list.subList(mid + 1, high);	
        	}
    		
    		/*
    		List<Elem> left = list.subList(0, 1);
        	List<Elem> right = list.subList(0, 1);	
    		
            // copy the left half of list into the left.
            for (int i = 0; i < mid; i++) {
            	left.add(list.get(i));
            }
     
            //copy the right half of list into the right.
            for (int i = mid; i < list.size(); i++) {
            	right.add(list.get(i));
            }
            */
            
    		left  = mergeSort(left);
            right = mergeSort(right);	
            
            return merge(left, right, list);
    	}
    	return list;
	}
	public static <Elem extends Comparable<Elem>> List<Elem> merge(List<Elem> left, List<Elem> right, List<Elem> list) {
		int leftIndex = 0;
		int rightIndex = 0;
		int listIndex = 0;
		
		while (leftIndex < left.size() && rightIndex < right.size()) {
			if (left.get(leftIndex).compareTo(right.get(rightIndex)) <= 0) {
				list.set(listIndex++, left.get(leftIndex++));
			} else {
				list.set(listIndex++, right.get(rightIndex++));
			}
		}
		
		if (leftIndex < left.size()) {
			for (int i = leftIndex; i < left.size(); i++) {
				list.set(listIndex++, left.get(i));
			}
		} else {
			for (int i = rightIndex; i < right.size(); i++) {
				list.set(listIndex++, right.get(i));
			}
		}
		return list;
		
	}
}