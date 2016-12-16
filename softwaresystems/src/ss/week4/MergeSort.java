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
    		
    		List<Elem> left;
        	List<Elem> right;
    		
    		if (list.size() == 2) {
    			left = list.subList(0, 1);
    			right = list.subList(1, 2);
    		} else {
    			left = list.subList(0, mid);
    			right = list.subList(mid, high);
    		}
    		//System.out.println("Left: " + left + "\nRight: " + right + "\n");
    		left = mergeSort(left);
    		right = mergeSort(right);	
            
            return merge(left, right, new ArrayList<Elem>());
    	}
    	return list;
	}
	public static <Elem extends Comparable<Elem>> List<Elem> merge(List<Elem> left, List<Elem> right, List<Elem> list) {
		int leftIndex = 0;
		int rightIndex = 0;
		//int listIndex = 0;
		System.out.println("Left: " + left + "\nRight: " + right);
		while (leftIndex < left.size() && rightIndex < right.size()) {
			if (left.get(leftIndex).compareTo(right.get(rightIndex)) <= 0) {
				list.add(left.get(leftIndex++));
			} else {
				list.add(right.get(rightIndex++));
			}
		}
		
		if (leftIndex < left.size()) {
			for (int i = leftIndex; i < left.size(); i++) {
				list.add(left.get(i));
			}
		} else {
			for (int i = rightIndex; i < right.size(); i++) {
				list.add(right.get(i));
			}
		}
		System.out.println("List: " + list + "\n");
		return list;
		
	}
}