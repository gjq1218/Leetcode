package Template;

import java.util.HashSet;

public class MyHashmap<K,V>{
    
	   int capacity = 16;
	   double load_factor = 0.75;
	   int number_Entry = 0;
	   HashSet<Entry<K,V>> entryset = new HashSet<Entry<K,V>>();
	   Entry<K,V>[] bucket = new Entry<K,V>[capacity];
	   
	   MyHashmap<K,V>()
	   {
	   }
	 
	   public V put(K key, V value)
	   {
	       int hashcode = key.hashCode();
	       int position = hashcode % capacity;
	       
	       Entry<K,V> newentry = new Entry<K,V>(key,value);
	       
	       if(entryset.contains(newentry))
	       {
	           //TODO
	            return V;
	       }
	       else
	       {
	            number_Entry++;
	            entryset.add(newentry);
	            
	            if(bucket[position] == null) bucket[position] = newentry;
	            else
	            {
	                  Entry<K,V> firstentry = bucket[position];
	                  while(firstentry.next != null)
	                  {
	                      firstentry = firstentry.next;                   
	                  }
	                  firstentry.next = newentry;           
	            }
	            
	            double new_load_factor = (double)number_Entry / (double) capacity;
	            if(new_load_factor >= load_factor)
	               rehash();
	       }
	       
	   }
	   
	   public V get(K key)
	   {
	        int hashcode = key.hashCode();
	        int position = hashcode % capacity;
	        
	        if(bucket[position] == null) return null;
	        else
	        {
	              Entry<K,V> firstentry = bucket[position];
	              if(firstentry.key.equals(key)) return firstentry;
	              
	              while(firstentry.next != null)
	              {
	                 firstentry = firstentry.next;
	                 if(firstentry.key.equals(key)) return firstentry;
	              }
	              if(firstentry.key.equals(key)) return firstentry;
	              else return null;
	            
	        }
	   }



	   private void rehash()
	   {
	       // TODO
	       
	       for(Entry<K,V> e : entryset){
	           if(e.)
	       
	       }
	       
	       Entry<K,V>[] newbucket = new Entry<K,V>[2*capacity];
	       int length = newbuket.length;
	       Iterator<Entry<K,V>> iter = entryset.iterator();
	       while(iter.hasNext()){
	          Entry<K,V> tmp = iter.next();
	          int newposition = tmp.key.hashCode()% length;
	          
	          if(newbucket[newposition] == null){
	              newbucket[newposition] = tmp;
	          }else{
	              Entry<K,V> firstentry = newbucket[newposition];
	              while(firstentry.next != null){
	                 firstentry = firstentry.next;           
	              }
	              firstentry.next = tmp;
	          }
	       }
	       
	       capacity = 2*capactiy;

	   }
	   public class Entry<K,V> implements Comparable<Entry<K,V>>
	   {
	        K key;
	        V value;
	        Entry<K,V> next = null;
	        
	        Entry<K,V>()
	        {
	        } 
	        
	        Entry<K,V>(K key, V value)
	        {
	            this.key = key;
	            this.value = value;          
	        } 
	        
	        public boolean equals (Entry<K,V> compare)
	        {
	           if(this.key.compareTo(compare.key) == 0) return true;
	           else return false;
	        }
	        public int compareTo (Entry<K,V> compare)
	        {
	            return this.key.compareTo(compare.key);
	        }
	   }
	    
	}



	public interface Iterable<T>
	{  
	    public Iterator<T> iterator();
	}

	public interface Iterator<T>
	{
	     public boolean hasnext();
	     public T next();
	     public T remove();

	}


	public class MyClass implements Iterable<MyNode>
	{
	     MyNode head;
	     String test;
	     ArrayList<MyNode> elements = new ArrayList<MyNode>();
	     
	     public MyClass()
	     {
	        head = new MyNode();
	        test = new String();
	     }
	     
	     public void add(MyNode item)
	     {
	          item.next = head.next;
	          head.next = item;
	     }
	     
	     public void remove()
	     {
	         if(head.next == null) return;
	         head.next = head.next.next;
	     }
	     
	     public void printall()
	     {
	           Iterator<MyNode> iter = this.iterator();
	           while(iter.hasNext())
	           {
	                MyClass item = iter.next();
	                System.out.println(item.value);
	           }
	           
	     }
	     
	     public Iterator<MyNode> iterator()
	     {
	         // TODO
	         return new MyIterator<MyNode>();
	         
	         //return elements.iterator();
	     }
	     
	     public class MyIterator<MyNode> implements Iterator<MyClass>
	     {
	         public boolean hasnext()
	         {
	            //TODO
	         }
	     
	         public MyClass next()
	         {
	             //TODO
	         }
	        
	         public MyClass remove()
	         {
	             //TODO
	         }
	     }
	     
	     public class MyNode
	     {
	         int value;
	         MyNode next;
	         
	         MyNode()
	         {
	         }
	         
	          MyNode(int value)
	          {
	              this.value = value;
	          }
	     }
	}