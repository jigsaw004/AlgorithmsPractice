//Geeks For Geeks - Find minimum unsorted array in an array sorting which would make the array sorted.
import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class GFG {
	public static void main (String[] args) throws IOException{
		//code
		Reader.init(System.in);
		int T = Reader.nextInt();
		while(T-->0){
		    int max = Integer.MIN_VALUE;
		    int min = Integer.MAX_VALUE;
		    int N = Reader.nextInt();
		    int[] arr = new int[N];
		    for(int i = 0 ; i < N; i++){
		        arr[i] = Reader.nextInt();
		    }
		    int start = 0, end = N-1;
		    for(int i = 0; i < N; i++){
		        max = max(arr[i], max);
		        if(arr[i] != max) end = i;
		    }
		    for(int i = end; i>=0 ; i--){
		        min = min(arr[i], min);
		        if(arr[i] != min) start = i;
		    }
		    System.out.println(start+" "+end);
		}
	}
	public static int max(int a, int b){
	    return (a > b ? a : b);
	}
	public static int min(int a, int b){
	    return (a > b ? b : a);
	}
}
//Custom Reader
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
