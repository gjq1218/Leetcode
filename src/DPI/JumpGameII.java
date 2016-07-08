package DPI;
/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Have you met this question in a real interview? Yes
Example
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)


 * @author SirusBlack
 *
 */
public class JumpGameII {
	 public int jump(int[] A) {
	     int[] steps = new int[A.length];
	     steps[0] = 0;
	     
	     for(int i = 1; i < A.length; i++){
	    	 steps[i] = Integer.MAX_VALUE;
	    	 for(int j = 0; j < i; j++){
	    		 if(j + A[j] >= i){
	    			 steps[i] = Math.min(steps[i], steps[j] + 1);
	    		 }
	    	 }
	     }
	     
	     return steps[A.length - 1];
	     
	     
	 }
}
