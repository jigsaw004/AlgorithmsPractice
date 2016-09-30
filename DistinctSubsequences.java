//https://leetcode.com/problems/distinct-subsequences/
public class Solution {
    int[][] memo;
    public int numDistinct(String s, String t) {
        if(s.isEmpty() || t.isEmpty()) return 0;
        memo = new int[t.length()][s.length()];
        memo[0][0] = s.charAt(0) == t.charAt(0) ? 1 : 0;
        for(int j = 1; j < s.length(); j++){
            memo[0][j] = memo[0][j-1] + (s.charAt(j) == t.charAt(0) ? 1 : 0);
        }
        for(int i = 1; i < t.length(); i++){
            for(int j = 0; j < s.length(); j++){
                if(i > j){
                    memo[i][j] = 0;
                    continue;
                }
                if(t.charAt(i) == s.charAt(j)){
                    memo[i][j] = memo[i][j-1]+ memo[i-1][j-1];
                }
                else{
                    memo[i][j] = memo[i][j-1];
                }
            }
        }
        
        return memo[t.length()-1][s.length()-1];
    }
}
