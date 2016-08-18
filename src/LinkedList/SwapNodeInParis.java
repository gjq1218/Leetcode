package LinkedList;
/**
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.

Have you met this question in a real interview? Yes
Example
Given 1->2->3->4, you should return the list as 2->1->4->3.


 * @author SirusBlack
 *
 */
public class SwapNodeInParis {
	 /**
     * @param head a ListNode
     * @return a ListNode
     */
	
	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
		}
	}
    public ListNode swapPairs(ListNode head) {
    	
    	if(head == null){
    		return head;
    	}
    	
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head;
    	head = dummy;
    	
    
    	while( head.next != null && head.next.next != null ){
    		ListNode pre = head.next;
        	ListNode cur = head.next.next;
        	
        	head.next = cur;
        	pre.next = cur.next;       	
        	cur.next = pre;
        	
        	// head = pre 这块比较难想到。这里要以移动 head为基准。
        	head = pre;
        	
    	}
    			
    	return dummy.next;
    	
    }
}
