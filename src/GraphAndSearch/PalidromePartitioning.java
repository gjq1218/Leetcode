package GraphAndSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.


Example
Given s = "aab", return:

[
  ["aa","b"],
  ["a","a","b"]
]

 * @author SirusBlack
 *
 */
public class PalidromePartitioning {
	  public List<List<String>> partition(String s) {
		  List<List<String>> res = new ArrayList<List<String>>();
		  List<String> path = new ArrayList<String>();	  
		  if(s == null || s.length() == 0){
			  return res;
		  }
		  helper(s, 0, res, path);
		  return res;
	  }
	  
	  public void helper(String s, int pos, List<List<String>> res, List<String> path){
		  
		  if(pos == s.length()){
			  res.add( new ArrayList<String>(path));
			  return;
		  }
		  
		  
		  for(int i = pos + 1; i <= s.length(); i++){
			  
			  String prefix = s.substring(pos, i);
			  if(!validPalidrome(prefix)){
				  continue;
			  }
			  
			  path.add(prefix);
			  helper(s, i , res, path);
			  path.remove(path.size() - 1);
		  }
	  }
	  
	  public boolean validPalidrome(String prefix){
		  int left = 0;
		  int right = prefix.length() - 1;
		  
		  while(left <= right){			  
			  if(prefix.charAt(left) == prefix.charAt(right)){
				  left++;
				  right--;
			  }else{
				  return false;
			  }
		  }		  
		  return true;
	  }
	  
	  public static void main(String args[]){
		  PalidromePartitioning test = new PalidromePartitioning();
		  test.partition("aab");
	  }
}
