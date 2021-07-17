package level2;

import java.util.HashMap;

public class ProgLv2NewsClustering {

	public static void main(String[] args) {
		
		HashMap<Integer,Integer> A_SET = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> B_SET = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> INTER_SET = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> UNION_SET = new HashMap<Integer,Integer>();
		
		
		A_SET.put(1,A_SET.getOrDefault(1,0)+1);
		A_SET.put(1,A_SET.getOrDefault(1,0)+1);
		A_SET.put(2,A_SET.getOrDefault(2,0)+1);
		A_SET.put(2,A_SET.getOrDefault(2,0)+1);
		A_SET.put(3,A_SET.getOrDefault(3,0)+1);
		
		System.out.println(A_SET);
		
		B_SET.put(1,B_SET.getOrDefault(1,0)+1);
		B_SET.put(2,B_SET.getOrDefault(2,0)+1);
		B_SET.put(2,B_SET.getOrDefault(2,0)+1);
		B_SET.put(4,B_SET.getOrDefault(4,0)+1);
		B_SET.put(5,B_SET.getOrDefault(5,0)+1);
		
		System.out.println(B_SET);
		
		A_SET.forEach((key,value)->{
			if(B_SET.containsKey(key)) {
				INTER_SET.put(key,Math.min(A_SET.get(key),B_SET.get(key)));
			}
		});
	
		System.out.println(INTER_SET);
	}

}
