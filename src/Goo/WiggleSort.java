package Goo;

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 * @author SirusBlack
 *
 */
public class WiggleSort {
	 public void wiggleSort(int[] nums) {
	      Arrays.sort(nums);
	      
	      for(int i = 2; i < nums.length; i = i+2){
	    	  int tmp = nums[i - 1];
	    	  nums[i - 1] = nums[i];
	    	  nums[i] = tmp;
	      }
	 }
}
