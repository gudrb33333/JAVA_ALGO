package level2;

public class ProgLv2Quad {
	static int[] answer= {0,0};

	private static void QuadComp(int[][] arr,int sqL,int startX, int endX, int startY,int endY) {
		
		if(sqL/2 <= 1) return;
		LU(arr, sqL/2, startX, (startX+endX)/2, startY, (startY+endY)/2);
		RU(arr, sqL/2,(startX+endX)/2+1, endX, startY, (startY+endY)/2);
		LD(arr, sqL/2, startX, (startX+endX)/2,  (startY+endY)/2+1, endY);
		RD(arr, sqL/2, (startX+endX)/2+1, endX, (startY+endY)/2+1, endY);
		
	}
	
	private static void miSqure(int[][] arr, int startX, int endX, int startY, int endY) {
		for(int i=startY; i<=endY; i++) {
			for(int j=startX; j<=endX; j++) {
				if(arr[i][j]==0) answer[0]++;
				else answer[1]++;
			}
		}
	}

	private static void LU(int[][] arr,int sqL,int startX, int endX, int startY,int endY) {
		boolean equal = true;
		int temp = arr[startY][startX];
		loop:
		for(int i=startY; i<=endY; i++) {
			for(int j=startX; j<=endX; j++) {
				if(arr[i][j] != temp) {
					equal = false;
					break loop;
				}
			}
		}
		if(equal) {
			if(temp == 0) answer[0]++;
			else answer[1]++;
			return;	
		}else {
			if(sqL/2 <= 1) miSqure(arr,startX,endX,startY,endY);
		}
		QuadComp(arr,sqL,startX,endX,startY,endY);	
	}

	private static void RU(int[][] arr,int sqL,int startX, int endX, int startY,int endY) {
		boolean equal = true;
		int temp = arr[startY][startX];
		loop:
		for(int i=startY; i<=endY; i++) {
			for(int j=startX; j<=endX; j++) {
				if(arr[i][j] != temp) {
					equal = false;
					break loop;
				}
			}
		}
		if(equal) {
			if(arr[startY][startX] == 0) answer[0]++;
			else answer[1]++;
			return;	
		}else {
			if(sqL/2 <= 1) miSqure(arr,startX,endX,startY,endY);
		}
		QuadComp(arr,sqL,startX,endX,startY,endY);
		
	}

	private static void LD(int[][] arr,int sqL,int startX, int endX, int startY,int endY) {
		boolean equal = true;
		int temp = arr[startY][startX];
		loop:
		for(int i=startY; i<=endY; i++) {
			for(int j=startX; j<=endX; j++) {
				if(arr[i][j] != temp) {
					equal = false;
					break loop;
				}
			}
		}
		if(equal) {
			if(arr[startY][startX] == 0) answer[0]++;
			else answer[1]++;
			return;	
		}else {
			if(sqL/2 <= 1) miSqure(arr,startX,endX,startY,endY);
		}
		QuadComp(arr,sqL,startX,endX,startY,endY);
		
	}

	private static void RD(int[][] arr,int sqL,int startX, int endX, int startY,int endY) {
		boolean equal = true;
		int temp = arr[startY][startX];
		loop:
		for(int i=startY; i<=endY; i++) {
			for(int j=startX; j<=endX; j++) {
				if(arr[i][j] != temp) {
					equal = false;
					break loop;
				}
			}
		}
		if(equal) {
			if(arr[startY][startX] == 0) answer[0]++;
			else answer[1]++;
			return;	
		}else {
			if(sqL/2 <= 1) miSqure(arr,startX,endX,startY,endY);
		}
		QuadComp(arr,sqL,startX,endX,startY,endY);
		
	}

	public static void main(String[] args) {
		int[][] arr = {
				{0,0},
				{0,0},
				
						};
		int startX = 0;
		int endX = arr.length-1;
		int startY = 0;
		int endY = arr.length-1;
		int sqL = arr.length;
		
		boolean equal = true;
		int temp = arr[startY][startX];
		loop:
		for(int i=startY; i<=endY; i++) {
			for(int j=startX; j<=endX; j++) {
				if(arr[i][j] != temp) {
					equal = false;
					break loop;
				}
			}
		}
			
		if(equal) {
			if(arr[startY][startX] == 0) answer[0]++;
			else answer[1]++;		
		}else {
			QuadComp(arr,sqL ,startX,endX,startY,endY);
		}
		System.out.println(answer[0]);
		System.out.println(answer[1]);
	}

}
