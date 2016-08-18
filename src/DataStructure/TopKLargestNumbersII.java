package DataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Implement a data structure, provide two interfaces:

	add(number). Add a new number in the data structure.
	topk(). Return the top k largest numbers in this data structure. k is given when we create the data structure.
	
	Example
	s = new Solution(3);
	>> create a new data structure.
	s.add(3)
	s.add(10)
	s.topk()
	>> return [10, 3]
	s.add(1000)
	s.add(-99)
	s.topk()
	>> return [1000, 10, 3]
	s.add(4)
	s.topk()
	>> return [1000, 10, 4]
	s.add(100)
	s.topk()
	>> return [1000, 100, 10]

 * @author SirusBlack
 *
 */
public class TopKLargestNumbersII {
	 // public class MyComparator implements Comparator<Integer>{
    //     public int compare(Integer o1, Integer o2){
    //         return o2 - o1;
    //     }
    // }
    PriorityQueue<Integer> heap;
    int capacity;
    
    public TopKLargestNumbersII(int k) {
       this.heap = new PriorityQueue<Integer>(k);
       this.capacity = k;
    }

    public void add(int num) {
        if(heap.size() < capacity){
            heap.offer(num);
            return;
        }
        
        if(num > heap.peek()){
            heap.poll();
            heap.offer(num);
        }
    }

    public List<Integer> topk() {
        
        // Integer[] array = heap.toArray(new Integer[0]);
        // List<Integer> res = new ArrayList<Integer>();
        // for(Integer i: array){
        //     res.add(i);
        // }
        // Collections.sort(res);
        // Collections.reverse(res);
        // return res;
        
    	List<Integer> res = new ArrayList<Integer>();
        Iterator<Integer> it = heap.iterator();
        while(it.hasNext()){
        	res.add((Integer) it.next());
        }
        Collections.sort(res, Collections.reverseOrder());
        return res;
    }
}
