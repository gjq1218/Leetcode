package DataStructure;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TopKLargestNumbers {
	  public int[] topk(int[] nums, int k) {
		  
	       PriorityQueue<Integer> heap = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>(){
	           public int compare(Integer a, Integer b){
	               return b - a;
	           }
	       });
	       
	       for(int i = 0; i < nums.length; i++){
	           heap.add(nums[i]);
	       }
	       int[] res = new int[k];
	       for(int i = 0; i < k; i++){
	           res[i] = heap.poll();
	       }
	       
	       return res;
	    }
}
