package DPI;
/**
 * Given a sequence of integers, find the longest increasing subsequence (LIS).

	You code should return the length of the LIS.
	
	Have you met this question in a real interview? Yes
	Clarification
	What's the definition of longest increasing subsequence?
	
	The longest increasing subsequence problem is to find a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.
	
	https://en.wikipedia.org/wiki/Longest_increasing_subsequence
	
	Example
	For `[5, 4, 1, 2, 3]`, the LIS is [1, 2, 3], return `3`
	
	For `[4, 2, 4, 5, 3, 7]`, the LIS is `[2, 4, 5, 7]`, return `4`
 * @author SirusBlack
 *
 */
public class LongestIncreasingSubsequence {
	 /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
	//O(n^2)
    public int longestIncreasingSubsequence(int[] nums) {
    	
    	int[] steps = new int[nums.length];
    	
    	for(int i = 0; i < nums.length; i++){
    		steps[i] = 1;
    	}
    	int max = 0;
    	
    	for(int i = 1; i < nums.length; i++){
    		for(int j = 0; j < i; j++){
    			if(nums[j] <= nums[i]){
    				steps[i] = Math.max(steps[i], steps[j] + 1);
    			}
    		}
    		if(steps[i] > max){
    			max = steps[i];
    		}
    		
    	}
    	return max;
    }
    
    // O(nlogn)
    //http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
    //http://www.programcreek.com/2014/04/leetcode-longest-increasing-subsequence-java/
    public int longestIncreasingSubsequenceII(int[] nums){
    	
    	if(nums == null || nums.length == 0){
            return 0;
        }

    	 int size = nums.length;
    	 int[] tailTable   = new int[size];
         int len; // always points empty slot
  
         tailTable[0] = nums[0];
         len = 1;
         for (int i = 1; i < size; i++)
         {
             if (nums[i] < tailTable[0])
                 // new smallest value
                 tailTable[0] = nums[i];
  
             else if (nums[i] > tailTable[len-1])
                 // A[i] wants to extend largest subsequence
                 tailTable[len++] = nums[i];
  
             else
                 // A[i] wants to be current end candidate of an existing
                 // subsequence. It will replace ceil value in tailTable
                 tailTable[CeilIndex(tailTable, -1, len-1, nums[i])] = nums[i];
         }
  
         return len;
    }
    
    static int CeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (A[m]>=key)
                r = m;
            else
                l = m;
        }
 
        return r;
    }
    
    
    public int binarySearch(int[] ends, int num){
    	int start = 0, end = ends.length - 1;
    	while(start +  1 < end){
    		int mid = start + (end - start)/2;
    		if(ends[mid] == num){
    			start = mid;
    		}else if(ends[mid] < num){
    			start = mid;
    		}else{
    			end = mid;
    		}
    	}
    	
    	if(ends[start] > num){
    		return start;
    	}
    	return end;
    	
    }
    
    public static void main(String args[]){
    	LongestIncreasingSubsequence test = new LongestIncreasingSubsequence();
    	int[] tmp = {10,1,11,2,12,3,11};
    	int res = test.longestIncreasingSubsequence(tmp);
    	System.out.println(res);
    }
}
