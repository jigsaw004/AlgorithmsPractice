//http://www.geeksforgeeks.org/search-almost-sorted-array/
//The crux of the solution lies in the fact that only one of the following three can occur
// 1. previous element is greater than the current element
// 2. current element is greater than the next element
// 3. current element is greater than the previous element
// no two of the above can happen simultaneously
// if 1, then the current element is sitting where the previous element should have been if the array was sorted.
// so, the candidate array for checking for existence of val, following the logic of binary search is from the position
// of the current element to the last. Otherwise from beginning to this position

public class Solution{
	
	public static void main(String args[]){
		int[] arr = {1, 12, 22, 32, 33, 40, 45};
		System.out.println(binarySearchModified(arr, 0, arr.length-1, 2));
	}
	public static int binarySearchModified(int[] arr, int b, int e, int val){
		if(b > e) return -1;
		int mid = (b + e) >> 1;
		if(arr[mid] == val) return mid;
		
		int begin, end;
		
		if(mid > 0 && arr[mid] < arr[mid-1]){
			if(arr[mid-1] < val){
				begin = mid;
				end = e;
			}
			else {
				begin = b;
				end = mid;
			}
		}
		else if(mid < arr.length-1 && arr[mid] > arr[mid+1]){
			if(arr[mid+1] < val){
				begin = mid;
				end = e;
			}
			else {
				begin = b;
				end = mid;
			}
		}
		else{
			if(arr[mid] < val) {
				begin = mid+1;
				end = e;
			}
			else{
				begin = b;
				end = mid-1;
			}
		}
		return binarySearchModified(arr,begin,end,val);
	}
	
}
