package level2;

public class ProgLv2JoyStick {
	
	static int min = 0;
	
	public static int pathLength(int[] output ,int n,int nameLength) {
	
		int minPathLength=0;
		
		for(int i=0; i<output.length-1; i++) {
			int before = output[i];
			int after = output[i+1];
			
			int temp1=0;
			int temp2=0;
			
			while(before != after) {
				--before;
				if(before<0) before = nameLength-1;
				temp1++;
			}
			
			before = output[i];
			after = output[i+1]; 
			
			while(before != after) {
				++before;
				if(before > nameLength-1) before=0;
				temp2++;
			}
			
			minPathLength += temp1>temp2? temp2:temp1;
		}
		
		return minPathLength;
	}
	
	public static void perm(int[] arr, int n, boolean[] visited, int[] output, int depth, int nameLength) {
		if(depth == n) {
			int temp = pathLength(output, n, nameLength);
			if(min==0 || temp < min) {
				min = temp;
			}
			return;
		}
		
		for(int i=1; i<n; i++) {
			if(visited[i]) continue;
			
			output[depth] = arr[i];
			visited[i] = true;
			perm(arr,n,visited,output,depth+1,nameLength);
			visited[i] = false;
			
			
		}
		
	}
	
	public static void main(String[] args) {
		String name = "CANAAAAANAN";
		
		int[] nameChangedIdxArr = new int[20];
		int nameChangedIdxArrLen = 1;
		int answer = 0;
		boolean find = false;
		int secondCharA = 0;
		
		char[] downAlpahbet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N'};
		char[] upAlpahbet =   {'A','Z','Y','X','W','V','U','T','S','R','Q','P','O','N'};
		
		for(int i=0; i<name.length();i++) {
			char item = name.charAt(i);
			
			if(item != 'A') nameChangedIdxArr[nameChangedIdxArrLen++] = i;
			
			for(int j=0; j<downAlpahbet.length; j++) {
				if(downAlpahbet[j] == item) {
					answer += j;
					find = true;
					break;
				}
			}
			
			if(!find) {
				for(int j=0; j<downAlpahbet.length; j++) {
					if(upAlpahbet[j] == item) {
						answer += j;
						break;
					}
				}
			}
				
			find = false;
		}
		
		if(name.length() > 1) {
			boolean[] visited = new boolean[nameChangedIdxArrLen];
			int[] output = new int[nameChangedIdxArrLen];
			int depth = 1;
		
			perm(nameChangedIdxArr, nameChangedIdxArrLen, visited, output, depth, name.length());
		}
		
		System.out.println(answer+min);
	}

}
