package Template;

public class KthLargestElementQuickSelect {
	public int  kthLargestElement(int k, int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		if(k < 0){
			return 0;
		}

		return QuickSelect(nums, 0, nums.length - 1,  nums.length - k + 1);
	}
	
	public int QuickSelect(int[] nums, int left, int right, int k){
		if(left == right){
			return nums[left];
		}
		
		int position = partition(nums, left, right);
		
		if(position + 1 == k){
			return nums[position];		
		}else if(position + 1 < k){
			return QuickSelect(nums, position + 1, right, k);
		}else{
			return QuickSelect(nums, left, position - 1, k);
		}		
	}
	public int partition(int nums[], int left, int right){
		if(left == right){
			return left;
		}
		int now = nums[left];
		while(left < right){
			while(left < right && nums[right]  >= now){
				right--;
			}
			nums[left] = nums[right];
			while(left < right && nums[left] <= now){
				left ++;
			}
			nums[right] = nums[left];
		}
		
		nums[left] = now;
		return left;
	}
}
