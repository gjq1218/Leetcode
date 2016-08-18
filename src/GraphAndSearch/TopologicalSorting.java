package GraphAndSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an directed graph, a topological order of the graph nodes is defined as follow:

For each directed edge A -> B in graph, A must before B in the order list.
The first node in the order can be any node in the graph with no nodes direct to it.
Find any topological order for the given graph.

 Notice

You can assume that there is at least one topological order in the graph.

Clarification
Learn more about representation of graphs

Example
For graph as follow:

picture

The topological order can be:

[0, 1, 2, 3, 4, 5]
[0, 2, 3, 1, 5, 4]
 * @author SirusBlack
 *
 */
public class TopologicalSorting {
	 /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
	class DirectedGraphNode{
		int val;
		ArrayList<DirectedGraphNode> neighbors;
		public DirectedGraphNode(int val){
			this.val = val;
			this.neighbors = new ArrayList<DirectedGraphNode>();
		}
	}
		 
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
       if(graph == null){
    	   return graph;
       }
       
       // store the node's in-degree into the map.
       ArrayList<DirectedGraphNode> res = new  ArrayList<DirectedGraphNode>();
       HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
  

       for(DirectedGraphNode node: graph){
    	   for(DirectedGraphNode neighbor: node.neighbors){
    		   if(!map.containsKey(neighbor)){
    			   map.put(neighbor, 1);
    		   }else{
    			   map.put(neighbor, map.get(neighbor) + 1);
    		   }
    	   }
       }
       // find the 0 in-degree's node.
       Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
       for(DirectedGraphNode node: graph){
    	   if(!map.containsKey(node)){
    		   queue.offer(node);
    		   res.add(node);
    	   }
       }
       // use bfs to traverse the graph.
       
       while(!queue.isEmpty()){
    	   DirectedGraphNode cur = queue.poll();
    	     	   
    	   for(DirectedGraphNode neighbor: cur.neighbors){    		   
    		   map.put( neighbor, map.get(neighbor) - 1);
    		  
    		   if(map.get(neighbor) == 0){   			  
    			  res.add(neighbor);
    			  queue.offer(neighbor);
    		   }
    	   }
       }
       return res;
    }
	
}
