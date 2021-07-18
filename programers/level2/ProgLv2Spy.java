package level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;



public class ProgLv2Spy {
	static HashMap<String,String> map = new HashMap<String,String>();
	
    static boolean check(String[][] arr, boolean[] visited, int n) {
    	HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < n; i++) {
        	
        		
        		if (visited[i]) {
        			if(set.add(arr[i][1])) {
        				System.out.print(arr[i][0] + " ");
	                }else {
	                	return false;
	                }
        		}
        }
       return true;
    }
	
	static void combination(String[][] arr, int n, int r, boolean[] visited, int start) {
	    if(r == 0) {
	        if(check(arr, visited, n))
	        	System.out.println("true");
	        return;
	    } 

	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        combination(arr, n, r - 1, visited, i + 1);
	        visited[i] = false;
	    }
	}	

	public static void main(String[] args) {
		String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
		int n = clothes.length;
		boolean[] visited = new boolean[n];
		int start = 0;
		
		HashMap<String, String> map = new HashMap<String,String>();
	
		  for (int i = 1; i <= n; i++) {
	            System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
	            combination(clothes, n, i, visited, start);
	        }

	}

}
