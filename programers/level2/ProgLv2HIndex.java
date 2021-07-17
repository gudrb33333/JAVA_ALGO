package level2;

import java.util.Arrays;

public class ProgLv2HIndex {

	public static void main(String[] args) {
		int answer = 0;
		int[] citations = {0, 0, 1};
		int n = citations.length;
		
		Arrays.sort(citations);
		
		for(int i=n-1; i>=0; i--) {
			if(citations[i] <= (n-i)) {
				answer = citations[i];
				 if(i != n-1){
	                    while(answer != (n-i-1)) {
					    	answer++;
					    }
	                }
				break;
			}
		}
		
		System.out.println(answer);
	}

}
