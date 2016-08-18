package Goo;

public class MianJing_LinkedList {
	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
		}
	}
	
	public void swap(ListNode head){
		//ListNode sec = new ListNode(-1);
		
		if(head == null || head.next == null){
			
			return;
		}
		
		
		ListNode dummyhead = new ListNode(Integer.MIN_VALUE);
		dummyhead.next = head;
		head = dummyhead;
		
		
		ListNode fast = head;
		
		ListNode first = head.next;
		ListNode second = head;

		
		while(fast.next != null){
			if(fast.next.val > first.val ){
				first = fast.next;
				
				if( fast.val > second.val && fast.val < first.val){
					second = fast;
				}
				
			}else{
				if(fast.next.val > second.val && fast.next.val < first.val){
					second = fast.next;
				}
			}
			fast = fast.next;
		}
		
		ListNode temp = first;
		first = second;
		second = temp;
		
		
		System.out.println(first.val);
		System.out.println(second.val);
		
	}
	
	public static void main(String args[]){
		MianJing_LinkedList test = new MianJing_LinkedList();
		ListNode node1 = test.new ListNode(4);
		ListNode node2 = test.new ListNode(8);
		ListNode node3 = test.new ListNode(3);
		ListNode node4 = test.new ListNode(6);
		ListNode node5 = test.new ListNode(7);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		test.swap(node1);
		
	}
	
	
}
