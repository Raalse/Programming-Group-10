package ss.week4;

import java.util.*;

public class MergeSort2 {
    
	public static <Elem extends Comparable<Elem>> void mergesort(List<Elem> list) {
		if (list.size() > 1) {
	    	List<Elem> temp = mergeSort(list);
	    	list.clear();
	    	list.addAll(temp);
		}
    }
	
	public static <Elem extends Comparable<Elem>> List<Elem> mergeSort(List<Elem> list) {
		if (list.size() == 1) {
			return list;
		}
		
		int low = 0;
		int high = list.size();
		int mid = high / 2;
		
		List<Elem> left = list.subList(0, 0);
    	List<Elem> right = list.subList(0, 0);
		
		if (list.size() == 2) {
			left = list.subList(0, 1);
			right = list.subList(1, 2);
		} else {
			left = list.subList(low, mid);
			right = list.subList(mid + 1, high);
		}
		
		left = mergeSort(left);
		right = mergeSort(right);
		
		return merge(left, right, list.subList(0, 0));
	}
	
	public static <Elem extends Comparable<Elem>> List<Elem> merge(List<Elem> left, List<Elem> right, List<Elem> list) {
		int leftIndex = 0;
		int rightIndex = 0;
		
		while (leftIndex < left.size() && rightIndex < right.size()) {
			if (left.get(leftIndex).compareTo(right.get(rightIndex)) <= 0) {
				list.add(left.get(leftIndex++));
			} else {
				list.add(right.get(rightIndex++));
			}
		}
		
		while (leftIndex < left.size()) {
			list.add(left.get(leftIndex++));
		}
		while (rightIndex < right.size()) {
			list.add(right.get(rightIndex++));
		}
		
		return list;
	}
	
}