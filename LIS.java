//http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Arrays;

class GFG {
	public static void main (String[] args) throws IOException{
		Reader.init(System.in);
		int T = Reader.nextInt();
		while(T-->0){
		    int N = Reader.nextInt();
		    int[] arr = new int[N];
		    for(int i = 0; i < N; i++){
		        arr[i] = Reader.nextInt();
		    }
		    System.out.println(LIS(arr,N));
		}
	}
	public static int LIS(int[] arr, int N){
	    int[] memo = new int[N];
	    Arrays.fill(memo, 1);
	    for(int i = 1; i < N; i++){
	        for(int j = i-1; j >= 0; j--){
	            if(arr[i] > arr[j]){
	                memo[i] = max(1+memo[j], memo[i]);
	            }
	        }
	    }
	    int max = Integer.MIN_VALUE;
	    for(int i = 0; i < N; i++){
	        max = max(memo[i], max);
	    }
	    return max;
	}
	public static int max(int a, int b){
	    return a > b ? a : b;
	}
}
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
 
    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }
 
    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        } 
        return tokenizer.nextToken();
    }
 
    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    
    static long nextLong() throws IOException{
    	return Long.parseLong( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }   
} 
