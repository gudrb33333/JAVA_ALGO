package level2;

import java.util.HashSet;

public class ProgLv2FindPrime {
	static HashSet<Integer> set = new HashSet<Integer>(); 	
	
	public static void isPrime(String s) {
		int n = Integer.parseInt(s);
		
		if(n==0 || n==1) return;
        for(int i=2; i<=(int)Math.sqrt(n); i+=i){
            if(n%i==0) return;
        }
       if(!set.contains(n))
    	   	set.add(n);
	}
	
	public static void dfs(int n, String[] numbersArr, boolean[] visited, String[] output, int depth, int r){
		
		for(int i=0; i<n; i++) {
			if(depth == r) {
				String s = "";
				for(int j=0; j<r; j++) 
					s += output[j];
				
				isPrime(s);
							
				return;
			}
			
			if(visited[i] == false) {
				output[depth] =  numbersArr[i];
				visited[i] = true;
				dfs(n, numbersArr, visited, output, depth+1, r);
				visited[i] = false;
			}
		}
		
	}
	
	public static void main(String[] args) {
		String numbers = "011";
		
		int n = numbers.length();
		String[] numbersArr = new String[n];
		String[] output = new String[n];
		boolean[] visited = new boolean[n];
		int depth = 0;
		
		for(int i=0; i<numbers.length(); i++) 
			numbersArr[i] = String.valueOf(numbers.charAt(i));
		
		for(int r=1; r<=n; r++) {
			dfs(n, numbersArr, visited, output, depth, r);
		}
		System.out.println(set.size());
	}

}
