package sol4ch;

public class ch_4_2 {

	public static void main(String[] args) {
		
		int i = 0;
		int sum = 0;
		int tsum = 0;
		
		for(i = 1; i <= 10; i++) {
			sum += i;
			tsum += sum;
		}
		System.out.println(tsum);
	
	}

}
