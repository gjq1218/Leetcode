package BstAndDivideConquerLintcode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val){
			this.val = val;
			left = right = null;
		}
	}
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<String>();
        
        if(root == null){
            return res;
        }
        
        String path = String.valueOf(root.val);
        
        helper(root, res, path);
        return res;
    }
    
    public void helper(TreeNode root, List<String> res, String path){
        if(root.left == null && root.right == null){
            res.add(new String(path));
            return;
        }
        
        if(root.left != null){
            helper(root.left, res, path + "->" + String.valueOf(root.left.val));
        
          
        }
        
         if(root.right != null){
          //  path = path + "->" + Integer.toString(root.right.val);;
          
            helper(root.right, res, path + "->" + String.valueOf(root.right.val));
  
        }
    }
}
