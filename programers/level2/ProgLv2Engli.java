package level2;

import java.util.HashSet;

public class ProgLv2Engli {

	public static void main(String[] args) {
		String[] words = {"qwe", "eqwe", "eqwe"};
		int n = 2;
		
		int[] answer = new int[2];
	
		
		HashSet<String> set = new HashSet<String>();
		boolean none = true;
		int index = 1;
		String prevWord = words[0];
		set.add(words[0]);
		
		for(int i=1; i<words.length; i++) {
			if(prevWord.charAt(prevWord.length()-1) == words[i].charAt(0) && !set.contains(words[i])) {
				set.add(words[i]);
				prevWord = words[i];
				continue;
			}else {
				index = i;
				none = false;
				break;
			}
		}
		
		if(none == true) {
			answer[0] = 0;
			answer[1] = 0;
		}else {
			answer[0] = (index+1)%n == 0? n : (index+1)%n;
			answer[1] = (index+1)%n == 0? (index+1)/n : (index+1)/n+1;
		}
	
			System.out.println(answer[0]);
			System.out.println(answer[1]);
	}

}
