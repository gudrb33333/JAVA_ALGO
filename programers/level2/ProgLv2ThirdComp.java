package level2;

import java.util.ArrayList;
import java.util.HashMap;

public class ProgLv2ThirdComp {

	public static void main(String[] args) {
		ArrayList<Integer> answerArr = new ArrayList<Integer>();
		String msg = "TOBEORNOTTOBEORTOBEORNOT";
		
		HashMap<String,Integer> indexMap = new HashMap<String,Integer>();
		indexMap.put("A",1);
		indexMap.put("B",2);
		indexMap.put("C",3);
		indexMap.put("D",4);
		indexMap.put("E",5);
		indexMap.put("F",6);
		indexMap.put("G",7);
		indexMap.put("H",8);
		indexMap.put("I",9);
		indexMap.put("J",10);
		indexMap.put("K",11);
		indexMap.put("L",12);
		indexMap.put("M",13);
		indexMap.put("N",14);
		indexMap.put("O",15);
		indexMap.put("P",16);
		indexMap.put("Q",17);
		indexMap.put("R",18);
		indexMap.put("S",19);
		indexMap.put("T",20);
		indexMap.put("U",21);
		indexMap.put("V",22);
		indexMap.put("W",23);
		indexMap.put("X",24);
		indexMap.put("Y",25);
		indexMap.put("Z",26);
		    
	
		int temp = 0;
		
		for(int i=0; i<msg.length(); i++) {
			int j=1;
			while(true) {
			
				if(indexMap.get(msg.substring(i,i+j)) != null) {
					temp = indexMap.get(msg.substring(i,i+j));
					j++;			
					if(i+j > msg.length()) {
						break;
					}
				}else {
					indexMap.put(msg.substring(i,i+j),indexMap.size()+1);
					break;
				}
				
			}
			answerArr.add(temp);
			i += j-2;
		
		}
		     
		int[] answer = new int[answerArr.size()];
		temp = 0;
		for(int x : answerArr) {
			answer[temp++] = x;
		}
		
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		System.out.println(answer[2]);
		System.out.println(answer[3]);
	}

}
