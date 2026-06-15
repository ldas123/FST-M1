package activities;

public class Activity11 {

	public static void main(String[] args) {
		
		Addable ad1 = (num1,num2) -> num1+num2;
		System.out.println(ad1.add(20, 10));
		
		Addable ad2 = (int num1,int num2) -> {
			return num1+num2;
		};
		
		System.out.println(ad2.add(120, 230));
		

	}

}
