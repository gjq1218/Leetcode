package Goo;
/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

	Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
	
	Example:
	(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
	(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
	
	Note:
	You may assume all input has valid answer.
	
	Follow Up:
	Can you do it in O(n) time and/or in-place with O(1) extra space?
	
	Credits:
	Special thanks to @dietpepsi for adding this problem and creating all test cases.

 * @author ginagao
 *
 */
public class WiggleSortII {
	//利用quick select的思想， 把中间的那个数先排列好，然后利用wigglesort1的思想。找到数组中间的数， 把数组分成两个部分，前半段末尾取一个，
	//后半段末尾取一个。轮流交换完毕为止。
	 public void wiggleSort(int[] nums) {
	        int[] tem = new int[nums.length];
	        for(int i = 0; i < nums.length; i++){
	        	tem[i] = nums[i];
	        }
	        
	        int mid = partition(tem, 0, nums.length - 1, nums.length/2);
	        int[] ans = new int[nums.length];
	        for(int i = 0; i < nums.length; i++){
	        	ans[i] = mid;
	        }
	        
	        int l, r;
	        
	        if(nums.length %2 ==0){
	        	l = nums.length - 2;
	        	r = 1;
	        	
	        	for(int i = 0; i < nums.length; i++){
	        		if(nums[i] < mid){
	        			ans[l] = nums[i];
	        			l = l - 2;
	        		}else if(nums[i] > mid){
	        			ans[r] = nums[i];
	        			r = r + 2;
	        			
	        		}
	        	}
	        }else{
	        	l = 0;
	        	r = nums.length - 2;
	        	for(int i = 0; i < nums.length; i++){
	        		if(nums[i] < mid){
	        			ans[l] = nums[i];
	        			l = l + 2;
	        		}else if(nums[i] > mid){
	        			ans[r] = nums[i];
	        			r = r - 2;
	        		}
	        	}
	        }
	        for(int i = 0; i < nums.length; i++){
	        	nums[i] = ans[i];
	        }
	        
	 }
	 public static int partition(int[]nums, int l, int r, int rank)
	 {
		 int left = l;
		 int right = r;
		 int now = nums[left];
		 while(left < right){
			 while(left < right && nums[right] >= now){
				 right -- ;
			 }
			 nums[left] = nums[right];
			 
			 while(left < right && nums[left] <=  now){
				 left ++;
			 }
			 nums[right] = nums[left];
		 }
		 
		 if(left - l == rank){
			 return now;
		 }else if(left - l < rank){
			 return partition(nums, left + 1, r, rank - (left - l + 1));
		 }else{
			 return partition(nums, l, right - 1, rank);
		 }
	 }	 
}
