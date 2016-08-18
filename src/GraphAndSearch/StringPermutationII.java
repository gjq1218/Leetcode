package GraphAndSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string, find all permutations of it without duplicates.

Example
Given "abb", return ["abb", "bab", "bba"].

Given "aabb", return ["aabb", "abab", "baba", "bbaa", "abba", "baab"].

 * @author SirusBlack
 *
 */
public class StringPermutationII {
	  public List<String> stringPermutation2(String str) {
		  List<String> res = new ArrayList<String>();
	       if(str == null){
	    	   return res;
	       }
	       char[] chars = str.toCharArray();
	       Arrays.sort(chars);
	     //  str = chars.toString();
	       
	       int[] visited = new int[str.length()];
 	       
	       String cur = new String("");
	       
//	       StringBuilder cur = new StringBuilder();
	       dfs(res, cur, chars, visited);
	       return res;
	  }
	  
	  public void dfs(List<String> res , String cur, char[] chars, int[] visited){
		  
		  if(cur.length() == chars.length){
			  res.add(new String(cur));
			  return;
		  }
		  
		  for(int i = 0; i < chars.length; i++){

			  if(visited[i] == 1 || (i != 0 && chars[i] == chars[i - 1] && visited[i - 1] == 0)){
				  continue;
			  }
			  
			  visited[i] = 1;
			 // cur.append(str.charAt(i));
			  dfs(res, cur + chars[i], chars, visited);
			  //cur.deleteCharAt(cur.length());
			  visited[i] = 0;
		  }
		  
	  }
}
