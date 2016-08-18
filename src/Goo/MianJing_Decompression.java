package Goo;

import java.util.Stack;

/**
 * We are given a string which is compressed and we have to decompress it.

	(a(bc2)d2)$
	"$" indicates end of string.
	
	(abcbcd2)$
	
	abcbcdabcbcd (This is the final uncompressed string.)
 * 
 * 2[abc]3[a]c => abcabcabcaaac;     2[ab3[d]]2[cc] => abdddabdddcccc
 * 
 * 
 * @author zko7nw0
 *
 */
/*1[a2[bc]]*/

public class MianJing_Decompression {
	
	
	public String decompression(String src){
		if(src == null || src.length() == 0){
			return src;
		}
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < src.length(); i++){
			
			if(src.charAt(i) != ']'){
				stack.push(src.charAt(i));
				
			}else if(src.charAt(i) == ']'){
				StringBuilder sb = new StringBuilder();
				Character curChar = stack.pop();
				while( curChar != '['){
					sb.append(curChar);
					curChar = stack.pop();
					
				}
				int num =  getRepeatedTimesNum(stack);
				String str = sb.toString();
				
				for(int k = 0; k < num; k++){
					// 注意这里翻转是因为出栈的时候已经反转了
					for(int j = str.length() - 1; j >= 0; j--){
						stack.push(str.charAt(j));
					}
				}

			}
		}
		StringBuilder ret = new StringBuilder();
		while(!stack.isEmpty()){
			ret.append(stack.pop());
		}
		//出栈需要翻转
		ret.reverse();
		return ret.toString();
	}
	
	public int getRepeatedTimesNum(Stack<Character> stack){
		
		int res = 0;
		int base = 1;
		while(!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9'){
			res = (int)(stack.pop() - '0') * base + res;
			base = base * 10;
		}
		
		return res;
		
	}

	
	public static void main(String args[]){
		MianJing_Decompression test = new MianJing_Decompression();
		//1[a2[bc]]
		String input = "2[ab3[d]]2[cc]";
		String res  = test.decompression(input);
		System.out.println(res);
	}
	
	
}

