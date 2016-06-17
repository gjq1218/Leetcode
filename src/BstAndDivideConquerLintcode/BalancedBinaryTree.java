package BstAndDivideConquerLintcode;
/**
 * Given a binary tree, determine if it is height-balanced.

	For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
	
	Have you met this question in a real interview? Yes
	Example
	Given binary tree A = {3,9,20,#,#,15,7}, B = {3,#,20,15,7}
	
	A)  3            B)    3 
	   / \                  \
	  9  20                 20
	    /  \                / \
	   15   7              15  7
	The binary tree A is a height-balanced binary tree, but B is not
 * @author SirusBlack
 *
 */
public class BalancedBinaryTree {
	 public class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
	 }
	 
	    /**
	     * @param root: The root of binary tree.
	     * @return: True if this Binary tree is Balanced, or false.
	     */
	     
	    class ResultType{
	        public boolean isBalanced;
	        public int maxDepth;
	        public ResultType(boolean isBalanced, int maxDepth){
	            this.isBalanced =  isBalanced;
	            this.maxDepth = maxDepth;
	        }
	    }
	    public boolean isBalanced(TreeNode root) {
	        return helper(root).isBalanced;
	    }
	    
	    public ResultType helper(TreeNode root) {
	        if(root == null){
	            return new ResultType(true, 0);
	        }
	        
	        ResultType left = helper(root.left);
	        ResultType right = helper(root.right);
	        
	        // subtree not balance
	        if(!left.isBalanced || !right.isBalanced){
	            return new ResultType(false, -1);
	        }
	        
	        //root not balance
	        if(Math.abs(left.maxDepth - right.maxDepth) > 1){
	            return new ResultType(false, -1);
	        }
	        
	        return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
	    }
	  
	    
}
