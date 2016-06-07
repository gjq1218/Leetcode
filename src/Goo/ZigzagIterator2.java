package Goo;

import java.util.List;

// Way II: two pointer.

public class ZigzagIterator2 {	
	 // This is the 2nd method to do this question -  two pointers.  
		int left1;
		int left2;
		 List<Integer> v1;
		 List<Integer> v2;
		public ZigzagIterator2(List<Integer> v1, List<Integer> v2) {
		    
		    // in case of the input such as [1] [], we need to use a trick here to set up left1 = -1, left2 = -1 insteand of setting them as 0.
			left1 = -1;
			left2 = -1;
			this.v1 = v1;
			this.v2 = v2;
			
	    }

	    public int next() {
	    	 
	    // 	if((v1 == null && v2 == null) ||(v1.size() == 0 && v2.size() == 0) ){
	    // 	    return 0;
	    // 	} 
	    
	    
	    	if(left1 == v1.size() - 1 ){
	    		left2 ++;
	    		return v2.get(left2);
	    	}else if(left2 == v2.size() - 1){
	    		left1++;
	    		return v1.get(left1);
	    	    
	    	}else if(left1 == left2){
	    	    left1++;
	    		return v1.get(left1);
	    	}else if(left1 > left2){
	    	    left2++;
	    		return v2.get(left2);
	    	}else{
	    	    return 0;
	    	}
	    }

	    public boolean hasNext() {
	        if((v1 == null && v2 == null) ||(v1.size() == 0 && v2.size() == 0) ){
	    	    return false;
	    	}

	    	if(left1 == v1.size() - 1 && left2 == v2.size() - 1){
	    		return false;
	    	}else{
	    		return true;
	    	}
	    	
	    }
}
