import java.util.Arrays;
import java.util.Stack;

public class Solution{
	
	public static void main(String args[]){
		int[] arr = {1,2,1,1,1};
		QuickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	public static void QuickSort(int[] arr, int low, int high){
		Stack<Integer> st = new Stack<Integer>();
		st.push(low);
		st.push(high);
		int l,h;
		while(!st.isEmpty()){
			h = st.pop();
			l = st.pop();
			if(l < h){	
				int p = partition(arr,l,h);
				st.push(l); st.push(p-1);
				st.push(p+1); st.push(h);
			}
		}
	}
	
	public static int partition(int[] arr, int low, int pivot){
		int i = low-1;
	    for(int j = low; j < pivot; j++){
	    	if(arr[j] < arr[pivot]){
	    		i++;
	    		swap(arr,i,j);
	    	}
	    }
	    swap(arr,++i,pivot);
	    return i;
	}
	
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
