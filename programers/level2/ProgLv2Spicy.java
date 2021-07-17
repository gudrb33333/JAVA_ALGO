package level2;

import java.util.PriorityQueue;


public class ProgLv2Spicy {


	public static void main(String[] args) {
		int answer = 0;
		
		int[] scoville= {10, 10, 10, 10, 10};
		int K = 100;
		
		PriorityQueue<Integer> pQue = new PriorityQueue<Integer>();
				
		
		for(int i=0; i < scoville.length; i++) {
			pQue.offer(scoville[i]);
		}
		
		while(pQue.size() > 1) {
			if(pQue.peek() >= K) break;
			
			int temp1 = pQue.poll();
			int temp2 = pQue.poll();
			
			int temp3 = temp1 + (temp2 * 2);
		
			pQue.add(temp3);
			answer++;
		}
		
		if(pQue.peek() < K) answer = -1;
		

		
		System.out.println("----"+answer);
		
		
		
	}	
}
