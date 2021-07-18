package level2;

public class ProgLv2block4 {
	
	static int answer = 0;
	
	private static void fourBlockCheck(char[][] board2, boolean[][] a) {
		boolean fourBlock = false;
		for(int i=0; i<board2.length-1; i++) {
			for(int j=0; j<board2[i].length-1; j++) {
				if(board2[i][j] != 'n') {
				 if(board2[i][j] == board2[i][j+1] &&
					board2[i][j] == board2[i+1][j] &&
					board2[i][j] == board2[i+1][j+1])
				 	{
					 a[i][j] = a[i][j+1] = a[i+1][j] = a[i+1][j+1] = true;	
					 fourBlock = true;
				 	}
				}
			}		
		}
		
		if(fourBlock == false) return;
		
		for(int i=0; i<board2.length; i++) {
			for(int j=0; j<board2[i].length; j++) {
				if(a[i][j] == true) {
					answer++;
					board2[i][j] = 'n';
					a[i][j] = false;
				}		
			}
		}	
		
		for(int i=0; i<board2[0].length; i++) {
			int b = 0;
			int j = board2.length-1;
			while(true) {
				
					if(board2[j][i] == 'n') {
						if(b== board2.length-1) break;
						for(int k=j; k>=1; k--) {
							char temp = board2[k-1][i] ;
							board2[k-1][i] = board2[k][i];
							board2[k][i] = temp;
						}
						b++;
					}else {
						if(j==0) break;
						j--;					
					}	
			}
		}	
		
		
		fourBlockCheck(board2,a);	
	}
	

	public static void main(String[] args) {
		String[] board = {
				"CCBDE", "AAADE", "AAABF", "CCBBF"
				};
		
		
		char[][] board2 = new char[board.length][board[0].length()];
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length(); j++) {
				board2[i][j] = board[i].charAt(j);
			}
		}

		boolean[][] a = new boolean[board.length][board[0].length()];
		
		fourBlockCheck(board2,a);
		System.out.println(answer);
	}

}
