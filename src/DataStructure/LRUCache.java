package DataStructure;

import java.util.HashMap;

public class LRUCache {
	 
    public class Node{
        Node prev;
        Node next;
        int val;
        
        // This key is used for remove function. when you try to remove the oldest node, you need to find the hashmap's key according to head.next node. if there is no key variable point to the hashmap's key, you can not find corresponding key of head.next node.
        int key;
        
        public Node(int val, int key){
            this.val = val;
            this.key = key;
            this.prev = null;
            this.next = null;
        }
    }

     HashMap<Integer,Node> map = new HashMap<Integer,Node>();
     Node head = new Node(-1, -1);
     Node tail = new Node(-1, -1);
     int capacity;
     
     
    // @param capacity, an integer
    public LRUCache(int capacity) {
    
      this.capacity = capacity;
      head.next = tail;
      tail.prev = head;
    }

    // @return an integer
    public int get(int key) {
        // if map doesn't contain this key
        if(!map.containsKey(key)){
            return -1;
        }
        
        Node curNode = map.get(key);
        Node pre = curNode.prev;
        Node next = curNode.next;
        
        pre.next = next;
        next.prev = pre;
        
        move_to_tail(curNode);
        
        return map.get(key).val;
        
    }


    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        
        // which means map already contain the key.
        
        if(get(key) != -1){
            map.get(key).val = value;
            return;
        }
        
        
        if(map.size() == capacity){
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
            
        }
        
        Node insert = new Node(key, value);
        map.put(key, insert);
        move_to_tail(insert);
        
    }
    
    public void move_to_tail(Node curNode){
       
       curNode.prev = tail.prev;
       tail.prev = curNode;
       curNode.prev.next = curNode;
       curNode.next = tail;
       
    }
    
    public static void main(String args[]){
    	LRUCache test = new LRUCache(2);
    	test.set(2, 1);
    	test.set(1, 1);
    	test.get(2);
    	test.set(4, 1);
    	test.get(1);
    	test.get(2);
    	
    	
    }
}
