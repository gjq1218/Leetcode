package GraphAndSearch;

import GraphAndSearch.RotateList.ListNode;

/**
 * Sort a linked list using insertion sort.

Have you met this question in a real interview? Yes
Example
Given 1->3->2->0->null, return 0->1->2->3->null.

 * @author SirusBlack
 *
 */


public class InsertionSortList {
	 /**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
	
	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
		}
	}
    public ListNode insertionSortList(ListNode head) {

    	ListNode dummy = new ListNode(0);
    	
    	while(head != null){
    		ListNode node = dummy;
    		while( node.next != null && node.next.val < head.val){
    			node = node.next;
    		}
    		
    		ListNode temp = head.next;
    		head.next = node.next;
    		node.next = head;
    		head = temp;
    	}
    	
    	return dummy.next;
    
    }
    
}
