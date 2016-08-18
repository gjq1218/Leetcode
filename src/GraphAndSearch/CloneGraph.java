package GraphAndSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

How we serialize an undirected graph:

Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.

As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

   1
  / \
 /   \
0 --- 2
     / \
     \_/
     
     
 * @author SirusBlack
 *
 */
public class CloneGraph {
	
	 class UndirectedGraphNode {
		 	int label;
		 	ArrayList<UndirectedGraphNode> neighbors;
		 	UndirectedGraphNode(int x) { 
		 		label = x; 
		 		neighbors = new ArrayList<UndirectedGraphNode>(); 
		 	}
	};

	 public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		 if(node == null){
			 return node;
		 }
	
		 // use bfs algorithm to traverse the graph and get all the nodes.
		 ArrayList<UndirectedGraphNode> nodes = getAllNode(node);
		 
		 // copy nodes, store the old -> new mapping information.
		 HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
		 for(UndirectedGraphNode old: nodes){
			 map.put(old, new UndirectedGraphNode(old.label));
		 }
		 
		 // copy neighbours(edges)
		 
		 for(UndirectedGraphNode old: nodes){
			 UndirectedGraphNode newNode = map.get(old);
			 
			 for(UndirectedGraphNode neighour : old.neighbors){
				 UndirectedGraphNode newNeighour = map.get(neighour);
				 newNode.neighbors.add(newNeighour); 
			 }
		 }
		 
		 return map.get(node);
		 
	 
	 }
	 
	 public ArrayList<UndirectedGraphNode> getAllNode(UndirectedGraphNode node){
		
		 
		 Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		 HashSet<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
		 
		 queue.add(node);
		 visited.add(node);
		 
		 while(!queue.isEmpty()){
			 UndirectedGraphNode cur = queue.poll();
			 for(UndirectedGraphNode neighbour : cur.neighbors){
				if(!visited.contains(neighbour)){
					 queue.offer(neighbour);
					 visited.add(neighbour);
				} 
			 }
		 }
		 
		 return new ArrayList<UndirectedGraphNode>(visited);
		 
	 }

}
