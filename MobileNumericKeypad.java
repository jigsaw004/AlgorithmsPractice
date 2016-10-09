//http://www.geeksforgeeks.org/mobile-numeric-keypad-problem/

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[][] memo = new int[11][10];
		
		for(int i = 0; i < memo.length; i++){
		    Arrays.fill(memo[i], -1);
		}
		
		int n = 5;
		int count = 0;
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(Arrays.asList(0,8));
		list.add(Arrays.asList(1,2,4));
		list.add(Arrays.asList(2,1,3,5));
		list.add(Arrays.asList(3,2,6));
		list.add(Arrays.asList(4,1,5,7));
		list.add(Arrays.asList(5,2,4,6,8));
		list.add(Arrays.asList(6,3,5,9));
		list.add(Arrays.asList(7,4,8));
		list.add(Arrays.asList(8,5,7,9,0));
		list.add(Arrays.asList(9,6,8));
		
		for(int i = 0; i < 10; i++){
		    count += solve(n,i,memo,list);
		}
		
		System.out.println(count);
	}
	
	public static int solve(int n, int digit, int[][] memo, List<List<Integer>> list){
	    if(memo[n][digit] != -1) return memo[n][digit];
	    
	    if(n <= 1){
	        memo[n][digit] = 1;
	        return memo[n][digit];
	    }
	    
	    int count = 0;
	    for(Integer i : list.get(digit)){
	        count += solve(n-1,i,memo,list);
	    }
	    
	    memo[n][digit] = count;
	    return memo[n][digit];
	    
	}
}
