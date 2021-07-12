package hashmap;

import java.util.*;

public class GetOrDefault {

	/**
	 * HashMap내의 중복 갯수를 센다.
	 * 
	 */
	
	public static void main(String[] args) {
		
		String[] arr= {"aaa","aaa","bbb","ccc","ddd","ccc","eee"};
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		for(String key : arr) {
			map.put(key,map.getOrDefault(key,0)+1);
		}

		System.out.println(map);
		//출력결과-----------------------------
		//{aaa=2, ccc=2, bbb=1, eee=1, ddd=1}
	}

}
