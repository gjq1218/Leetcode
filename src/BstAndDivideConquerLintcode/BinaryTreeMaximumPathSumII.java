package BstAndDivideConquerLintcode;
/**
 * Given a binary tree, find the maximum path sum from root.

The path may end at any node in the tree and contain at least one node in it.

Have you met this question in a real interview? Yes
Example
Given the below binary tree:

  1
 / \
2   3
return 4. (1->3)
 * @author SirusBlack
 *
 */
public class BinaryTreeMaximumPathSumII {
	 public class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
	 }
	 public int maxPathSum2(TreeNode root) {
	        if(root == null){
				 return Integer.MIN_VALUE;
			 }
			 
			 int left = maxPathSum2(root.left);
			 int right = maxPathSum2(root.right);
			 
			 if(left < 0 && right < 0){
				 return root.val;
			 }else{
				 return Math.max(left, right) + root.val;
			 }
	    }
}
