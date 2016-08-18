package DPI;

public class CoinsInALineIII {
	public boolean firstWillWin(int[] values){
		int n = values.length;
		int[][] dp = new int[n+1][n+1];
		int[][] sum = new int[n+1][n+1];
		boolean[][] flag = new boolean[n+1][n+1];
 		for(int i = 0; i < n; i++){
			for(int j = i; j < n; j++){
				sum[i][j] = i == j ? values[j]: sum[i][j-1] + values[j];
			}	
		}
		int allsum = 0;
		for(int now: values){
			allsum += now;

		}
		
		return allsum < 2 * MemorySearch(0, values.length - 1, dp, flag, values, sum);
	
	}
	
	public int MemorySearch(int left, int right, int[][] dp, boolean[][] flag, int[] values, int[][] sum){
		if(flag[left][right]){
			return dp[left][right];
		}
		
		flag[left][right] = true;
		if(left > right){
			dp[left][right] = 0;
		}else if(left == right){
			dp[left][right] = values[left];
		}else if(left + 1 == right){
			dp[left][right] = Math.max(values[left], values[right]);
		}else{
			int cur = Math.min(MemorySearch(left + 1,  right, dp, flag, values, sum),MemorySearch(left, right - 1, dp, flag, values, sum));
			dp[left][right] = sum[left][right] - cur;
		}
		return dp[left][right];
		 
         
	}
}
