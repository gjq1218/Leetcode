package Goo;
/**
 * Write a function that takes a string as input and returns the string reversed.

	Example:
	Given s = "hello", return "olleh".
	
	Show Tags
	Show Similar Problems

 * @author SirusBlack
 *
 */
public class ReverseString {
    public String reverseString(String s) {
    	StringBuilder newStr = new StringBuilder();
    	
    	for(int i = s.length() - 1; i >= 0 ; i--){
    		newStr.append(s.charAt(i));
    	}
    	
		return newStr.toString();
        
    }
}
