package BstAndDivideConquerLintcode;
/**
 * Check if two binary trees are identical. Identical means the two binary trees have the same structure and every identical position has the same value.

	Have you met this question in a real interview? Yes
	Example
	    1             1
	   / \           / \
	  2   2   and   2   2
	 /             /
	4             4
	are identical.
	
	    1             1
	   / \           / \
	  2   3   and   2   3
	 /               \
	4                 4
	are not identical.
 * @author SirusBlack
 *
 */
public class IdenticalBinaryTree {
	 public class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
	 }
	 
    public boolean isIdentical(TreeNode a, TreeNode b) {
  	if(a == null && b == null){
  		return true;
  	}else if( a != null && b != null){
  		if(a.val == b.val){
  			return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
  		}else{
  			return false;
  		}
  	}else{
  		return false;
  	}
  }
}
