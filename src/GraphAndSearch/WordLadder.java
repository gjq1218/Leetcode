package GraphAndSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

	Only one letter can be changed at a time
	Each intermediate word must exist in the dictionary
	 Notice
	
	Return 0 if there is no such transformation sequence.
	All words have the same length.
	All words contain only lowercase alphabetic characters.
	
	Example
	Given:
	start = "hit"
	end = "cog"
	dict = ["hot","dot","dog","lot","log"]
	As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
	return its length 5.

 * @author SirusBlack
 *
 */



public class WordLadder {
	 /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return an integer
     */
	public int ladderLength(String start, String end, Set<String> dict) {
        if(dict == null || start == null || end == null){
            return 0;
        }
        
        if(start.equals(end)){
        	return 1;
        }
        
        // do the BFS level traversal.
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> hash = new HashSet<String>();
        
    //    dict.add(start);
        dict.add(end);
        
        queue.offer(start);
        hash.add(start);
        
        int level = 1;
        
        while(!queue.isEmpty()){
           
            level++;
            int size = queue.size();
             
            for(int i = 0; i < size; i++){
                String cur = queue.poll();
                
                List<String> nextWords = getNextWords(cur, dict);
                for(String next: nextWords){
                    if(next.equals(end)){
                        return level;
                    }
                    if(!hash.contains(next)){
                        hash.add(next);
                        queue.offer(next);
                    }
                }
            }       
        }   
        
       return 0;

    }

	public String Replace(String cur, int index, char c){
	  	char[] chars = cur.toCharArray();
	  	chars[index] = c;
	  	return new String (chars);
	 }
      
	  
	private List<String> getNextWords(String cur, Set<String> dict) {
		ArrayList<String> nextWords = new ArrayList<String>();
        
        for(char c = 'a'; c <= 'z'; c++){
            for(int i = 0; i < cur.length(); i++){
                if(c == cur.charAt(i)){
                    continue;
                }
                String nextWord = Replace(cur, i, c);
                if(dict.contains(nextWord)){
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
	}
	
	public static void main(String args[]){
		WordLadder test = new WordLadder();
		Set<String> dict = new HashSet<String>();
//		dict.add("hot");
//		dict.add("dot");
//		dict.add("dog");
//		dict.add("lot");
//		dict.add("log");
		dict.add("b");
		int res = test.ladderLength("a", "a", dict);
		System.out.println(res);
	}
}
