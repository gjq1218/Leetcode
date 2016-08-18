package DPI;

public class BackPackII {
	public int backPackII(int m, int[] A, int V[]){
		int[][] dp = new int[A.length][m+1];
		for(int  i = 0; i <= A.length; i++){
			for(int j = 0; j <= m; j++){
				if(i == 0 || j == 0){
					dp[i][j] = 0;
				}else if(A[i - 1] > j){
					dp[i][j] = dp[i-1][j];
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - A[i-1]] + V[i-1]);
				}
				
			}
		}
		return dp[A.length][m];
	}
}
