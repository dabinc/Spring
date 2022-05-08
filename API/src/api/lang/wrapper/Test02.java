package api.lang.wrapper;

public class Test02 {
	
	
	public static void main(String args[]) {
		//API에서 integer 클래스 찾기
		//1 a와 b라는 객체 100으로 생성
		//2 화면에 a,b값 출력
		//3 a와b의 값이 같은지 출력
		//4 a를 16진수로 변환후 출력
		//5 b를 2진수로 변환후 출력
		//6 int의 맥스넘버를 출력
		//7 String x = "12321" , String y = "32123"이라는 변수가 잇을떄
			//x+y는 1232132123이 나온다. 44444가 나올수 잇도록 정수로 변환하여 덧셈하기
		
		//1
		Integer a = new Integer(100);
		Integer b = new Integer(100);
		
		//2
		System.out.println(a);
		System.out.println(b.toString());
		
		//3
		System.out.println(a.equals(b));
		
		//4
		System.out.println(Integer.toHexString(a));
		
		//5
		System.out.println(Integer.toBinaryString(b));
		
		//6
		System.out.println(Integer.MAX_VALUE);
		
		//7
		String x = "12321";
		String y = "32123";
	
		Integer c = new Integer(x);
		Integer d = new Integer(y);
		
		System.out.println(c+d);
		
	}

}
