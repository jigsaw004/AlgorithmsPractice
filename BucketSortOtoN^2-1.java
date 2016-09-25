import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solution{
	
	public static void main(String args[]){
		int[] arr = {17,5,8,1,12,10,9};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void sort(int[] arr){
		int[][] hs = new int[arr.length][];
		int[] count = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			int bucket = (arr[i]/arr.length);
			if(hs[bucket] == null){
				hs[bucket] = new int[arr.length];
				Arrays.fill(hs[bucket], -1);
			}
			hs[bucket][count[bucket]++] = arr[i];
		}
		for(int i = 0; i < arr.length; i++){
			if(hs[i] != null){
				Arrays.sort(hs[i]);
			}
		}
		int c = 0;
		for(int i = 0; i < arr.length; i++){
			if(hs[i] != null){
				for(int j = 0; j < arr.length; j++){
					if(hs[i][j] != -1){
						arr[c++] = hs[i][j];
					}
				}
			}
		}
	}
	
}
