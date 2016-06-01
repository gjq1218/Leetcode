package Goo;
/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

	Note:
	Given target value is a floating point.
	You are guaranteed to have only one unique value in the BST that is closest to the target.
 *  https://segmentfault.com/a/1190000003797291
 *  根据二叉树的性质，我们知道当遍历到某个根节点时，最近的那个节点要么是在子树里面，要么就是根节点本身。所以我们根据这个递归，返回子树中最近的节点，和根节点中更近的那个就行了。
 * @author ginagao
 *
 */

public class ClosestBinarySearchTreeValue {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
    public int closestValue(TreeNode root, double target) {
    	TreeNode kid = target < root.val ? root.left: root.right;
    	
    	// if without any kid, return the current node.
    	if(kid == null){
    		return root.val;
    	}
    	// find the closest node in the subtree
    	int closest = closestValue(kid, target);
    	// return the closer one between the root and subtree.
    	return Math.abs(root.val - target) < Math.abs(closest - target) ? root.val : closest;
    }
}
