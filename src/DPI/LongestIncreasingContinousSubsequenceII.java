package DPI;

public class LongestIncreasingContinousSubsequenceII {
	 /**
     * @param A an integer matrix
     * @return  an integer
     */
     
    int n;
    int m;
    int[][] visited; 
    int[][] dp;
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        n =  A.length;
        m = A[0].length;
        int ans = 0;
        
        dp = new int[n][m];
        visited = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                dp[i][j] = search(i,j,A);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        
        return ans;
    }
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0,  1, -1};
    
    public int search(int x, int y, int[][]A){
        
        //表示已经遍历过
        
        if(visited[x][y] != 0){
            return dp[x][y] ;
        }
        
        int ans = 1;
        int nx, ny;
        
        // 表示正要去遍历它
        visited[x][y] = -1;
        for(int  i = 0; i < 4; i++){
            nx = x + dx[i];
            ny = y + dy[i];
            if(0 <= nx && nx < n && 0 <= ny && ny < m){
                if(A[x][y] > A[nx][ny]){
                    ans = Math.max(ans, search(nx, ny, A) + 1);
                }
            }
        }
        
        visited[x][y] = 1;
        dp[x][y] = ans;
        return ans;
    }
    
    public static void main(String args[]){
    	LongestIncreasingContinousSubsequenceII test = new LongestIncreasingContinousSubsequenceII();
    	int[][] A = {
    	             {1 ,2 ,3 ,4 ,5},
    	             {16,17,24,23,6},
    	             {15,18,25,22,7},
    	             {14,19,20,21,8},
    	             {13,12,11,10,9}
    	             };

    	int res = test.longestIncreasingContinuousSubsequenceII(A);
    }
    
}
