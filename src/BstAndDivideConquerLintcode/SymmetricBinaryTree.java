package BstAndDivideConquerLintcode;
/**
 * Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

	Example
	    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3
	is a symmetric binary tree.
	
	    1
	   / \
	  2   2
	   \   \
	   3    3
	is not a symmetric binary tree.
 * @author SirusBlack
 *
 */
public class SymmetricBinaryTree {
	 public class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
	 }
	 
	public boolean isSymmetric(TreeNode root) {
	       if(root == null){
	    	   return true;
	       }
	       
	       return isSymmetricRec(root.left, root.right);
	    }
	    
	    public boolean isSymmetricRec(TreeNode p, TreeNode q){
	    	if(p == null && q == null){
	    		return true;
	    	}
	    	if(p == null || q == null){
	    		return false;
	    	}else{
		    		if(p.val == q.val){
		    			return isSymmetricRec(p.left, q.right) && isSymmetricRec(p.right, q.left);
		    		}else{
		    			return false;
		    		}
	    		}
	    	}
}
