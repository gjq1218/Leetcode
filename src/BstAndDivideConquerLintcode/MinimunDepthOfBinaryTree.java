package BstAndDivideConquerLintcode;
/**
 * Given a binary tree, find its minimum depth.

	The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
	
	Have you met this question in a real interview? Yes
	Example
	Given a binary tree as follow:
	
	  1
	 / \ 
	2   3
	   / \
	  4   5
	The minimum depth is 2.


 * @author SirusBlack
 *
 */
public class MinimunDepthOfBinaryTree {
	 public class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
	 }
	 
	 public int minDepth(TreeNode root) {
	        // write your code here
	        
	        if(root == null){
	            return 0;
	        }
	        
	        if(root.left == null && root.right == null){
	            return 1;
	        }
	        
	        int min = Integer.MAX_VALUE;
	        if(root.left != null){
	            min = Math.min(min, minDepth(root.left));
	            
	        }
	        
	         if(root.right != null){
	            min = Math.min(min, minDepth(root.right));
	            
	        }
	        
	        return min + 1;
	    }
}
