package DPI;

public class KSum {
	
	public int kSum(int A[], int k, int target){
		int n = A.length;
		int[][][] f = new int[n+1][k+1][target+1];
		
		
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= k && j <= i; j++){
				for(int t = 1; t <= target; t++){
					f[i][j][t] = 0;
					if( t >= A[i- 1]){
						f[i][j][t] = f[i - 1][j - 1][t - A[i-1]];
					}
					f[i][j][t] = f[i-1][j][t];
					
				}
			}
		}
		return f[n][k][target];
	}
}
