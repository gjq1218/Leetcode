package BstAndDivideConquerLintcode;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.

Have you met this question in a real interview? Yes
Example
Given:

    1
   / \
  2   3
 / \
4   5
return [1,2,4,5,3].
 * @author SirusBlack
 *
 */


import java.util.ArrayList;

public class BinaryTreePreorderTraversal {
	 public class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
	 }
	 // traversal
    
    // public ArrayList<Integer> preorderTraversal(TreeNode root) {
    //     // write your code here
    //     ArrayList<Integer> res = new ArrayList<Integer>();
    //     traverse(root, res);
    //     return res;
        
    //     // if(root == null){
    //     //     return this.res;
    //     // }
    //     // res.add(root.val);
    //     // preorderTraversal(root.left);
    //     // preorderTraversal(root.right);
        
    //     // return res;
    // }
    // public void  traverse(TreeNode root, ArrayList<Integer> res){
    //     if(root == null){
    //         return;
    //     }
    //     res.add(root.val);
    //     traverse(root.left, res);
    //     traverse(root.right, res);
    // }
    
    
    // divide and conquer
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
         ArrayList<Integer> res = new ArrayList<Integer>();
         if(root == null){
              return res;
         }   
        //divide
        
        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);
        
        // conquer
        res.add(root.val);
        res.addAll(left);
        res.addAll(right);
        return res;
        
    }
}
