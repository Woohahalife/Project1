package sol3ch;

public class ch3_10 {

	public static void main(String[] args) {
		
		char ch = 'A';
		char lowerCase = ('A' <= ch && ch <= 'Z') ? (char)(ch+32) : ch;
		System.out.println("ch:"+ch);
		System.out.println("ch to lowerCase:"+lowerCase);
		System.out.println(ch);
	}

}
