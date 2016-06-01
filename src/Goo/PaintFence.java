package Goo;
/**
 * There is a fence with n posts, each post can be painted with one of the k colors.

	You have to paint all the posts such that no more than two adjacent fence posts have the same color.
	
	Return the total number of ways you can paint the fence.
	state: F[i] represents with n posts, the ways to paint the fence.
	function: dp[i] = dp[i-1] * (k-1) + dp[i-2]* (k-1) * 1
	Initialize: dp[0] = k, dp[1] = k*(k-1) + k;
	Answer: dp[n]

	
	http://www.phperz.com/article/16/0101/178949.html
 * @author ginagao
 *
 */
public class PaintFence {
	// It's a tipical DP problem. Thinking about the 4 essentials of DP.
	
	 public int numWays(int n, int k) {
		 if(n == 0) return 0;
		 if(n == 1 ) return k;
		 int[] dp = new int[n];
		 dp[0] = k;
		 dp[1] = k * (k-1) + k;
		 for(int i = 2; i < n; i++){
			 dp[i] = dp[i-1]*(k-1) + dp[i-2]*(k-1)*1;
		 }
		 return dp[n-1];
			
	 }
	  // if it's no more than 3 adjancent fence posts have the same color, then the fuction will become:
	  //  dp[i] = dp[i-1]*(k-1) + dp[i-2]*(k-1)*1 + dp[i-3]*(k-1)*1*1;
}
