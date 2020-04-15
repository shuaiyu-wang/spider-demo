package com.zmf.paixu;

public class Maopao {

	public static void main(String[] args) {
		int[] arr = new int[] {1,9,20,2,10,8,9,30};
		for(int i = 0; i<arr.length;i++) {
			for(int j = i;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int c = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = c;
				}
			}
		}
		for (int k : arr) {
			System.out.print(k+",");
		}
	}
}
