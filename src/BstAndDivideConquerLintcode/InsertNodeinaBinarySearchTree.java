package BstAndDivideConquerLintcode;
/**
 * Given a binary search tree and a new tree node, insert the node into the tree. You should keep the tree still be a valid binary search tree.
	
	 Notice
	
	You can assume there is no duplicate values in this tree + node.
	
	Have you met this question in a real interview? Yes
	Example
	Given binary search tree as follow, after Insert node 6, the tree should be:
	
	  2             2
	 / \           / \
	1   4   -->   1   4
	   /             / \ 
	  3             3   6
 * @author SirusBlack
 *
 */
public class InsertNodeinaBinarySearchTree {
	 public class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
	 }
	 //Recursion
    public TreeNode insertNodeRec(TreeNode root, TreeNode node) {
    	if(root == null){
    		return node;
    	}
    	
    	if(root.val < node.val){
    		root.right = insertNode(root.right, node);
    	}else{
    		root.left = insertNode(root.left, node);
    	}
    	return root;
    }
    //Iteration
    public TreeNode insertNode(TreeNode root, TreeNode node){
    	if(root == null){
    		root = node;
    		return root;
    	}
    	TreeNode tmp = root;
    	TreeNode last = null;
    	while(tmp != null){
    		last = tmp;
    		if(tmp.val > node.val){
    			tmp = tmp.left;
    		}else{
    			tmp = tmp.right;
    		}
    	}
    	
    	if(last != null){
    		if(last.val > node.val){
    			last.left = node;
    		}else{
    			last.right = node;
    		}
    	}
    	return root;
    }
}
