package DPI;
/**
 * You are climbing a stair case. It takes n steps to reach to the top.

	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	
	Have you met this question in a real interview? Yes
	Example
	Given an example n=3 , 1+1+1=2+1=1+2=3
	
	return 3
 * @author SirusBlack
 *
 */
public class ClimbingStairs {
/**
 * @param n: An integer
 * @return: An integer
 */
	  public int climbStairs(int n) {
		  
		 if(n <= 2){
			 return n;
		 } 
		 int[] sum = new int[n];
		 sum[0] = 1;
		 sum[1] = 2;
		 for(int i = 2; i < n; i++){
			 sum[i] = sum[i - 1] + sum[i - 2];
		 }		 
		 return sum[n - 1];
	  }
}
