package sol3ch;

public class ch3_2 {

	public static void main(String[] args) {
		int numOfApples = 123; 
		int sizeOfBucket = 10; 
		int numOfBucket = (int)(Math.ceil((numOfApples / (float)sizeOfBucket)));			
		System.out.println(numOfBucket);
	}

}
