package com.zmf.paixu;

public class Xuanze {

	public static void main(String[] args) {
		int[] arr = new int[] {1,9,20,2,10,8,9,30};
		for(int i = 0; i<arr.length-1;i++) {
			if(i==3) {
				System.out.println(i);
			}
			for(int j = i+1;j<arr.length-1;j++) {
				if(arr[i]>arr[j]) {
					int c = arr[i];
					arr[i] = arr[j];
					arr[j] = c;
				}
			}
			System.out.println(i);
			for (int k : arr) {
				System.out.print(k+",");
			}
			System.out.println();
		}
		for (int k : arr) {
			System.out.print(k+",");
		}
	}
}
