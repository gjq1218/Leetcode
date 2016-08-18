package GraphAndSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.



For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 

 Notice

All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.

Example
given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 

 * @author SirusBlack
 *
 */
public class CombinationSum {
   public List<List<Integer>> combinationSum(int[] candidates, int target) {
	   List<List<Integer>> res = new ArrayList<List<Integer>>();
   	
	   	if(candidates == null || candidates.length == 0){
	   		return res;
	   	}
	   	Arrays.sort(candidates);
	   	List<Integer> path = new ArrayList<Integer>();
	   	
	   	helper(0, res, path, candidates, target);
	   	return res;
    }
   
   public void helper(int pos, List<List<Integer>> res, List<Integer> path, int[] num, int target){
	  
	   if(target == 0){
	   		res.add(new ArrayList<Integer>(path));
	   		return;
	   	}
	   	
	   	if(target < 0){
	   		return;
	   	}
   	
	   	for(int i = pos; i < num.length; i++){
	   		
	   		if(i != pos && num[i] == num[i - 1]){
	   		    continue;
	   		}
	   		
	   		path.add(num[i]);
	   		helper(i, res, path, num, target - num[i]);
	   		path.remove(path.size() - 1);
	   	}
   }
}
