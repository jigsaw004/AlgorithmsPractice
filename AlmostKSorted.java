package com.bhatt.codechef;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AlmostKSorted{
	
	public static void main(String args[]){
		int[] arr = {17, 5, 18, 1, 4, 5};
		System.out.println(Arrays.toString(sort(arr, 4)));
	}
	public static int[] sort(int[] arr, int k){
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
		int[] result = new int[arr.length];
		int count = 0;
		
		for(int i = 0; i < arr.length; i++){
			pq.add(arr[i]);
			if(pq.size() == k){
				result[count++] = pq.peek();
				pq.remove();
			}
		}
		while(!pq.isEmpty()){
			result[count++]=pq.peek();
			pq.remove();
		}
		return result;
	}
	
}
