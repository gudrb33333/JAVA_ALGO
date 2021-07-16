package level2;

public class ProgLv2Carpet {

	public static void main(String[] args) {
		int brown = 24;
		int yellow = 24;
		
		int maxRow = 3;
		int maxColumn = 3;
		int k = 0;
		
		while(true) {
			if(maxRow*2+maxColumn*2-4<brown) {
				if(k==0) {
					maxColumn++;
					k=1;
				}else {
					maxRow++;
					k=0;
				}
			}else {
				break;
			}
			
		} 

		int row = maxRow;
		int column = maxColumn;
			
		while(true) {
			
			if(yellow < (row-2)*(column-2)) {
				row--;
				column++;
			}else {
				break;
			}
		}
		
		System.out.println(column);
		System.out.println(row);
	}

}
