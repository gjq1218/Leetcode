package GraphAndSearch;
/*
 *Given a list, rotate the list to the right by k places, where k is non-negative.

Example
Given 1->2->3->4->5 and k = 2, return 4->5->1->2->3. 
 * 
 */
public class RotateList {
	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
		}
	}
	
public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || k <= 0){
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        ListNode cur = dummy;

        int length = 0;
        while(head.next != null){
            length += 1;
            head = head.next;
        }
        
        if(k > length){
            k = k % length;
        }
        
        if(k == 0){
        	return dummy.next;
        }
        
        int index = length - k;
        int curindex = 0;        
        
        while(cur.next != null && index != curindex){
            curindex += 1;
            cur = cur.next;
            if(curindex == index){
                break;
            }
        }

        ListNode newhead = cur.next;
        cur.next = null;
        head.next = dummy.next;
        
        return newhead;
    }

//九章写法更加整洁 见下面

	private int getLength(ListNode head) {
	    int length = 0;
	    while (head != null) {
	        length ++;
	        head = head.next;
	    }
	    return length;
	}


	public ListNode rotateRight2(ListNode head, int n) {
		if( head == null){
			return null;
		}
		
		int length = getLength(head);
		n = n % length;
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		
		ListNode tail = dummy;
		for(int i = 0; i < n; i++){
			head = head.next;
		}
		
		//一下循环不容易想到，通过使用head找到tail的位置. head此时已经在第k个位置， 走到底就是走了n-k个位置，tail往前走n-k个位置刚好是要求的尾巴。
		
		while(head.next != null){
		 	tail = tail.next;
		 	head = head.next;	
		}
		
		head.next = dummy.next;
		dummy.next = tail.next;
		tail.next = null;
		return dummy.next;
	}
	
	
	
	public static void main(String args[]){
		RotateList test = new RotateList();
		ListNode head = test.new ListNode(1);
		head.next = null;
		test.rotateRight(head, 99);
	}
	

}
