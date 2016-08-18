package Goo;


import java.util.ArrayList;
import java.util.List;

public class SplitString {
	
	public static List<String> split(String s) {
		List<String> result = new ArrayList<String>();
		if (s == null || s.length() == 0) {
			return result;
		}
		
		boolean inQuote = false;
		StringBuilder temp = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!inQuote) {
				if (c == '\"') {
					inQuote = true;
				} else if (c == ' ' && temp.length() != 0) {
					result.add(temp.toString());
					temp.setLength(0);
				} else if (c != ' '){
					temp.append(c);
				}
			} else {
				if (c == '\"') {
					result.add(temp.toString());
					temp.setLength(0);
					inQuote = false;
				} else {
					temp.append(c);
				}
			}
		}
		
		if (temp.length() != 0) {
			result.add(temp.toString());
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "This is \"an example\" string.";
		List<String> result = split(s);
		
		for (String str : result) {
			System.out.println(str);
		}
	}

}
