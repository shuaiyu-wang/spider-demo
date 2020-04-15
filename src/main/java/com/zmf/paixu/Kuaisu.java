package com.zmf.paixu;

public class Kuaisu {

	public static void main(String[] args) {
		int[] arr = new int[] {1,9,20,2,10,8,9,30};
		sort(arr, 0, arr.length-1);
		for (int k : arr) {
			System.out.print(k+",");
		}
	}
	public static void sort(int[] arr,int start,int end) {
		int startindex = start;
		int endindex = end;
		int key = arr[start];
		while(startindex < endindex) {
			while(startindex < endindex && arr[endindex] >= key) {
				endindex --;
			}
			if(arr[endindex] < key) {
				int c = arr[startindex];
				arr[startindex] = arr[endindex];
				arr[endindex] = c;
			}
			while(startindex < endindex && arr[startindex]<=key) {
				startindex++;
			}
			if(arr[startindex]>key) {
				int c = arr[startindex];
				arr[startindex] = arr[endindex];
				arr[endindex] = c;
			}
		}
		if(startindex>start) {
			sort(arr, start, startindex-1);
		}
		if(endindex<end) {
			sort(arr, endindex+1, end);
		}
		
	}
}
