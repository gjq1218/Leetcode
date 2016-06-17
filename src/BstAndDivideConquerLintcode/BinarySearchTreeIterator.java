package BstAndDivideConquerLintcode;

import java.util.ArrayList;

/**
 * Design an iterator over a binary search tree with the following rules:

	Elements are visited in ascending order (i.e. an in-order traversal)
	next() and hasNext() queries run in O(1) time in average.
	Have you met this question in a real interview? Yes
	Example
	For the following binary search tree, in-order traversal by using iterator is [1, 6, 10, 11, 12]
	
	   10
	 /    \
	1      11
	 \       \
	  6       12
 * @author SirusBlack
 *
 */
public class BinarySearchTreeIterator {
	 public class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
	 }
	 
    ArrayList<TreeNode> res = new ArrayList<TreeNode>();
    int index;
    
    public void inOrder(TreeNode node, ArrayList<TreeNode> res){
        if(node == null){
            return;
        }
        inOrder(node.left, res);
        res.add(node);
        inOrder(node.right, res);
    }
    //@param root: The root of binary tree.
    public BinarySearchTreeIterator(TreeNode root) {
        // write your code here
         inOrder(root, res);
         index = 0; 
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        if(index < res.size()){
            return true;
        }
        return false;
        
    }
    
    //@return: return next node
    public TreeNode next() {
        TreeNode now =  res.get(index);
        index = index + 1;
        return now;
    }

}
