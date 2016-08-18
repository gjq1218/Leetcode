package GraphAndSearch;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a list of numbers with duplicate number in it. Find all unique permutations.

Example
For numbers [1,2,2] the unique permutations are:

[
  [1,2,2],
  [2,1,2],
  [2,2,1]
]
 * @author SirusBlack
 *
 */
public class PermutationII {
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
    	 ArrayList<ArrayList<Integer>> res = new  ArrayList<ArrayList<Integer>>();
    	 
    	 if(nums == null || nums.size() == 0 ){
    		 return res;
    	 }
    	 ArrayList<Integer> oneres = new ArrayList<Integer>();
    	 int[] visited = new int[nums.size()];
    	 
    	 
    	 Collections.sort(nums);
    	 helper(oneres, res, nums, visited);
    	 return res;
    }
    
    public void helper(ArrayList<Integer> oneres,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> nums, int[] visited ){
    	if(oneres.size() == nums.size()){
    		res.add(new ArrayList<Integer>(oneres));
    		return;
    	}
    		
    	for(int i = 0; i < nums.size(); i++){
    		if( visited[i] == 1 || ( i != 0 && nums.get(i)== nums.get(i - 1) && visited[i - 1] == 0)){
    			continue;
    		}
    		visited[i] = 1;
    		oneres.add(nums.get(i));
    		helper(oneres, res, nums, visited);
    		oneres.remove(oneres.size() - 1);
    		visited[i] = 0;
    		
    	}	
    		
    }
    
    public static void main(String args[]){
    	PermutationII test = new PermutationII();
    	ArrayList<Integer> nums = new ArrayList<Integer>();
    	nums.add(0);
    	nums.add(2);
    	nums.add(2);
    	test.permuteUnique(nums);
	}
    
}
