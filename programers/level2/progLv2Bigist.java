package level2;

public class progLv2Bigist {
	
	public static int makeDouble(int x) {
		
		String a = String.valueOf(x);
		while(a.length() != 4) {
			a += a.charAt(0);
		}
		
		return Integer.parseInt(a);
	}
	
	public static void swap(int a[], int idx1, int idx2) {
		int temp = a[idx2];
		a[idx2] = a[idx1];
		a[idx1] = temp;
	}
	
	public static void quickSort(int[] x, int left, int right) {
		int pl = left;
		int pr = right;
		int pivot = x[(pl+pr)/2];
		
		do {
			while(makeDouble(x[pl]) > makeDouble(pivot)) pl++;
			while(makeDouble(x[pr]) < makeDouble(pivot)) pr--;
			
			if(pl <= pr) {
				swap(x,pl++,pr--);
			}
			
		}while(pl <= pr);
		
		if(left < pr) quickSort(x, left, pr);
		if(right > pl) quickSort(x, pl, right);
		
	}
	
	public static void main(String[] args) {
		
		int[] numbers = {0, 0, 0, 0};
		
		
		 String answer = "";
		
		quickSort(numbers,0,numbers.length-1);
		
		for(int i=0; i<numbers.length; i++) {
			answer += numbers[i];
			
		}
		
		if(Double.parseDouble(answer) == 0) answer = "0";
		
		System.out.println(answer);
	}

}
