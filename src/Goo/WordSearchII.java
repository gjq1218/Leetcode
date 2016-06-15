package Goo;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.

	Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
	
	For example,
	Given words = ["oath","pea","eat","rain"] and board =
	
	[
	  ['o','a','a','n'],
	  ['e','t','a','e'],
	  ['i','h','k','r'],
	  ['i','f','l','v']
	]
	Return ["eat","oath"].
	Note:
	You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * @author ginagao
 *
 */
public class WordSearchII {
	  public List<String> findWords(char[][] board, String[] words) {
	        // write your code here
		 ArrayList<String> res	= new ArrayList<String>();
		 int m = board.length;
		 int  n = board[0].length;
		 boolean[][] visited = new boolean[m][n];
		 for(String word : words){
			// int sLength = word.length(); 
			 int find = 0;
			 for(int i = 0; i < m; i++){
				 for(int j = 0; j < n; j++){
					if(dfs(board, i, j, visited, word, 0)){
						res.add(word);
						find = 1;
						visited = new boolean[m][n];						
						break;
					};
				 }
				 if(find == 1){
					 break;
				 }
			 }
		 }
		 return res;
	  }
	 public boolean dfs(char[][] board, int i, int j, boolean[][] visited, String word, int position){
		 if(position == word.length()){
			 return true;
		 }
		 if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
			 return false;
		 }
		 if(visited[i][j]){
			 return false;
		 }
		 if(word.charAt(position) != board[i][j]){
			 return false;
		 }
		 visited[i][j] = true;
		 
		 if(dfs(board, i -  1, j, visited, word, position + 1)){return true;}
		 if(dfs(board, i + 1, j, visited, word, position + 1)){return true;}
		 if(dfs(board, i, j - 1, visited, word, position + 1)){return true;}
		 if(dfs(board, i, j + 1, visited, word, position + 1)){return true;}
		 
		 visited[i][j] = false;
		 return false;
	 
	 }
}
