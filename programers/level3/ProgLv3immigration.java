package level3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;


public class ProgLv3immigration {

	static class MyComparator implements Comparator<Node>{

		@Override
		public int compare(Node o1, Node o2) {
			if(o1.A > o2.A) {
				return 1;
			}else if(o1.A < o2.A) {
				return -1;
			}else {
				return 0;
			}
		}
		
	}
	
	static class Node{
		private int A; //시작시간
		private int S; //완료시간
		
		Node(int A,int S){
			this.A = A;
			this.S = S;
		}
		
	}
	
	public static void main(String[] args) {
			int answer = 0;
		
			int maxAnswer = 0;
			String[] lines = {
					"2016-09-15 20:59:57.421 0.351s",
					"2016-09-15 20:59:58.233 1.181s",
					"2016-09-15 20:59:58.233 4.181s",
					};
			LinkedList<Node> que = new LinkedList<Node>();
			HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
			MyComparator myComparator = new MyComparator();	
			
			int n =0;
			for(String line: lines) {
				int s = Integer.parseInt(line.substring(11,13))*3600000
							+Integer.parseInt(line.substring(14,16))*60000
							+Integer.parseInt(line.substring(17,19))*1000
						    +Integer.parseInt(line.substring(20,23));
	
				int t= (int) (Double.parseDouble(line.substring(24,line.length()-1))*1000);
				int a = s-t+1;
				
				que.add(new Node(a,s));
			}
			
			que.sort(myComparator);
			
			int cf = que.peek().A; //체크시작초(from)
			int ct = que.peek().A; //체크끝나는초(to)
			boolean check;
			
			//초기화
			while(ct - cf != 999) {
				check = false;
				if(que.size()>0 && que.peek().A == ct) {
					Node item = que.poll();
					map.put(item.S, map.getOrDefault(item.S, 0)+1);
					
					answer++;
					if(maxAnswer < answer) maxAnswer = answer;
					check = true;
				}
				
				if(map.containsKey(ct)) {			
					answer -= map.get(ct);
					map.remove(ct);								
				}
			
				if(check == true) continue;
				ct++;
			}
			

			while(map.size() != 0) {
				check = false;
				if(que.size()>0 && que.peek().A==ct) {
					Node item = que.poll();
					map.put(item.S, map.getOrDefault(item.S, 0)+1);
					
					answer++;
					if(maxAnswer < answer) maxAnswer = answer;
					check = true;
				}
				
				if(map.containsKey(cf)) {
					answer -= map.get(cf);
					map.remove(cf);							
				}
				
				if(check == true) continue;
				cf++;
				ct++;
			}
			Node na= que.getFirst();
			
			System.out.println(maxAnswer);
			
			
	}
}
