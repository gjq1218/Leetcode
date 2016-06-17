package BstAndDivideConquerLintcode;
/**
 * Given a binary tree, find the maximum path sum.

	The path may start and end at any node in the tree.
	
	Have you met this question in a real interview? Yes
	Example
	Given the below binary tree:
	
	  1
	 / \
	2   3
	return 6.
 * @author SirusBlack
 *
 */
public class BinaryTreeMaximunPathSum {
	 public class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
	 }
	 
	public class ResultType{
	        
	        int singlePath, maxPath;
	        ResultType( int singlePath, int maxPath){
	                
	            this.singlePath = singlePath;
	            this.maxPath = maxPath;
	            
	        }
	    }
	     
	    public int maxPathSum(TreeNode root) {
	        ResultType result = helper(root);
	        return result.maxPath;
	    }
	    
	    private ResultType helper(TreeNode root){
	           // write your code here
	        if(root == null){
	             return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
	        }
	        
	        //Divide
	        
	        ResultType left = helper(root.left);
	        ResultType right = helper(root.right);
	        
	        // Conquer  == root to any
	        int singlePath = Math.max(0, Math.max(left.singlePath, right.singlePath)) + root.val;
	        //== any to any
	        int maxPath = Math.max(left.maxPath, right.maxPath);
	        // == any to any
	        maxPath = Math.max(maxPath, Math.max(left.singlePath,0) + Math.max(right.singlePath,0) + root.val);
	        
	        return new ResultType(singlePath, maxPath);
	     
	    }    
}
