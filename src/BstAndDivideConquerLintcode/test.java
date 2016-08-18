package BstAndDivideConquerLintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Template.TreeConclusion.TreeNode;

public class test {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
		         this.val = val;
		         this.left = this.right = null;
		}
	}
	 public String serialize(TreeNode root) {
			if(root == null){
				return "{}";
			}
			// use BFS
		
			StringBuilder sb = new StringBuilder();
			sb.append("{");
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			
			while(!queue.isEmpty()){
				
				TreeNode cur = queue.poll();
				
				if(cur == null){
					sb.append("#" + ",");
				}else{
					sb.append(cur.val + ",");
					queue.offer(cur.left);
					queue.offer(cur.right);
					
				}	
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append("}");
			return sb.toString();

		 }
		 
		 //3,9,20,#,#,15,7
		 // val: 3 9 20 # # 15 7
	    public TreeNode deserialize(String data) {
	    	if(data.equals("{}")){
	    		return null;
	    	}
	    	String[] vals = data.substring(1, data.length() - 1).split(",");
	    	ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
	    	TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
	    	
	    	queue.add(root);
	    	
	    	int index = 0;
	    	boolean isLeftChild = true;
	    	
	    	for(int i = 1; i < vals.length; i++){
	    		if(!vals[i].equals("#")){
	    			TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
	    			if(isLeftChild){
	    				queue.get(index).left = node;
	    			}else{
	    				queue.get(index).right = node;
	    			}
	    			queue.add(node);
	    		}
	    		
	    		// 这里意思是只有不是左孩子了，以为着下一层要开始了。
	    		if(!isLeftChild){
	    			index++;
	    		}
	    		isLeftChild = !isLeftChild;
	    	}
	    	return root;
	    }
	    public static void main(String args[]){
	    	test test = new test();
	    	TreeNode root =  test.new TreeNode(3);
	    	TreeNode node1 =  test.new TreeNode(9);
	    	TreeNode node2 =  test.new TreeNode(20);
	    	TreeNode node3 =  test.new TreeNode(15);
	    	TreeNode node4 =  test.new TreeNode(7);
	    
//	    	root.left = node1;
//	    	root.right = node2;
//	    	node2.left = node3;
//	    	node2.right = node4;
	    	
	    	String res = test.serialize(root);
	    	System.out.println(res);
	    	
	    	TreeNode resNode = test.deserialize(res);
	    	System.out.println(resNode.val);
	    }
}
