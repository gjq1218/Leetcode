package GraphAndSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

 Notice

	All numbers (including target) will be positive integers.
	Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
	The solution set must not contain duplicate combinations.
	Have you met this question in a real interview? Yes
	Example
	Given candidate set [10,1,6,7,2,1,5] and target 8,
	
	A solution set is:
	
	[
	  [1,7],
	  [1,2,5],
	  [2,6],
	  [1,1,6]
	]



 * @author SirusBlack
 *
 */
public class CombinationSumII {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
   public List<List<Integer>> combinationSum2(int[] num, int target) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	
    	if(num == null || num.length == 0){
    		return res;
    	}
    	Arrays.sort(num);
    	List<Integer> path = new ArrayList<Integer>();
    	
    	helper(0, res, path, num, target);
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
    		helper(i + 1, res, path, num, target - num[i]);
    		path.remove(path.size() - 1);
    	}
    }
    // 用以下办法会超时
    // public int validSum( List<Integer> path){
    // 	if(path == null){
    // 		return 0;
    // 	}
    // 	int sum = 0;
    // 	for(Integer a : path){
    // 		sum += a;
    // 	}
    // 	return sum;
    // }
}