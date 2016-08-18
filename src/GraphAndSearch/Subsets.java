package GraphAndSearch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of distinct integers, return all possible subsets.

 Notice

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Have you met this question in a real interview? Yes
Example
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

Can you do it in both recursively and iteratively?


 * @author SirusBlack
 *
 */
public class Subsets {
	  /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
	
	// Recursion
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if(nums == null || nums.length == 0){
    		return res;
    	}
     
        ArrayList<Integer> oneres = new ArrayList<Integer>();
        Arrays.sort(nums);
        helper(0, res, oneres, nums);
        return res;
    }
    
    public void helper(int pos, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> oneres, int[] nums){
    	
    	if(pos > nums.length){
    		return;
    	}
    	res.add(new ArrayList<Integer> (oneres));
    
    	for(int i = pos; i < nums.length; i++){
    		
    		oneres.add(nums[i]);
    		helper(i + 1, res, oneres, nums);
    		oneres.remove(oneres.size() - 1);
    	}
    }
    
    public static void main(String args[]){
    	Subsets test = new Subsets();
    	int nums[] = {1,21,22};
    	ArrayList<ArrayList<Integer>> res = test.subsets(nums);
    	 for(ArrayList<Integer> list : res){
    		 System.out.println(list.toString());
    	 }
    	 System.out.println(res.size());
    }
    // Non-Recursion
    public ArrayList<ArrayList<Integer>> subsetsNonRec(int[] nums) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	Arrays.sort(nums);
    	int N = nums.length;
    	for(int i = 0; i < ( i << N); i++){
    		ArrayList<Integer> oneres = new ArrayList<Integer>();
    		for(int j = 0; j < N; j++){
    			if(( i & (i << j)) > 0){
    				oneres.add(nums[j]);
    			}
    		}
    		res.add(oneres);
    	}
    	return res;
    }
    
}
