package level2;

public class ProgLv2Danche {
	static int answer  = 0;
	// 배열 출력
    static String print(char[] output, int r) {
    	String s = "";
        for (int i = 0; i < r; i++)
            s += output[i];
		return s;
    }
    
    static boolean check(String s,String[] data) {
    	for(String item:data) {
        	int man1 = s.indexOf(item.charAt(0));
        	int man2 = s.indexOf(item.charAt(2));
        	char op = item.charAt(3);
        	int d = Character.getNumericValue(item.charAt(4))+1;
        	
        	if(op == '=') {
        		if(Math.abs(man1-man2) != d) return false;
        	}else if(op == '>') {
        		if(Math.abs(man1-man2) <= d) return false;
        	}else {
        		if(Math.abs(man1-man2) >= d) return false;
        	}
        }
		return true;
    }
    
	private static void dfs(char[] man, int n, char[] output, boolean[] visited, int depth,String[] data) {
		if (depth == n) {
	        String s = print(output, n);
	        if(check(s,data)) {
	        	answer++;
	        }      
	        return;
	    }
		
		for(int i=0; i<n; i++) {
			if(visited[i]) continue;
			
			output[depth] = man[i];
			visited[i] = true;
			dfs(man,n,output,visited,depth+1,data);
			visited[i] = false;
		}
		
	}
	
	public static void main(String[] args) {
	
		char[] man = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
		String[] data = {"M~C<2", "C~M>1"};
		
		answer = 0;
		int n = man.length;
		char[] output = new char[n];
		boolean[] visited = new boolean[n];
		int depth = 0;
		
		dfs(man,n,output,visited,depth,data);
		
		System.out.println(answer);
	}

}
