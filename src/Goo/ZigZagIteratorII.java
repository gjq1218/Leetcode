package Goo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Follow up Zigzag Iterator: What if you are given k 1d vectors? How well can your code be extended to such cases? The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic".

	Example
	Given k = 3 1d vectors:
	
	[1,2,3]
	[4,5,6,7]
	[8,9]
	Return [1,4,8,2,5,9,3,6,7]
 * @author SirusBlack
 *
 */
public class ZigZagIteratorII {
    /**
     * @param vecs a list of 1d vectors
     */
	
	List<Iterator<Integer>> itlist;
	Queue<Iterator<Integer>> queue;
	
    public ZigZagIteratorII(ArrayList<ArrayList<Integer>> vecs) {
        // initialize your data structure here.
    	
    	queue = new LinkedList<>();
    	this.itlist = new LinkedList<Iterator<Integer>>();
    	for(ArrayList<Integer> list : vecs){
    		itlist.add(list.iterator());
    		queue.add(list.iterator());
    	}
    	
    }

    public int next() {
        Iterator<Integer> currIterator = queue.poll();
        Integer res = currIterator.next();
        if(currIterator.hasNext()){
        	queue.offer(currIterator);
        }
        
        return res;
    }

    public boolean hasNext() {
        return !queue.isEmpty();  
    }
}

/**
 * Your ZigzagIterator2 object will be instantiated and called as such:
 * ZigzagIterator2 solution = new ZigzagIterator2(vecs);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */