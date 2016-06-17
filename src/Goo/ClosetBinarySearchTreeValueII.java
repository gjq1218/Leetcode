package Goo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:
Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 * @author SirusBlack
 *
 */
public class ClosetBinarySearchTreeValueII {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Queue<Integer> klist = new LinkedList<Integer>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        
        while(root != null){
        	stk.push(root);
        	root = root.left;
        }
        
        while(!stk.isEmpty()){
        	// Inorder
        	TreeNode curr = stk.pop();
        	//maintain a k size queue
        	//is the size is less than k, then add it directly
        	if(klist.size() < k){
        		klist.offer(curr.val);
        	}else{
        		// when the queue size is k, judge if the new number is closer, if yes, then add it into the queue and remove the head.
        		int first = klist.peek();
        		if(Math.abs(first - target) > Math.abs(curr.val - target)){
        			klist.poll();
        			klist.offer(curr.val);
        		}else{
        			// if it's not the closer node, then break, because the following nodes will just become bigger.
        			break;
        		}
        	}
        	// inorder's code
        	if(curr.right != null){
        		curr = curr.right;
        		while(curr != null){
        			stk.push(curr);
        			curr = curr.left;
        		}
        	}
        }
        return (List<Integer>) klist;
    }
}
