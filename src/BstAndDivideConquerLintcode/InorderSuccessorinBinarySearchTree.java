package BstAndDivideConquerLintcode;
/**
 * Given a binary search tree (See Definition) and a node in it, find the in-order successor of that node in the BST.

	If the given node has no in-order successor in the tree, return null.
	
	Example
Given tree = [2,1] and node = 1:

  2
 /
1
return node 2.

Given tree = [2,1,3] and node = 2:

  2
 / \
1   3

return node 3.

 * @author SirusBlack
 *
 */
public class InorderSuccessorinBinarySearchTree {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}		
	}
	   public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	        // write your code here
		   
		   TreeNode successor = null;
		   while(root != null && root != p){
			   if(root.val > p.val){
				   successor = root;
				   root = root.left;
			   }else{
				   root = root.right;
			   }
		   }
		   
		   if(root == null){
			   return null;
		   }
		   
		   if(root.right == null){
			   return successor;
			   
		   }
		   
		   root = root.right;
		   
		   while(root.left != null){
			   root = root.left;
		   }
		   return root;
		   
	    }
}
