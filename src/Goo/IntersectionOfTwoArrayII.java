package Goo;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfTwoArrayII {
	
	 	HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    
	    public int[] intersect(int[] nums1, int[] nums2) {
	        if(nums1.length < nums2.length){
	        	intialize(nums1, res);
	            
	            for(int i = 0; i < nums2.length; i++){
	                if(!res.containsKey(nums2[i]) || res.get(nums2[i]) <= 0){
	                    continue;
	                }else{
	                    result.add(nums2[i]);
	                    res.put(nums2[i], res.get(nums2[i] - 1));
	                }
	            }
	        
	            
	        }else{
	        	intialize(nums2, res);
	            for(int i = 0; i < nums1.length; i++){
	                if(!res.containsKey(nums1[i]) || res.get(nums1[i]) <= 0){
	                    continue;
	                }else{
	                    result.add(nums1[i]);
	                    res.put(nums1[i], res.get(nums1[i] - 1));
	                }
	            }
	        }
	        int cnt = 0;
	        int[] an = new int[result.size()];
	        for(int num: result){
	            an[cnt++] = num;
	        }
	        
	        return an;
	    }
	    
	    public void intialize(int[] nums, HashMap<Integer, Integer> res){
	        for(int i = 0; i < nums.length; i++){
	            if(res.get(nums[i]) == null){
	                res.put(nums[i], 0);
	            }else{
	                int curCount =  res.get(nums[i]);
	                res.put(nums[i], curCount + 1);
	            }
	        }
	    }
}
