package sort;

import java.util.Arrays;

public class MergeSort {

	private static void mergeSort(int[] arr, int[] temp, int start, int end) {
		if(start>=end) return;
		
		int mid = (start+end)/2;
		mergeSort(arr,temp,start,mid);
		mergeSort(arr,temp,mid+1,end);
		
		int a = start;
		int b = mid+1;
		int idx = a;
		
		while(a<=mid||b<=end) {
			if(b>end||(a<=mid && arr[a]<arr[b]))
				temp[idx++] = arr[a++];
			else
				temp[idx++] = arr[b++];
		}
		
		for(int i=start; i<=end; i++) {
			arr[i] = temp[i];
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr = {66,3,44,22,11,6,7,8,88};
		int n = arr.length;
		int[] temp = new int[n];
		int start = 0;
		int end = n-1;
		
		mergeSort(arr,temp,start,end);
		
		System.out.println(Arrays.toString(arr));
	}

}
