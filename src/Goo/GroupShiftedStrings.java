package Goo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
Return:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
Note: For the return value, each inner list's elements must follow the lexicographic order.

Show Company Tags
Show Tags
Show Similar Problems

 * @author ginagao
 *
 */
public class GroupShiftedStrings {
	   public List<List<String>> groupStrings(String[] strings) {
		   	List<List<String>> res = new ArrayList<List<String>>();
	        HashMap<String, List<String>> hash = new HashMap<String, List<String>>();        
	        
	        for(int i = 0; i < strings.length; i++){
	            StringBuilder code = new StringBuilder();
	            String cur = strings[i];
	            for(int j = 0; j < cur.length(); j++){
	            	code.append(Integer.toString((cur.charAt(j) - cur.charAt(0) + 26) % 26));
	                code.append(" ");
	            }
	            String shift = code.toString();
	            if(!hash.containsKey(shift)){
	                List<String> oneres = new ArrayList<String>();
	                oneres.add(cur);
	                hash.put(shift, oneres);
	            }else{
	                hash.get(shift).add(cur);
	            }

	        }	        
	        for(String str : hash.keySet()){
	            Collections.sort(hash.get(str));
	            res.add(hash.get(str));
	        }
	        
	        return res;
	    }
	   
	   public static void main(String args[]){
		   GroupShiftedStrings res = new GroupShiftedStrings();
		   String[] strings = {"az","yx"};
		   // String[] strings = {"az","yxs"};
		   List<List<String>> result = new ArrayList<List<String>>();
		   result = res.groupStrings(strings);
		   for(List<String> list: result){
			   System.out.println(list.toString());
		   }
		   
	   }
}
