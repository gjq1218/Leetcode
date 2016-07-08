package DPI;
/**
 * Given two strings, find the longest common substring.

Return the length of it.

The characters in substring should occur continuously in original string. This is different with subsequence.
Example
Given A = "ABCD", B = "CBCE", return 2.

 * @author SirusBlack
 *
 */
public class LongestCommonSubstring {
	// f[i][j] 表示前i字符配上前j个字符的LCS的长度。
	
	 public int longestCommonSubstring(String A, String B) {
		 if(A.length() == 0 || B.length() == 0){
			 return 0;
		 }
		 
		 int n = A.length();
		 int m = B.length();
		 
		 int[][] f = new int[n + 1][m + 1];
		 for(int i = 0; i <= n; i++){
			 f[i][0] = 0;
		 }
		 
		 for(int j = 0; j <= m; j++){
			 f[0][j] = 0;
		 }
		 
		 int max = 0;
		 for(int i = 1; i <= n; i++){
			 for(int j = 1; j <= m; j++){
				 if(A.charAt(i - 1) == B.charAt(j - 1)){
					 f[i][j] = f[i - 1][j - 1] + 1;
					 max = Math.max(max, f[i][j]);
				 }else{
					 f[i][j] = 0;
				 }
			 }
		 }
		 return max;
 
	 }
}
