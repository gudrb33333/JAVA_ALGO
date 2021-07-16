package level2;

import java.util.Stack;

public class ProgLv2Garo {

	public static void main(String[] args) {
		boolean answer = true;
		String s = "(()(";
		Stack<Character> stk = new Stack<Character>();
		
		for(char x : s.toCharArray()) {
			if(stk.size() == 0) {stk.push(x); continue;}
			
			if(stk.peek() == '(') {
				if(x == ')') stk.pop();
				else stk.push(x);
			}else {
				stk.push(x);
			}
		}
		
		if(stk.size()>0) answer = false;
	}

}
