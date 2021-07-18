package level2;

import java.util.ArrayList;
import java.util.HashMap;

public class ProgLv2banggum {

	public static void main(String[] args) {
		
		 String answer = "(None)";
		 
		 int answerPlaytime = 0;
		 String m = "ABC";
		 String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAF#", "13:00,13:05,WORLD,ABCDEF"};
		 HashMap<String,String> map = new HashMap<String,String>();
		 
		 for( String musicinfo : musicinfos) {
			 String[] musicinfoArr = musicinfo.split(",");
	
			 int HHtoMinute = (Integer.parseInt(musicinfoArr[1].substring(0, 2)) - Integer.parseInt(musicinfoArr[0].substring(0, 2))) * 60; 
			 int minute = Integer.parseInt(musicinfoArr[1].substring(3, 5)) - Integer.parseInt(musicinfoArr[0].substring(3, 5));
			 
			 int playtime = HHtoMinute + minute;
				 		 
			 map.put("C","3"); 
			 map.put("C#","4"); 
			 map.put("D","5"); 
			 map.put("D#","6"); 
			 map.put("E","7"); 
			 map.put("F","8"); 
			 map.put("F#","9"); 
			 map.put("G","10"); 
			 map.put("G#","11"); 
			 map.put("A","12"); 
			 map.put("A#","1"); 
			 map.put("B","2"); 
			 
			 String song1 = musicinfoArr[3];
			 ArrayList<String> songArr = new ArrayList<String>();
			 for(int i=0; i<song1.length(); i++) {
				 if(i == song1.length()-1 && song1.charAt(i) != '#') {
					 songArr.add(map.get(String.valueOf(song1.charAt(i))));
					 break;
				 }
				 if(song1.charAt(i+1) == '#') {
					 songArr.add(map.get(song1.substring(i,i+2)));
					 i++;
				 }else {
					 songArr.add(map.get(String.valueOf(song1.charAt(i))));
				 }
			 }
			 ArrayList<String> mArr = new ArrayList<String>();
			 for(int i=0; i<m.length(); i++) {
				 if(i == m.length()-1 && m.charAt(i) != '#') {
					 songArr.add(map.get(String.valueOf(m.charAt(i))));
					 break;
				 }
				 if(song1.charAt(i+1) == '#') {
					 songArr.add(map.get(song1.substring(i,i+2)));
					 i++;
				 }else {
					 songArr.add(map.get(String.valueOf(m.charAt(i))));
				 }
			 }
			 
			 String[] playsong = new String[playtime];
			
			 
			
		
		 }
		 
		 System.out.println(answer);
	}

}
