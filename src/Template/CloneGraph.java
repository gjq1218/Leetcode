package Template;

import java.util.*;

public class CloneGraph {

	 class UndirectedGraphNode {
	     int label;
	     ArrayList<UndirectedGraphNode> neighbors;
	     UndirectedGraphNode(int x) { 
	    	 label = x; 
	    	 neighbors = new ArrayList<UndirectedGraphNode>(); 
	     }
	 }


	 class StackElement{
	 	public UndirectedGraphNode node;
	 	public int neighborIndex;
	 	public StackElement(UndirectedGraphNode node, int neighborIndex){
	 		this.node = node;
	 		this.neighborIndex = neighborIndex;
	 	}
	 }

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
		if(node == null){
			return node;
		}

		// use dfs algorithm to traverse the graph and get all nodes.

		ArrayList<UndirectedGraphNode> nodes = getNodes(node);

		// copy nodes, store the old -> new mapping information in a hash map
		HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();

		for(UndirectedGraphNode n: nodes){
			mapping.put(n, new UndirectedGraphNode(n.label));
		}

		// copy neighbors(edges)
		for(UndirectedGraphNode n: nodes){
			UndirectedGraphNode newNode = mapping.get(n);
			for(UndirectedGraphNode neighbor : n.neighbors){
				UndirectedGraphNode newNeigbor = mapping.get(neighbor);
				newNode.neighbors.add(newNeigbor);
			}
		}

		return mapping.get(node);


	}

	public ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node){
		Stack<StackElement> stack = new Stack<StackElement>();
		HashSet<UndirectedGraphNode> set = new HashSet<>();
		stack.push(new StackElement(node, -1));
		set.add(node);
		
		while(!stack.isEmpty()){
			StackElement current = stack.peek();
			current.neighborIndex++;

			if(current.neighborIndex == current.node.neighbors.size()){
				stack.pop();
				continue;
			}

			UndirectedGraphNode neighbor = current.node.neighbors.get(current.neighborIndex);

			// check if we visited this neighbor before
			if(set.contains(neighbor)){
				continue;
			}

			stack.push(new StackElement(neighbor, -1));
			set.add(neighbor);

		}

		return new ArrayList<UndirectedGraphNode>(set);
	}
}