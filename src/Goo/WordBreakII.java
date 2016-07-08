package Goo;
/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	public boolean wordBreakCheck(String s, Set<String> wordDict){
		if(s == null || s.length() == 0){
			return true;
		}
		
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for(int i = 1; i < s.length() + 1; i++){
			for(int k = 0; k < i; k++){
				if(dp[k] ==  true && wordDict.contains(s.substring(k,i))){
					dp[i] = true;
				}
			}
		}
		
		return dp[s.length()];
	}
	
	public List<String> wordBreak(String s, Set<String> wordDict) {
	        List<String> res = new ArrayList<String>();
	        if(s == null || s.length() == 0){
	        	return res;
	        }
	        
	        if(wordBreakCheck(s, wordDict)){
	        	helper(s, wordDict, 0, "", res);
	        }
	        return res;
	}
	
	public void helper(String s, Set<String> dict, int start, String item, List<String> res){
		if(start >= s.length()){
			res.add(item);
			return ;
		}
		
		StringBuilder str = new StringBuilder();
		for(int i = start; i < s.length(); i++){
			str.append(s.charAt(i));
			
			if(dict.contains(str.toString())){
				String newItem = new String();
				if(item.length() > 0)
				{
					newItem = item + " " + str.toString();
				}else{
					newItem = str.toString();
				}			
				
				helper(s, dict, i + 1, newItem, res);
				
			}	
		}
	}
	
	public static void main(String args[]){
		String s = "catsanddog";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		WordBreakII test =  new WordBreakII();
		test.wordBreak(s, wordDict);		
	}

	
}


	
	