package Goo;

import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

	For example, given
	s = "leetcode",
	dict = ["leet", "code"].
	
	Return true because "leetcode" can be segmented as "leet code".
 * @author SirusBlack
 *
 */
public class WordBreak {
	// This is a DP question.
//	possible[i] = true      if  S[0,i]在dictionary里面
//
//            = true      if   possible[k] == true 并且 S[k+1,j]在dictionary里面， 0<k<i
//
//           = false      if    no such k exist.
//	
	public boolean wordBreak(String s, Set<String> wordDict) {
	  	if(s == null || wordDict.size() <= 0){
			return false;
		}
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for(int i = 1; i < s.length() + 1; i++){
			for(int k = 0; k < i; k++){
			    if(dp[k]  ==  true && wordDict.contains(s.substring(k, i))){
			        dp[i] = true;
			    }
			
			}
		}	
		return dp[s.length()];
		
	}
	
// This method will out of stack finally.
//	 public boolean wordBreak(String s, Set<String> wordDict) {
//		 int len = s.length();
//		 boolean flag = false;
//		 
//		 for(int i = 0; i <= len; i++){
//			 String subStr = s.substring(0,i);
//			 if(wordDict.contains(subStr)){
//				 return true;
//			 }
//			 flag = wordBreak(s.substring(i), wordDict);
//		 }
//		 
//		 return flag;
//	 }
}
