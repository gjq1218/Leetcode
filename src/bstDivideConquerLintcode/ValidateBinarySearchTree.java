package bstDivideConquerLintcode;

import java.util.Stack;

/*Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
A single node tree is a BST
Have you met this question in a real interview? Yes
Example
An example:

  2
 / \
1   4
   / \
  3   5
The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).
http://www.cnblogs.com/yuzhangcmu/p/4177047.html
*/


public class ValidateBinarySearchTree {
	 /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
	
	public class TreeNode{
		public int val;
		public TreeNode left, right;
		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	
	// solution 1: use Iterator in order method, judge if the sequence is a increasing sequence.
	 public boolean isValidBST(TreeNode root) {
		 
		 if(root == null){
			 return true;
		 }
		 
		 
		 Stack<TreeNode> s = new Stack<TreeNode>();
		 TreeNode cur = root;
		 
		 TreeNode pre = null;
		 
		 while(true){
			 //push all the left node into the stack.
			 while(cur != null){
				 s.push(cur);
				 cur = cur.left;
			 }
			 
			 if(s.isEmpty()){
				 break;
			 }
			 
			 // No more left node, start deal with current node.
			 cur = s.pop();
			 if(pre != null && pre.val >= cur.val){
				 return false;
			 }
			 
			 pre = cur;
			 cur = cur.right;
			 
		 }
		 
		 
		 
	 }
	 
    public boolean isValidBST2(TreeNode root) {
        // write your code here
    	
    	if(root == null){
    		return true;
    	}
    	
    	if(root.val < root.left.val){
    		return false;
    	}
    	if(root.val > root.right.val){
    		return false;
    	}
    	
    	
    	boolean left = isValidBST(root.left);
    	boolean right = isValidBST(root.right);
    	
    	return left && right;
    	
    }
}
