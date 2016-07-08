package Goo;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function to generate the generalized abbreviations of a word.

	Example:
	Given word = "word", return the following list (order does not matter):
	["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * @author SirusBlack
 *
 */
public class GeneralizedAbbreviation {
	  public List<String> generateAbbreviations(String word) {
	        List<String> res = new ArrayList<>();
	        dfs(res, "", 0, word);
	        return res;
	        
	  }
	  
	  public void dfs(List<String> res, String cur, int start, String s){
		  if(start >= s.length()){
			  return;
		  }
		  
		  
	  }
}
0000 word
0001 wor1
0010 wo1d
0100 w1rd
1000 1ord
0011 wo2
0111 w3
1111 4
0101 w1o1

