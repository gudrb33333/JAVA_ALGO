package level2;


import java.util.HashMap;

public class ProgLv2Boat {

	public static void main(String[] args) {
		
		
		int answer = 0;
		int[] people = {190,160,150,140,60,50,40};
		int limit = 200;
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i: people) {
			map.put(i, map.getOrDefault(i, 0)+1);
		}
		
		for(int i=240; i>=40; i--) {
			if(map.isEmpty()) break;
			if(map.get(i) == null) continue;
			int start = limit-i;
			
			if(start<40) {
				map.put(i,map.get(i)-1); 
				if(map.get(i)==0) map.remove(i);
				answer++;
			}else { 
				map.put(i,map.get(i)-1); 
				if(map.get(i)==0) map.remove(i);
				for(int j=start; j>=40; j--) {
					if(map.get(j) != null) {
						map.put(j,map.get(j)-1); 
						if(map.get(j)==0) map.remove(j);
						answer++;
						break;
					}
					if(j==40) answer++;
					
				}
			}
			if(map.get(i) !=null && map.get(i) != 0) ++i;
		
		}

		System.out.println(answer);
		
	}

}
