//Good Question
//https://www.interviewbit.com/problems/find-duplicate-in-array/
//Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.
public class Solution {
	// DO NOT MODIFY THE LIST
	public int repeatedNumber(final List<Integer> a) {
	    int size = a.size();
	    
	    int r = (int)Math.sqrt(size);
	    int b = ((size-1)/r);
	    
	    int[][] arr = new int[r+1][];
	    int counts[] = new int[r+1];
	    
	    for(Integer i : a){
	        int pos = i%b == 0 ? (i/b - 1) : (i/b);
	        if(arr[pos] == null){
	            arr[pos] = new int[r+1];
	        }
	        for(int j = 0; j < counts[pos]; j++){
	            if(i == arr[pos][j]) return i;
	        }
	            arr[pos][counts[pos]++] = i;
	    }
	    return -1;
	}
}
