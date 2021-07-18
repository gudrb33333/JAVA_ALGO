package level2;

public class ProgLv2BiggestSquer {

	public static void main(String[] args) {
		int answer = 0;
		int [][]board = {
				{0,1,1,1,1,1},
				{1,1,1,1,1,1},
				{1,1,1,1,1,1},
				{0,0,1,1,1,0},
				{0,1,1,1,1,1}
			};
		
		int row = board.length;
		int column = board[0].length;
		int length = 1;
	
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				if(board[i][j] != 0) {
					int a = 0;
					int b = 0;
					loop:
					while(true) {
						++a;
						++b;
						if(i+a == row || j+b ==column) {
							if(answer < length)
								answer = length;
							length = 1;
							break;
						}						
						if(board[i][j+b] != 0 && board[i+a][j] != 0) {
	
							for(int z=i; z<=i+a; z++) {
								if(board[z][j+b] == 0) {
									if(answer < length)
										answer = length;
									length = 1;
									break loop;
								}			
							}
							for(int z=j; z<=j+b; z++) {
								if(board[i+a][z] == 0) {
									if(answer < length)
										answer = length;
									length = 1;
									break loop;
								}		
							}
							
							length++;
						}else {
							length = 1;
							break;
						}
					}
				}
			}
		}
		
		System.out.println(answer);
		
	}

}
