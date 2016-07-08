package DPI;
/**
 * Given two strings, find the longest common substring.

Return the length of it.

 Notice

The characters in substring should occur continuously in original string. This is different with subsequence.

Have you met this question in a real interview? Yes
Example
Given A = "ABCD", B = "CBCE", return 2.

 * @author SirusBlack
 *
 */
public class LongestCommonSubsequence {
	 /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
    	
    	if(A.length() == 0 || B.length() == 0){
    		return 0;
    	}
    	int n = A.length();
    	int m = B.length();
    	
    	int[][] f = new int[n + 1][m + 1];
    	
    	for(int i = 0; i < n; i++){
    		f[i][0] = 0;
    	}
    	for(int j = 0; j < m; j++){
    		f[0][j] = 0;
    	}
    	
    	
    	for(int i = 1; i <= n; i++){
    		for(int j = 1; j <= m; j++){
    			if(A.charAt(i) == B.charAt(j)){
    				f[i][j] = Math.max( Math.max(f[i- 1][j], f[i][j - 1]),f[i - 1][j - 1] + 1);
    			}else{
    				f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
    			}
    		}
    	}
    	
    	return f[n][m];
    }
}
