package bitmask;

import java.util.*;

public class BitmaskPerm {

	public static void perm(int[] arr, int n, int[] output, int index, int flag){
		if(index == n) {
			System.out.println(Arrays.toString(output));
			return;
		}
		
		for(int i=0; i<n; i++) {
			if((flag&(1<<i)) != 0) continue;
			
			output[index] = arr[i];
			perm(arr, n, output, index+1, flag|1<<i);
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		int n = arr.length;
		int[] output = new int[n];
		
		int index = 0;
		int flag = 0;
		
		perm(arr, n, output, index, flag);

	}

}
