package sol3ch;

public class ch3_7 {

	public static void main(String[] args) {
//		C =5/9 ×(F - 32) ->화씨를 섭씨로 바꾸는 공식
		int fahrenheit = 94;
		float celcius = (int)((5/9f *(fahrenheit - 32)*100)+0.5)/100f;
		System.out.println("Fahrenheit:"+fahrenheit);
		System.out.println("Celcius:"+celcius);

	
	}

}
