//http://www.practice.geeksforgeeks.org/problem-page.php?pid=152
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		Reader.init(System.in);
		int T = Reader.nextInt();
		while(T-->0){
		    int A = Reader.nextInt();
		    int B = Reader.nextInt();
		    String str1 = Reader.next();
		    String str2 = Reader.next();
		    System.out.println(LCS(str1, str2, A, B));
		}
	}
	public static int LCS(String s1, String s2, int A, int B){
	    if(s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) return 0;
	    int[][] memo = new int[A][B];
	    memo[0][0] = s1.charAt(0) == s2.charAt(0) ? 1 : 0;
	    for(int i = 0; i < A; i++){
	        for(int j = 0; j < B; j++){
	            if(s1.charAt(i) == s2.charAt(j)){
	                if(i > 0 && j > 0){
	                    memo[i][j] = 1+memo[i-1][j-1];
	                }
	                else if(i == 0 && j > 0){
	                    memo[i][j] = 1;
	                }
	                else if(i > 0 && j == 0){
	                    memo[i][j] = 1;
	                }
	            }
	            else{
	                if(i > 0 && j > 0){
	                    memo[i][j] = max(memo[i-1][j], memo[i][j-1]);
	                }
	                else if(i == 0 && j > 0){
	                    memo[i][j] = memo[i][j-1];
	                }
	                else if(i > 0 && j == 0){
	                    memo[i][j] = memo[i-1][j];
	                }
	            }
	        }
	    }
	    return memo[A-1][B-1];
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
