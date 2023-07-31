package sol4ch;

public class ch_4_1 {

	public static void main(String[] args) {
		int i= 0;
		int sum = 0;
		for(i=1; i<=20; i++) {
			if(i % 2 != 0 && i % 3 != 0)
				sum+=i;
		}
		System.out.println("sum : " + sum);
	}

}
