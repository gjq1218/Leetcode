package BstAndDivideConquerLintcode;
/**
 * Given a binary search tree (See Definition) and a node in it, find the in-order successor of that node in the BST.

	If the given node has no in-order successor in the tree, return null.
	找到一个节点的中序后继节
	
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
		   
		   //如果root比p大， 那么successor不是root就是在root的左子树里， 反之，去右子树里面找
		   while(root != null && root != p){
			   if(root.val > p.val){
				   successor = root;
				   root = root.left;
			   }else{
				   root = root.right;
			   }
		   }
		   //此时root要么等于p,root要么等于null。 如果找到叶子节点的子孩子还没有找到，那么返回null
		   if(root == null){
			   return null;
		   }
		   //前面排除了等于null的可能，那么就是root等于p。如果p右边没有孩子了就返回Successor。例如14，20的情况。
		   if(root.right == null){
			   return successor;
			   
		   }
		   //如果root.right即p.right不为空，那么successor就是p的右孩子里面最左边的那一个。
		   root = root.right;
		   
		   while(root.left != null){
			   root = root.left;
		   }
		   return root;
		   
	    }
}
