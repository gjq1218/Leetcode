package Goo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.

	Example:
	Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
	
	Note:
	Each element in the result must be unique.
	The result can be in any order.
 * @author SirusBlack
 *
 */
public class IntersectionOfTwoArrays {
	   public int[] intersection(int[] nums1, int[] nums2) {
		   Set<Integer> setone = new HashSet<Integer>();
	       Set<Integer> res = new HashSet<Integer>();
	       
	       for(int i = 0; i < nums1.length; i++){
	           setone.add(nums1[i]);
	       }
	       
	       for(int i = 0; i < nums2.length; i++){
	           if(setone.contains(nums2[i])){
	               res.add(nums2[i]);
	           }
	       }
	       
	       int[] result = new int[res.size()];
	       int cnt = 0;
	       for(int num: res){
	           result[cnt++] = num;
	       }
	       return result;
	        
	    }
	   
}
