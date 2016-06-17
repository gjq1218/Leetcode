package BstAndDivideConquerLintcode;
/**
 * Check a binary tree is completed or not. A complete binary tree is a binary tree that every level is completed filled except the deepest level. In the deepest level, all nodes must be as left as possible. See more definition

	Have you met this question in a real interview? Yes
	Example
	    1
	   / \
	  2   3
	 /
	4
	is a complete binary.
	
	    1
	   / \
	  2   3
	   \
	    4
	is not a complete binary.
 * @author SirusBlack
 *
 */
public class CompleteBinaryTree {
	
	 public class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
	 }
	 
	 
	 public class ResultTypeCBT{
	    	public int depth;
	    	public boolean isFull, isComplete;
	    	ResultTypeCBT(int depth, boolean isFull, boolean isComplete){
	    		this.depth = depth;
	    		this.isFull = isFull;
	    		this.isComplete = isComplete;
	    	}
	    }
	    
	    public boolean isComplete(TreeNode root){
	    	ResultTypeCBT result = helperCBT(root);
	    	return result.isComplete;
	    }
	    public ResultTypeCBT helperCBT(TreeNode root){
	    	if(root == null){
	    		return new ResultTypeCBT(0, true, true);
	    	}
	    	ResultTypeCBT left = helperCBT(root.left);
	    	ResultTypeCBT right = helperCBT(root.right);
	    	
	    	if(!left.isComplete){
	    		return new ResultTypeCBT(-1, false, false);
	    	}
	    	
	    	// if depth is the same, left should be full and right should be complete
	    	if(left.depth == right.depth){
	    		if(!left.isFull || !right.isComplete){
	    			return new ResultTypeCBT(-1, false, false);
	    		}
	    		return new ResultTypeCBT(left.depth + 1, right.isFull, true);
	    	}
	    	
	    	
	    	// if left.depth = right.depth + 1. left should be complete and right should be full.
	    	if(left.depth == right.depth + 1){
	    		if(!left.isComplete || !right.isFull){
	    			return new ResultTypeCBT(-1, false, false);
	    		}
	    		return new ResultTypeCBT(left.depth + 1, false, true);
	    	}
	    	return new ResultTypeCBT(-1, false, false);
	    }
}
