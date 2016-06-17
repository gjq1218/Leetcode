package BstAndDivideConquerLintcode;

import java.util.ArrayList;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
	
	Have you met this question in a real interview? Yes
	Example
	Given binary tree {1,#,2,3},
	
	   1
	    \
	     2
	    /
	   3
	 
	
	return [1,3,2].
 * @author SirusBlack
 *
 */
public class BinaryTreeInorderTraversal {
	
	 public class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
	 }
	 
	//Traverse.
    // public ArrayList<Integer> inorderTraversal(TreeNode root) {
    //     // write your code here
    //     ArrayList<Integer> res = new ArrayList<Integer>();
    //     if(root == null){
    //         return res;
    //     }   

    //     // if(root.left == null && root.right == null){
    //     //     return res;
    //     // }
        
    //     inorder( root, res);
        
    //     return res;
            
    // }
    
    // public void inorder(TreeNode root, ArrayList<Integer> res){
        
    //     if(root == null){
    //         return;
    //     }
    //     inorder(root.left, res);
    //     res.add(root.val);
    //     inorder(root.right, res);

    // }
    
    //divide and conquer
   
     public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        // null or leaf
        if(root == null){
            return res;
        }
        
        //divide
        ArrayList<Integer> left = inorderTraversal(root.left);
        ArrayList<Integer> right = inorderTraversal(root.right);
        //conquer
        
        res.addAll(left);
        res.add(root.val);
        res.addAll(right);
        
        return res;
    }
}
