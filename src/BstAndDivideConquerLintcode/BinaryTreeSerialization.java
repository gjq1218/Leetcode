package BstAndDivideConquerLintcode;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Design an algorithm and write code to serialize and deserialize a binary tree. Writing the tree to a file is called 'serialization' and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.

There is no limit of how you deserialize or serialize a binary tree, you only need to make sure you can serialize a binary tree to a string and deserialize this string to the original structure.

Have you met this question in a real interview? Yes
Example
An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:

  3
 / \
9  20
  /  \
 15   7
Our data serialization use bfs traversal. This is just for when you got wrong answer and want to debug the input.

You can use other method to do serializaiton and deserialization.

http://blog.csdn.net/ljiabin/article/details/49474445
 * @author SirusBlack
 *
 */
public class BinaryTreeSerialization {
	public class TreeNode{
		public int val;
		public TreeNode left, right;
		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	 /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
    	if(root == null){
    		return null;
    	}
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	StringBuilder sb = new StringBuilder();
    	
    	queue.offer(root);
    	while(!queue.isEmpty()){
    		TreeNode cur = queue.poll();
    		if(cur == null){
    			sb.append("null" + ",");
    		}else{
    			sb.append(cur.val + ",");
    			queue.offer(cur.left);
    			queue.offer(cur.right);
    		}
    	}
    	sb.deleteCharAt(sb.length() - 1);
    	return sb.toString();
    }
   
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
    	if(data == null ||  data.length() == 0) return null;
    	
    	
    	String[] val = data.split(",");
    	int[] nums = new int[val.length + 1];
    	TreeNode[]  nodes = new TreeNode[val.length];
    	
    	for(int i = 0; i < val.length; i++){
    		if(i > 0){
    			nums[i] = nums[i - 1];
    		}
    		
    		if(val[i].equals("null"))
    		{
    			nodes[i] = null;
    			nums[i]++;
    		}else{
    			nodes[i] = new TreeNode(Integer.parseInt(val[i]));
    		}
    	}
    	
    	for(int i = 0; i < val.length; i++){
    		
    		if(nodes[i] == null){
    			continue;
    		}
    		nodes[i].left = nodes[2*(i - nums[i]) + 1];
    		nodes[i].right = nodes[2*(i-nums[i]) + 2];
    				
    	}
    	
    	return nodes[0];
	 }
    
    public static void main(String args[]){
    	BinaryTreeSerialization test = new BinaryTreeSerialization();
    	TreeNode root =  test.new TreeNode(3);
    	TreeNode node1 =  test.new TreeNode(9);
    	TreeNode node2 =  test.new TreeNode(20);
    	TreeNode node3 =  test.new TreeNode(15);
    	TreeNode node4 =  test.new TreeNode(7);
    
//    	root.left = node1;
//    	root.right = node2;
//    	node2.left = node3;
//    	node2.right = node4;
    	
    	String res = test.serialize(root);
    	System.out.println(res);
    	
    	TreeNode resNode = test.deserialize(res);
    	System.out.println(resNode.val);
    }
    
}
