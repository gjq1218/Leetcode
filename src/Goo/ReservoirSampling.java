package Goo;


import java.util.Random;

public class ReservoirSampling {
	
	public static int[] selectKItems(int[] nums, int k) {
		int[] result = new int[k];
		Random rand = new Random();
		
		for (int i = 0; i < k; i++) {
			result[i] = nums[i];
		}
		
		for (int i = k; i < nums.length; i++) {
			int j = rand.nextInt(i + 1);
			if (j < k) {
				result[j] = nums[i];
			}
		}
		
		return result;
	}
	
	public static int[] selectKItemFromStream(int[] stream) {
		int[] result = new int[stream.length];
		result[0] = stream[0];
		Random rand = new Random();
		
		for (int i = 1; i < stream.length; i++) {
			int j = rand.nextInt(i + 1);
			if (j == i) {
				result[i] = stream[i];
			} else {
				result[i] = stream[i - 1];
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//		int[] result = selectKItems(nums, 4);
//		
//		for (int num : result) {
//			System.out.print(num + " ");
//		}
//		
		int[] result2 = selectKItemFromStream(nums);
		for (int num : result2) {
			System.out.print(num + " ");
		}
	}

}

