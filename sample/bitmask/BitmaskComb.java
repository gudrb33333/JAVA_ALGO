package bitmask;

import java.util.*;

public class BitmaskComb {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4};
		int n = arr.length;
		int[] output = new int[n];
		
		for(int i=0; i<1<<n; i++) {
			
			for(int j=0; j<n; j++) {
				if((i&(1<<j)) != 0) {
					output[j] = arr[j];			
				}
			}
			System.out.println(Arrays.toString(output));
			Arrays.fill(output, 0);
		}

	}

}
