package GraphAndSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

	Only one letter can be changed at a time
	Each intermediate word must exist in the dictionary
	 Notice
	
	All words have the same length.
	All words contain only lowercase alphabetic characters.
	
	Example
	Given:
	start = "hit"
	end = "cog"
	dict = ["hot","dot","dog","lot","log"]
	Return
	  [
	    ["hit","hot","dot","dog","cog"],
	    ["hit","hot","lot","log","cog"]
	  ]
	  
  
 * @author SirusBlack
 *
 */
public class WordLadderII {
	 public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		 List<List<String>> res = new ArrayList<List<String>> ();
		 
	       if(start == null || end == null || dict == null){
	    	   return res;
	       }
	       //Distance是 bfs从后往前走， 存储前一个点到后一个的距离。
	       HashMap<String, Integer> distance = new HashMap<String, Integer>();
	       // map存了每一个点是尤之前哪个点来的。
	       HashMap<String, List<String>> map = new HashMap<String, List<String>>();
	       
	       
	       dict.add(start);
	       dict.add(end);
	       
	       // do the BFS from end to start
	       bfs(start, end, dict, distance, map);
	      
	       ArrayList<String> path = new ArrayList<String>();
	       
	       dfs(res, path, distance, map, start, end);
	       return res;
	       
	 }
	 
	 public void dfs( List<List<String>> res, ArrayList<String> path, HashMap<String, Integer> distance, HashMap<String, List<String>> map, String cur, String end){
		 path.add(cur);
		 if(cur == end){
			 res.add(new ArrayList<String>(path));
		 }else{
			 
			 for(String next: map.get(cur)){
				 if(distance.containsKey(next) && distance.get(cur) ==  distance.get(next) + 1){
					 dfs(res, path, distance, map, next, end);
					 path.remove(path.size() - 1);
				 }
			 }
		 } 
	 }

	 public void bfs(String start, String end, Set<String> dict, HashMap<String, Integer> distance, HashMap<String, List<String>> map){
		 Queue<String> queue = new LinkedList<String>();
		 queue.add(end);
		 distance.put(end, 0);
		 
	     int path = 0;
	     
	     for(String s: dict){
	    	 map.put(s, new ArrayList<String>());
	     }
	     
		 while(!queue.isEmpty()){
			   int size = queue.size();
			   path = path + 1;
			   for(int i = 0; i < size; i++){
				   String cur = queue.poll();
				   
				   List<String> nextWords = getNextWords(cur,i, dict);
				   for(String word: nextWords){		   
					   
					   map.get(word).add(cur);
					   if(!distance.containsKey(word)){
						   distance.put(word, path);
						   queue.offer(word);
					   }
				   }
			   }
		 }
		 
	 }

	 public List<String> getNextWords(String cur, int index, Set<String> dict){
		 List<String> nextWords = new ArrayList<String>();
	
		 for(char c ='a'; c <= 'z'; c++){
			 for(int i = 0; i < cur.length(); i++){
				 if(c == cur.charAt(i)){
					 continue;
				 }
//				 String word = replace(cur, index, c);
				 String word = cur.substring(0, i) + c + cur.substring(i+1);
				 
				 if(dict.contains(word)){
					 nextWords.add(word);
				 }
				 
			 }
		 } 
		 return nextWords;
	 }
	 
//	 public String replace(String cur, int index, char c){
//		 char[] chars = cur.toCharArray();
//		 chars[index] = c;
//		 return new String(chars);
// 	 }
}
