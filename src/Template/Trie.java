package Template;

import java.util.HashMap;
/**
 * 
 * 1. trie 26叉树。 存一个词典，hash空间高？还是trie空间高？ Hash高！trie空间复杂度低
 * 【b, abc, abd, bcd, bcd】 hash 要存13个字符， trie只需要8个字符
 * 2. trie树还可以查找前缀。
 * 3.时间复杂度：hash 和 trie 相等。hash扫面一个单词利用hash function得到hashcode还是需要遍历那个单词O(len), 平常是指O(1)是指O（1）个单词。而查找 trie也是（1）个单词的复杂度。
 * 
 * @author SirusBlack
 *
 */

public class Trie{
	public class TrieNode {
		char c;
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		boolean hasWord;
		
		public TrieNode(){
			
		}
		public TrieNode(char c){
			this.c = c;
		}
		
	}
	
	private TrieNode root;
	public Trie(){
		root = new TrieNode();
	}
	// insert a word into the trie.
	public void insert(String word){
		TrieNode cur = root;
		HashMap<Character, TrieNode> curChildren = root.children;
		char[] wordArray = word.toCharArray();
		for(int i = 0; i < wordArray.length; i++){
			char wc = wordArray[i];
			if(curChildren.containsKey(wc)){
				cur = curChildren.get(wc);
			}else{
				TrieNode newNode = new TrieNode(wc);
				curChildren.put(wc, newNode);
				cur = newNode;
			}
			
			curChildren = cur.children;
			
			if(i == wordArray.length - 1){
				cur.hasWord = true;
			}
		}
	}
	
	// Return if the word is in the trie.
	public boolean search(String word){
		if(searchWithNodePos(word) == null){
			return false;
		}else if(searchWithNodePos(word).hasWord){
			return true;
		}else{
			return false;
		}
	}
	// return is there is any word in the trie that starts with the given prefix.
	public boolean startsWith(String prefix){
		if(searchWithNodePos(prefix) == null){
			return false;
		}else{
			return true;
		}
	}
	
	// search a word with corresponding position.
	public TrieNode searchWithNodePos(String s){
		HashMap<Character, TrieNode> children = root.children;
		TrieNode cur = null;
		char[] sArray = s.toCharArray();
		for(int i = 0; i < sArray.length; i++){
			char c = sArray[i];
			if(children.containsKey(c)){
				cur = children.get(c);
				children  = cur.children;
			}else{
				return null;
			}
		}
		return cur;
	}
}

