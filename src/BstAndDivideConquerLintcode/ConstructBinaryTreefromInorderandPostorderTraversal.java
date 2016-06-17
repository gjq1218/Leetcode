package BstAndDivideConquerLintcode;

import java.util.HashMap;


/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.

 Notice

You may assume that duplicates do not exist in the tree.

Have you met this question in a real interview? Yes
Example
Given inorder [1,2,3] and postorder [1,3,2], return a tree:

  2
 / \
1   3

	 * We assume that there is no duplicate in the trees.
     *  For example:
     *          1
     *         / \
     *        2   3
     *       /\    \
     *      4  5    6
     *              /\
     *             7  8  
     *             
     *  PostOrder should be: 4 5 2   7 8 6 3    1
     *                      左子树    右子树      根   
     *  InOrder should be:  4 2 5   1   3 7 6 8
     *                       左子树  根  右子树
     *                       
     *                       
     *思路根由中序和前序遍历得到二叉树很相像。                       
 * @author SirusBlack
 *
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
	  public class TreeNode {
		public int val;
		public TreeNode left, right;
		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		 	}
	  }
	 
	  public TreeNode buildTree(int[] inorder, int[] postorder) {
	       if(inorder == null || postorder == null){
	    	   return null;
	       }
	       HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	       
	       for(int i = 0; i < inorder.length; i++){
	    	   map.put(inorder[i], i);
	       }
	       return helperFromInPos(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
	   }
	  public TreeNode helperFromInPos(int[] inorder,int inL, int inR, int[] postorder, int posL, int posR, HashMap<Integer, Integer> map){
		  if(inL > inR || posL > posR){
			  return null;
		  }
		  
		  TreeNode root = new TreeNode(postorder[posR]);
		  
		  int index = map.get(root.val);  
		  root.left = helperFromInPos(inorder, inL, index - 1, postorder, posL, posL + index - inL - 1, map);
		  root.right = helperFromInPos(inorder, index + 1, inR, postorder, posL + index - inL, posR - 1, map);
		  
		  return root;
		  
	  }
	  
}
