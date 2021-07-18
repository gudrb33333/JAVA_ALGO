package level2;

public class ProgLv2Pivonajji {

	
	
	static long fibo(int n,long[] memo) {
		if (n <= 1) {
			return n;
		}else if(memo[n] != 0) {
			return memo[n];
		}else { 
			return memo[n] = (fibo(n-2,memo) + fibo(n-1,memo))%1234567;
		}
	}
	
	public static void main(String[] args) {
		int n = 1000;
		long[] memo = new long[n+1];
		System.out.println(fibo(n,memo));

	}

}
