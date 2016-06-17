package BstAndDivideConquerLintcode;

import java.util.HashMap;

/**
	Given preorder and inorder traversal of a tree, construct the binary tree.
	
	 Notice
	
	You may assume that duplicates do not exist in the tree.
	
	Have you met this question in a real interview? Yes
	Example
	Given in-order [1,2,3] and pre-order [2,1,3], return a tree:
	
	  2
	 / \
	1   3


 	We assume that there is no duplicate in the trees.
     *  For example:
     *          1
     *         / \
     *        2   3
     *       /\    \
     *      4  5    6
     *              /\
     *             7  8  
     *             
     *  PreOrder should be: 1   2 4 5   3 6 7 8
     *                      根   左子树    右子树  
     *  InOrder should be:  4 2 5   1   3 7 6 8
     *                       左子树  根  右子树
	从preorder来确定根，再从中序遍历来将序列分成左右字数。进行递归。算法最终相当于一次树的遍历，每个结点只会被访问一次，所以时间复杂度是O(n)。
	http://blog.csdn.net/linhuanmars/article/details/24389549
 * @author SirusBlack
 *
 */


public class ConstructBinaryTreeFromPreorderandInorderTraversal {
	  public class TreeNode {
		public int val;
		public TreeNode left, right;
		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		 	}
		}
	 public TreeNode buildTree(int[] preorder, int[] inorder) {
	        if(preorder == null || inorder == null){
	        	return null;
	        }
	        //Hashmap 用于中序数组中，根据根找到对应的下标。用来区分左右子树所在位置。
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for(int i = 0; i < inorder.length; i++){
	        	map.put(inorder[i], i);
	        }
	        
	        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
	   }
	 
	 public TreeNode helper(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR, HashMap<Integer, Integer> map){
		 if(preL > preR || inL > inR){
			 return null;
		 }
		 TreeNode root = new TreeNode(preorder[preL]);	 
		 int index = map.get(root.val);
		 root.left = helper(preorder, preL + 1, preL + index - inL, inorder, inL, index - 1, map);
		 root.right = helper(preorder, preL + index - inL + 1,preR, inorder, index + 1, inR, map);
		 return root;
		 
	 }
	 
	 
}
