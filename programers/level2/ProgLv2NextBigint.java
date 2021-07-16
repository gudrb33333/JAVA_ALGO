package level2;

import java.util.LinkedList;

public class ProgLv2NextBigint {

	public static void main(String[] args) {
		int n = 15;
		
		String s = Integer.toBinaryString(n);
		LinkedList<Character> l = new LinkedList<Character>();
		
		int zeroNum = 0;
		int oneNum = 0;
		
		for(char c: s.toCharArray()) {
			l.add(c);
		}
		
		int index = l.size();
		for(int i=l.size()-1; i>=1; i--) {
			if(l.get(i)=='1' && l.get(i-1)=='0') {
				l.set(i, '0');
				l.set(i-1, '1');
				index = i;
				break;
			}else if(l.get(i)=='1') {
				oneNum++;
			}else {
				zeroNum++;
			}		
		}
				
		if(index == l.size()) {
			System.out.println("12321");
			l.add(1, '0');
		}else {
			for(int i=index+1; i<l.size(); i++) {
				if(zeroNum > 0) {
					l.set(i, '0');
					zeroNum--;
				}else {
					l.set(i, '1');
				}
				
			}
		}
		System.out.println(l);
		int result = 0;
		int n2 = l.size();
		for(int i=0; i<n2; i++) {
			if(l.peekLast() =='1') {
				result += Math.pow(2, i);
			}
			l.pollLast();
		}
		
		System.out.println(result);
	}

}
