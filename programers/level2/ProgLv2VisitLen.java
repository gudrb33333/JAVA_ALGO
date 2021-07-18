package level2;

import java.util.HashSet;

public class ProgLv2VisitLen {

	static int answer=0;
	
	private static void up(int cursorX, int cursorY, HashSet<String> set) {
		String a = String.valueOf(cursorX) + String.valueOf(cursorY) + String.valueOf(cursorX) + String.valueOf(++cursorY);
		String b = String.valueOf(cursorX) + String.valueOf(cursorY) + String.valueOf(cursorX) + String.valueOf(--cursorY);
		
		if(set.add(a) && set.add(b)) {
			answer++;
		}
	}
	
	private static void down(int cursorX, int cursorY, HashSet<String> set) {
		String a = String.valueOf(cursorX) + String.valueOf(cursorY) + String.valueOf(cursorX) + String.valueOf(--cursorY);
		String b = String.valueOf(cursorX) + String.valueOf(cursorY) + String.valueOf(cursorX) + String.valueOf(++cursorY);
		
		if(set.add(a) && set.add(b)) {
			answer++;
		}	
	}
	
	private static void left(int cursorX, int cursorY, HashSet<String> set) {
		String a = String.valueOf(cursorX) + String.valueOf(cursorY) + String.valueOf(--cursorX) + String.valueOf(cursorY);
		String b = String.valueOf(cursorX) + String.valueOf(cursorY) + String.valueOf(++cursorX) + String.valueOf(cursorY);
		
		if(set.add(a) && set.add(b)) {
			answer++;
		}		
	}

	private static void right(int cursorX, int cursorY, HashSet<String> set) {
		String a = String.valueOf(cursorX) + String.valueOf(cursorY) + String.valueOf(++cursorX) + String.valueOf(cursorY);
		String b = String.valueOf(cursorX) + String.valueOf(cursorY) + String.valueOf(--cursorX) + String.valueOf(cursorY);
		
		if(set.add(a) && set.add(b)) {
			answer++;
		}
	}
	
	public static void main(String[] args) {
	
		String dirs = "LULLLLLLU";
		HashSet<String> set = new HashSet<String>();
		
		int cursorX = 0;
		int cursorY = 0;
		
		for(char c : dirs.toCharArray()) {
			
			switch (c) {
				case 'U':
					if(cursorY<5) {
						up(cursorX,cursorY,set);
						cursorY++;
					}
				break;
				
				case 'D':
					if(cursorY>-5) {
						down(cursorX,cursorY,set);
						cursorY--;
					}
				break;
					
				case 'L':
					if(cursorX>-5) {
						left(cursorX,cursorY,set);
						cursorX--;
					}
				break;
					
				case 'R':
					if(cursorX<5) {
						right(cursorX,cursorY,set);
						cursorX++;
					}
				break;
			}
		}
	
		System.out.println(answer);
	}



}
