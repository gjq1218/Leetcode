package Template;

import java.util.*;

public class Solution{
	class TrieNode {
        String s;
         boolean isString;
         HashMap<Character, TrieNode> subtree;
         public TrieNode() {
            // TODO Auto-generated constructor stub
             isString = false;
             subtree = new HashMap<Character, TrieNode>();
             s = "";
         }
    };


    class TrieTree{
        TrieNode root ;
        public TrieTree(TrieNode TrieNode) {
            root = TrieNode;
        }
        public void insert(String s) {
            TrieNode now = root;
            for (int i = 0; i < s.length(); i++) {
                if (!now.subtree.containsKey(s.charAt(i))) {
                    now.subtree.put(s.charAt(i), new TrieNode());
                }
                now  =  now.subtree.get(s.charAt(i));
            }
            now.s = s;
            now.isString  = true;
        }
        public boolean find(String s){
            TrieNode now = root;
            for (int i = 0; i < s.length(); i++) {
                if (!now.subtree.containsKey(s.charAt(i))) {
                    return false;
                }
                now  =  now.subtree.get(s.charAt(i));
            }
            return now.isString ;
        }
    };

	public void wordSearchII(char[][] board, ArrayList<String> words){
			ArrayList<String> ans = new ArrayList<String>();
		
			TrieTree tree = new TrieTree(new TrieNode());

			for(String word: words){
				tree.insert(word);
			}

	}
	
	public static void main(String args[]){
		Solution test = new Solution();
		 ArrayList<String> words = new ArrayList<String>();
		 words.add("dog");
		 words.add("dad");
		 words.add("dgdg");
		 words.add("again");
		 char[][] board = {{'d','o','a','f'},{'a','g','a','i'},{'d','c','a','n'}};
		test.wordSearchII(board, words);
	}

}