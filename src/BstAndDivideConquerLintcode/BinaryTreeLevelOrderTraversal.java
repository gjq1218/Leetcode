package BstAndDivideConquerLintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

	Have you met this question in a real interview? Yes
	Example
	Given binary tree {3,9,20,#,#,15,7},
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	 
	
	return its level order traversal as:
	
	[
	  [3],
	  [9,20],
	  [15,7]
	]
 * @author SirusBlack
 *
 */
public class BinaryTreeLevelOrderTraversal {
	
	 public class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
	 }
	 
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
       if(root == null){
           return res;
       }
     
       Queue<TreeNode> queue = new LinkedList<TreeNode>();
       queue.offer(root);
       queue.offer(null); // add a dummy node to justify the level.
       
        ArrayList<Integer> oneres = new ArrayList<Integer>();
       
       while(!queue.isEmpty()){
           TreeNode cur = queue.poll();
           
           if(cur == null){ // means a level is finished traversal.
               
              if(oneres.size() == 0){
                   break;
               }

               res.add(oneres);
               oneres = new ArrayList<Integer>();
               queue.offer(null); //  add a dummy node.
               continue;
               
           }
           oneres.add(cur.val);
           
           if(cur.left != null){
               queue.offer(cur.left);
           }
           if(cur.right != null){
               queue.offer(cur.right);
           }
           
       }
       
       return res;
    }      
}
