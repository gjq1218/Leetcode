package BstAndDivideConquerLintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.

	A valid path is from root node to any of the leaf nodes.
	
	Have you met this question in a real interview? Yes
	Example
	Given a binary tree, and target = 5:
	
	     1
	    / \
	   2   4
	  / \
	 2   3
	return
	
	[
	  [1, 2, 2],
	  [1, 4]
	]
 * @author SirusBlack
 *
 */
public class BinaryTreePathSum {
	
	 public class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
	 }
	 
	 
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if(root == null){
        return res;
    }
    ArrayList<Integer> path = new  ArrayList<>();
    path.add(root.val);
    
    traverse( root, path, root.val, res, target);
    return res;
}

	public void traverse(TreeNode root, ArrayList<Integer> path, int sum, List<List<Integer>> res, int target ){
	    // meet leaf
	    if(root.right == null && root.left == null){
	        if(sum == target){
	            res.add(new ArrayList<Integer>(path));
	        }
	        return;
	    }
	    // go left
	    if(root.left != null){
	        path.add(root.left.val);
	        traverse(root.left, path, sum + root.left.val, res, target);
	        path.remove(path.size() - 1);
	    }
	    //go right
	    if(root.right != null){
	        path.add(root.right.val);
	        traverse(root.right, path, sum + root.right.val, res, target);
	        path.remove(path.size() - 1);
	    }
	
	}
}
