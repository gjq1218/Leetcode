package GraphAndSearch;

import java.util.ArrayList;

/**
 * 
 * Given n unique integers, number k (1<=k<=n) and target.

Find all possible k integers where their sum is target.

Example
Given [1,2,3,4], k = 2, target = 5. Return:

[
  [1,4],
  [2,3]
]


 * @author SirusBlack
 *
 */
public class KSumII {
	
	
	  public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {

		  ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		  ArrayList<Integer> oneres = new ArrayList<Integer>();
		  
		  helper (res, oneres, A, k, target, 0);
		  return res;
	  }
	  
	  
	  public void helper( ArrayList<ArrayList<Integer>> res, ArrayList<Integer> oneres, int[] A,  int k, int remains, int index){
		  
		  if(oneres.size() == k){
			  
			  if(remains == 0){
				  res.add(new ArrayList<Integer>(oneres));
			  }
			  return;
		  }
		  
		  for(int i = index; i < A.length; i++){
			  
			  oneres.add(A[i]);
			  helper(res, oneres, A, k , remains - A[i], i+1);
			  oneres.remove(oneres.size() - 1);
		  }
		  
	  }
}
