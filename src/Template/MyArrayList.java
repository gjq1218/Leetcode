package Template;


public class MyArrayList<AnyType> implements Iterable<AnyType>{
	
	private static final int DEFAULT_CAPACITY = 10;
	
	private int theSize;
	private AnyType[] theItems;
	
	//Constructor
	public MyArrayList(){
		doClear();
	}
	//Methods start here
	public int size(){
		return theSize;
	}
	public void trimToSize(){
		ensureCapacity(size());
	}
	public void clear(){
		doClear();
	}
	private void doClear(){
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}
	
	public boolean isEmpty(){
		return size() == 0;
	}

	public AnyType get(int idx){
		if(idx < 0 || idx >= size())
			throw new ArrayIndexOutOfBoundsException();
		return theItems[idx];
	}
	public AnyType set(int idx, AnyType newVal){
		if(idx < 0 || idx >= size()){
			throw new ArrayIndexOutOfBoundsException();
		}
		AnyType old = theItems[idx];
		theItems[idx] = newVal;
		return old;
	}

	
	@SuppressWarnings("unchecked")
	public void ensureCapacity(int newCapacity){
		if(newCapacity < theSize){
			return;
		}
		
		AnyType[] old = theItems;
		theItems = (AnyType []) new Object[newCapacity];
		for( int i = 0; i < size(); i++){
			theItems[i] = old[i];
		}
	}
	public boolean add(AnyType x){
		add(size(), x);
		return true;
	} 
	
	public void add(int idx, AnyType x){
		if(theItems.length == size())
			ensureCapacity(size()*2 + 1);
		
		for(int i = theSize; i > idx; i--)
			theItems[i] = theItems[i - 1];
		theItems[idx] = x;
		
		theSize++;	

	}
	
	public AnyType remove(int idx){
		AnyType removedItem = theItems[idx];
		for(int  i = idx; i < size()-1 ; i++){
			theItems[i] = theItems[i+1];
		}
		theSize--;
		return removedItem;
	}
	@SuppressWarnings("unchecked")
	public Iterator<AnyType> iterator(){
		return (Iterator<AnyType>) new ArrayListIterator();
	}
	
	private class ArrayListIterator implements java.util.Iterator<AnyType>{
		private int current = 0;
		
		//inner class自动产生。
//		public MyArrayList<AnyType> theList;
//		public ArrayListIterator(MyArrayList<AnyType> list)
//		{theList = list;}
		
		
		public boolean hasNext(){
			return current < size();
		}		
		public AnyType next(){
			if(!hasNext())
				throw new java.util.NoSuchElementException();
			return theItems[current++];
		}
		public void remove(){
			MyArrayList.this.remove(--current);
		}
	}
	
}
