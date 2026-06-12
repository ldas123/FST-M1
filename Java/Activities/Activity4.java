package activities;

import java.util.Arrays;

public class Activity4 {

	public static void main(String[] args) {
		int arr[] = {56,23,89,78,54,12,43,97};
		System.out.println("Array before Sorting: "+Arrays.toString(arr));
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length-1;j++) {
				int temp;
				if(arr[i]>arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("Array after Sorting: "+Arrays.toString(arr));

	}

}
