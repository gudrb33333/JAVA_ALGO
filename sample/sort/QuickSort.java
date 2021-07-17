package sort;

import java.util.Arrays;

public class QuickSort {

	private static void swap(int[] arr, int idx1, int idx2) {
		int t = arr[idx2];
		arr[idx2] = arr[idx1];
		arr[idx1] = t;
	}

	private static void quickSort(int[] arr, int start, int end) {
		int pl = start;
		int pr = end;
		int pivot = arr[(pl+pr)/2];
		
		while(pl<=pr) {
			while(arr[pl]<pivot)pl++;
			while(arr[pr]>pivot)pr--;
			if(pl<=pr) {
				swap(arr,pl++,pr--);
			}
		}
		
		if(start<pr) quickSort(arr,start,pr);
		if(pl<end) quickSort(arr,pl,end);
		
	}
	

	public static void main(String[] args) {
		int[] arr = {66,3,44,22,11,6,7,8,88};
		int n = arr.length;
		int start = 0;
		int end = n-1;
		
		quickSort(arr,start,end);

		System.out.println(Arrays.toString(arr));
	}

}
