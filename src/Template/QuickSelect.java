package Template;

import java.util.Random;

public class QuickSelect {
	
	public static int quickSelect(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return Integer.MAX_VALUE;
		}
		
		Random rand = new Random();
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int pivot = partition(nums, left, right, rand.nextInt(right - left + 1) + left);
			if (pivot == k - 1) {
				return nums[pivot];
			} else if (pivot < k - 1) {
				left = pivot + 1;
			} else {
				right = pivot - 1;
			}
		}
		
		return Integer.MAX_VALUE;
	}
	
	private static int partition(int[] nums, int left, int right, int pivot) {
		int pivotValue = nums[pivot];
		int storeIndex = left;
		swap(nums, pivot, right);
		
		for (int i = left; i < right; i++) {
			if (nums[i] > pivotValue) {
				swap(nums, i, storeIndex++);
			}
		}
		swap(nums, storeIndex, right);
		
		return storeIndex;
	}
	
	private static void swap(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 7, 2, 5, 6, 4, 3, 9, 8, 0 };
		System.out.println(quickSelect(nums, 5));
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

}
