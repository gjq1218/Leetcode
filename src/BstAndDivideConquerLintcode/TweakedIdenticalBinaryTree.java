package BstAndDivideConquerLintcode;
/**
 * Check two given binary trees are identical or not. Assuming any number of tweaks are allowed. A tweak is defined as a swap of the children of one node in the tree.

	 Notice
	
	There is no two nodes with the same value in the tree.
	
	Example
	    1             1
	   / \           / \
	  2   3   and   3   2
	 /                   \
	4                     4
	are identical.
	
	    1             1
	   / \           / \
	  2   3   and   3   2
	 /             /
	4             4
	are not identical.
 * @author SirusBlack
 *
 */
public class TweakedIdenticalBinaryTree {
	 public class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
	 }
	 
	 public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
	      if(a ==  null && b == null){
	    	  return true;
	      }else if( a != null &&  b != null){
	    	 if(a.val == b.val){
	    		return isTweakedIdentical(a.left, b.left) && isTweakedIdentical(a.right, b.right) || isTweakedIdentical(a.left, b.right) && isTweakedIdentical(a.right, b.left);
	    	 }else{
	    		 return false;
	    	 }
	      }else{
	    	  return false;
	      }
	 }
}
