package GraphAndSearch;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a list of numbers that may has duplicate numbers, return all possible subsets

 Notice

Each element in a subset must be in non-descending order.
The ordering between two subsets is free.
The solution set must not contain duplicate subsets.
Have you met this question in a real interview? Yes
Example
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 * @author SirusBlack
 *
 */
public class SubsetsII {
	 public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
		 ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		 
		 if( S == null ||S.size() == 0){
			 return res;
		 }
		 ArrayList<Integer> subset = new ArrayList<Integer>();
		 Collections.sort(S);
		 helper(0, subset, res, S);
		 return res;
	 }
	 
	 public void helper(int pos, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> S ){
		
		 
		 if(pos > S.size()){
			 return;
		 }
		 
		 res.add(new ArrayList<Integer>(subset));
		 
		 for(int i = pos; i < S.size(); i++){
			 
			 if(i != pos && S.get(i) == S.get(i - 1)){ 
				 continue;
			 }
			 
			 subset.add(S.get(i));
			 helper(i + 1, subset, res, S);
			 subset.remove(subset.size() - 1);
			 
		 }
	
	 }
	 
	 public static void main(String args[]){
		 SubsetsII test = new SubsetsII();
		 ArrayList<Integer> S = new ArrayList<Integer>();
		 S.add(1);
		 S.add(2);
		 test.subsetsWithDup(S);
	 }
}

