package sort;

import java.util.Arrays;

public class BubbleSort {

	static void swap(int[] arr, int idx1, int idx2) {
		int t = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = t;
	}
	
	public static void main(String[] args) {
		int[] arr = {66,3,44,22,11,6,7,8,88};
		int n = arr.length;
		
		for(int i=0; i<n-1; i++) {
			for(int j=n-1; j>i; j--) {
				if(arr[j-1]>arr[j]) {
					swap(arr,j-1,j);
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
