package level2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ProgLv2OpenChat {
	
	static class Node{
		private String key;
		private String status;
		
		Node(String key,String status){
			this.key = key;
			this.status = status;
		}
	}
	
	static class DataObject{
		private String nickname;
	
		DataObject(String nickname){
			this.nickname = nickname;
		}
	}
	
	static String[] strSplit(String str) {
		String[] strArray = new String[3];
		strArray = str.split(" ");
		return strArray;
	}
	
	public static void main(String[] args) {
		String[] record = {
				"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

		
		LinkedList<Node> que = new LinkedList<Node>();
		Map<String,DataObject> map = new HashMap<String,DataObject>();
		
		for(String str : record) {
			String[] s = new String[3];
			s = strSplit(str);
			
			String order = s[0];
			String uid = s[1];
			String nick = s.length>2?s[2]:null;
			
			switch (order) {
			case "Enter":	
				map.put(uid,new DataObject(nick+"´ÔÀÌ"));
				que.add(new Node(uid,"µé¾î¿Ô½À´Ï´Ù."));
			break;

			case "Leave":
				que.add(new Node(uid,"³ª°¬½À´Ï´Ù."));
			break;
				
			case "Change":
				map.put(uid,new DataObject(nick+"´ÔÀÌ"));
			break;
			}
			
		}
		
		String[] answer = new String[que.size()];
		int i=0;
		while(que.size() > 0) {
			Node node = que.poll();
			
			DataObject dataObject = map.get(node.key);	
			answer[i++] = (dataObject.nickname+" "+node.status);
		}
		

	}

}
