package level2;

public class ProgLv2Taedury {
    static int min;
    
	public static void main(String[] args) {
		int rows = 3;
		int columns = 3;
		int[][] queries = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
		
		int[] answer = new int[queries.length];
		int index = 0;
		int[][] matrix = new int[rows][columns];
		int start = 0;
		

		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				matrix[i][j] = ++start;
			}
		}
		
		
		for(int[] item : queries) {
			int y1 = item[0]-1;
			int x1 = item[1]-1;
			int y2 = item[2]-1;
			int x2 = item[3]-1;

			int temp1=0;
			int temp2=0;
			min = matrix[y1][x1];
			temp2 = forward(matrix,item,temp1,temp2,y1,x1,y2,x2);
			temp2 = down(matrix,item,temp1,temp2,y1,x1,y2,x2);
			temp2 = backward(matrix,item,temp1,temp2,y1,x1,y2,x2);
			upward(matrix,item,temp1,temp2,y1,x1,y2,x2);
			
			answer[index++] = min;
		}

		
	}

	private static void upward(int[][] matrix, int[] item, int temp1, int temp2, int y1, int x1, int y2, int x2) {
		for(int i=y2-1; i>=y1; i--) {
			if(matrix[i][x1] !=0 && matrix[i][x1] < min) min = matrix[i][x1];
			temp1 = matrix[i][x1];
			matrix[i][x1] = temp2;
			temp2 = temp1;
		}
		
	}

	private static int backward(int[][] matrix, int[] item, int temp1, int temp2, int y1, int x1, int y2, int x2) {
		for(int i=x2-1; i>=x1; i--) {
			if(matrix[y2][i] < min) min = matrix[y2][i];
			temp1 = matrix[y2][i];
			matrix[y2][i] = temp2;
			temp2 = temp1;
		}
		return temp2;
	}

	private static int down(int[][] matrix, int[] item, int temp1, int temp2, int y1, int x1, int y2, int x2) {
		for(int i=y1+1; i<=y2; i++) {
			if(matrix[i][x2] < min) min = matrix[i][x2];
			temp1 = matrix[i][x2];
			matrix[i][x2] = temp2;
			temp2 = temp1;
		}
		return temp2;
	}

	private static int forward(int[][] matrix, int[] item, int temp1, int temp2, int y1, int x1, int y2, int x2) {
		for(int i=x1; i<=x2; i++) {
			if(matrix[y1][i] < min) min = matrix[y1][i];
			temp1 = matrix[y1][i];
			matrix[y1][i] = temp2;
			temp2 = temp1;
		}
		return temp2;
	}



}
