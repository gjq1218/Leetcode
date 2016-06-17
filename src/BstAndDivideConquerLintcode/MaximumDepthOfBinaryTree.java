package BstAndDivideConquerLintcode;
/**
 * Given a binary tree, find its maximum depth.
	
	The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
	
	Have you met this question in a real interview? Yes
	Example
	Given a binary tree as follow:
	
	  1
	 / \ 
	2   3
	   / \
	  4   5
	The maximum depth is 3.
 * @author SirusBlack
 *
 */
public class MaximumDepthOfBinaryTree {
	
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
     * @return: An integer.
     */
     // bad coding style;
     //Traverse
    // private int max;
    // public int maxDepth(TreeNode root) {
    //     // write your code here
    //     if(root == null){
    //         return 0;
    //     }
    //     this.max = -1;    
    //     traverse(root, 1);
    //     return this.max;
    // }
    
    // private void traverse(TreeNode root, int depth){
    //     if(root == null){
    //         return;
    //     }
        
    //     if(depth > this.max){
    //         this.max = depth;
    //     }
        
    //     traverse(root.left, depth + 1);
    //     traverse(root.right, depth + 1);
    // }
    
    
    //divide & conquer
      public int maxDepth(TreeNode root) {
        // write your code here
        
         if(root == null){
             return 0;
            
         }
        
         int left = maxDepth(root.left);
         int right = maxDepth(root.right);
         return  Math.max(left + 1, right + 1);
    }
    
    
}
