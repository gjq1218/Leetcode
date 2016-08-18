package DPI;

public class CoinsInALineII {
	 public boolean firstWillWin(int[] values) {
	        if(values == null || values.length == 0){
	            return false;
	        }
	        
	        int n = values.length;
	        int[] dp = new int[n + 1];
	        boolean[] flag = new boolean[n + 1];
	        int[] sum = new int[n + 1];
	        
	        sum[n] = values[n-1];
	        
	        //倒着求sum的前i项和
	        for(int i = n - 1; i >= 1; i--){
	            sum[i] += sum[i + 1] + values[i-1];
	        }
	        
	        return sum[n]/2 <  MemoerySearch(n, dp, flag, values, sum);
	    }
	    
	    public int MemoerySearch(int n, int[] dp, boolean[] flag, int[] values, int[] sum){
	        if(flag[n] == true){
	            return dp[n];
	        }
	        
	        flag[n] = true;
	        
	        if(n == 0){
	            dp[n] = 0;
	        }else if(n == 1){
	            dp[n] = values[n - 1];
	        }else if(n == 2){
	            dp[n] = values[n - 1] + values[n - 2];
	        }else{
	            dp[n] = sum[n] - 
	            Math.min(MemoerySearch(n-1, dp, flag, values, sum), MemoerySearch(n-2, dp, flag, values, sum));
	        }
	        
	        return dp[n];
	        
	    }
	    
	    public static void main(String args[]){
	    	CoinsInALineII test = new CoinsInALineII();
	    	int[] values = {1,2,2};
	    	boolean res = test.firstWillWin(values);
	    	System.out.println(res);
	    }
	    
}
