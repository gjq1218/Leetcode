package GraphAndSearch;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a list of numbers, return all possible permutations.

Example
For nums = [1,2,3], the permutations are:

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

 * @author SirusBlack
 *
 */
public class Permutations {
	  public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
		 ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		  
	     if(nums == null || nums.size() == 0){
	    	 return res;
	     }
	     ArrayList<Integer> oneres = new ArrayList<Integer>();
	     Collections.sort(nums);
	     
	     helper( res, oneres, nums);
	     return res;
	  }
	  
	  public void helper( ArrayList<ArrayList<Integer>> res, ArrayList<Integer> oneres, ArrayList<Integer> nums){
		  
		  if(oneres.size() == nums.size()){
			  res.add(new ArrayList<Integer>(oneres));
			  return;
		  }
		 
		  
		  for(int i = 0; i < nums.size(); i++){
			  
			  if(oneres.contains(nums.get(i))){
				  continue;
			  }
			  oneres.add(nums.get(i));
			  helper(res, oneres, nums);
			  oneres.remove(oneres.size() - 1);
		  }
		  
	  }
	
	  
	  public static void main(String args[]){
		   
	  }
}
