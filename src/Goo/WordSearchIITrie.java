package Goo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * same with wordSearchII, but use Trie Tree to implement which is more efficient because it can check the prefix. and if it's not
 * the word, then go back to one node. But hash you need to start with the whole word.
 *
 * TC = O (n*m (n*m))
 * @author SirusBlack
 *
 */
public class WordSearchIITrie {
	
 	
    class TrieNode {
       // Initialize your data structure here.
       String c;
       HashMap<Character, TrieNode> children; 
       boolean hasWord;
       
       
       
       public TrieNode(){
           c = "";
           children = new HashMap<Character, TrieNode>();
           hasWord = false;
      
       }
   }

   public class TrieTree {
       private TrieNode root;

       public TrieTree() {
           root = new TrieNode();
      }

   // Inserts a word into the trie.
       public void insert(String word) {
           TrieNode cur = root;
           HashMap<Character, TrieNode> curChildren = root.children;
           char[] wordArray = word.toCharArray();
           for(int i = 0; i < wordArray.length; i++){
               char wc = wordArray[i];
               if(curChildren.containsKey(wc)){
                   cur = curChildren.get(wc);
               } else {
                   TrieNode newNode = new TrieNode();
                   curChildren.put(word.charAt(i), newNode);
                   cur = newNode;
               }
               curChildren = cur.children;
               if(i == wordArray.length - 1){
                   cur.hasWord= true;
                   cur.c = word;
               }
           }
       }
   }
	  public int[] dx = {1, 0, -1,0};
	  public int[] dy = {0, 1, 0, -1};
	  
	  
	  // dfs to search the word using the trie tree.
   public void search(char[][] board, int x, int y, TrieNode root, List<String> ans,  String res){
		  if(root.hasWord ==  true){
			  if(!ans.contains(String.valueOf(root.c))){
				  ans.add(String.valueOf(root.c));
			  }
		  }
		  if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == 0 || root == null){
			  return;
		  }
		  if(root.children.containsKey(board[x][y])){
			  
			  for(int i = 0; i < 4; i++){
				  char now = board[x][y];
				  board[x][y] = 0;
				  search(board, x+dx[i], y+dy[i], root.children.get(now), ans, res);
				  board[x][y] = now; 
			  }
		  }
	  }
	  
	  
	  
	  public List<String> findWords(char[][] board, String[] words) {
		   List<String> ans = new ArrayList<String>();
			if(board.length == 0 || board[0].length == 0 || board == null || words == null || words.length == 0){
	    		return ans;
	    	}
		   
		   TrieTree tree = new TrieTree();
		   
		   for(String word: words){
			   tree.insert(word);
		   }		   
		   String res = "";
		   
		   for(int i = 0; i < board.length; i++){
			   for(int j = 0; j < board[0].length; j++){
				   search(board, i,j, tree.root, ans, res);
			   }			   
		   }
		   return ans;		  
	  }
	  
}
