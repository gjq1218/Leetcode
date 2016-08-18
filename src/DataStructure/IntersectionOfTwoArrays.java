package DataStructure;

import java.util.Arrays;

/**
 * Given two arrays, write a function to compute their intersection.

 Notice

	Each element in the result must be unique.
	The result can be in any order.
	
	Example
	Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 * @author SirusBlack
 *
 */
public class IntersectionOfTwoArrays {
	  /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);
    	
    	int i = 0, j = 0;
    	int[] temp = new int[nums1.length];
    	int index = 0;
    	while(i < nums1.length && j < nums2.length){
    		if(nums1[i] == nums2[j]){
    			if(index == 0 || temp[index - 1] != nums1[i]){
    				temp[index++] = nums1[i];
    			}
    			i++;
    			j++;
    		}else if(nums1[i] < nums2[j]){
    			i++;
    		}else{
    			j++;
    		}
    	}
    	int[] result = new int[index];
    	for(int k = 0; k < index; k++){
    		result[k] = temp[k];
    	}
    	return result;
    	
    }
    
    public static void main(String args[]){
    	IntersectionOfTwoArrays test = new IntersectionOfTwoArrays();
    	int[] nums1 = {1,2,2,1};
    	int[] nums2 = {2,2};
    	test.intersection(nums1, nums2);
    	
    }
}
