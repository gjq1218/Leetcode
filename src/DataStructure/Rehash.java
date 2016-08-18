package DataStructure;
/**
 * The size of the hash table is not determinate at the very beginning. If the total size of keys is too large (e.g. size >= capacity / 10), we should double the size of the hash table and rehash every keys. Say you have a hash table looks like below:

size=3, capacity=4

[null, 21, 14, null]
       ↓    ↓
       9   null
       ↓
      null
The hash function is:

int hashcode(int key, int capacity) {
    return key % capacity;
}
here we have three numbers, 9, 14 and 21, where 21 and 9 share the same position as they all have the same hashcode 1 (21 % 4 = 9 % 4 = 1). We store them in the hash table by linked list.

rehashing this hash table, double the capacity, you will get:

size=3, capacity=8

index:   0    1    2    3     4    5    6   7
hash : [null, 9, null, null, null, 21, 14, null]

 * @author SirusBlack
 *
 */
public class Rehash {
	public class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
			next = null;
		}
	}
	public ListNode[] rehashing(ListNode[] hashTable) {
        if(hashTable == null || hashTable.length == 0){
            return hashTable;
        }
        
        int newcapacity = 2 * hashTable.length;
        ListNode[] newtable = new ListNode[newcapacity];
        
        for(int i = 0; i < hashTable.length; i++){
            while(hashTable[i] != null){
                int newIndex = (hashTable[i].val % newcapacity + newcapacity)% newcapacity;
                if(newtable[newIndex] == null){
                    newtable[newIndex] = new ListNode(hashTable[i].val);
                }else{
                    ListNode dummy = newtable[newIndex];
                    
                    
                    while(dummy.next != null){
                        dummy = dummy.next;
                    }
                    dummy.next =  new ListNode(hashTable[i].val);
                    
 // 这里注意一下写法是错误的，因为最后的dummy创建了一个新的node 没有和之前的dummy连起来，所以找不到新生成的节点，一定要向前面dummy.next这样连上。
                    
//                    while(dummy != null){
//                        dummy = dummy.next;
//                    }
//                    dummy =  new ListNode(hashTable[i].val);
                }
                hashTable[i] = hashTable[i].next;
            }
        }
        
        return newtable;
    }
	public static void main(String args[]){
		Rehash test = new Rehash();
//		ListNode a;
		ListNode b = test.new ListNode(29);
		ListNode c = test.new ListNode(5);
//		ListNode d = test.new ListNode(14);
//		ListNode e;
//		
		b.next = c;
		c.next = null;
	
		
		ListNode[] hashTable = {null, null, b};
		test.rehashing(hashTable);
	}
}
