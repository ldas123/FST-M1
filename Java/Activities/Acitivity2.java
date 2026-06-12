package activities;

public class Acitivity2 {

	public static void main(String[] args) {
		int arr[] = {10, 77, 10, 54, -11, 10};
		System.out.println(verifySum(arr));

	}
	
	static boolean verifySum(int arr[]) {
		int sum = 0;
		for(int num:arr) {
			if(num==10) {
				sum = sum + num;
			}
		}
		if(sum==30) {
			return true;
		}
		return false;
	}

}
