package level2;

import java.util.Stack;

public class ProgLv2guarho {
	
	static String w="";
	static String u="";
	static String v="";
	static String answer="";
	
	static public void strDiv(String w){
		if(w.length() == 0) return;
		
		Stack<Character> stk = new Stack<Character>();
		stk.push(w.charAt(0));
		int index = 0;
		
		for(int i=1; i<=w.length(); i++) {
			if(stk.size() == 0) {
				index = i;
				break;
			}			
			
			if(stk.peek() == w.charAt(i)) 
				stk.push(w.charAt(i));
			else
				stk.pop();	
		}
		
		u = w.substring(0,index);
		v = w.substring(index,w.length());
		if(u.startsWith(")")) {
			String re = "";
			for(int i=1; i<u.length()-1; i++) {
				if(u.charAt(i) =='(') {
					re += ")";
				}else {
					re += "(";
				}
			}
			u = re;
			answer += "(";
			strDiv(v);
			answer += ")";
			answer += re;
		}else {
			answer += u;
			strDiv(v);
		}
		
	}
	
	public static void main(String[] args) {
		String p = "()))((()";
		w = p;
		
		
		strDiv(w);
System.out.println(answer);
	}

}
