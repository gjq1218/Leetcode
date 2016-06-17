package BstAndDivideConquerLintcode;

import java.util.ArrayList;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.

	Have you met this question in a real interview? Yes
	Example
	Given binary tree {1,#,2,3},
	
	   1
	    \
	     2
	    /
	   3
	 
	
	return [3,2,1].
 * @author SirusBlack
 *
 */
public class BinaryTreePostorderTraversal {
	 public class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
	 }
	 
	  // Traverse
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if(root == null){
            return res;
        }
        
        postorder(res, root);
        return res;
    }
    
    public void postorder(ArrayList<Integer> res, TreeNode root){
        if(root == null){
            return ;
        }
        
        postorder(res, root.left);
        postorder(res, root.right);
        res.add(root.val);
    }
}
