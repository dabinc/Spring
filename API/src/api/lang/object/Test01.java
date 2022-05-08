package api.lang.object;

public class Test01 {
	
	public Test01( int su ) {
		
		
	}
	public static void main (String args[]) {
		//Object 클래스
		// - 클래스의 조상
		// - 모든 클래스가 기본적으로 가져야할 기능을 정의한 클래스
		// - 자바에서는 모든 클래스가 자동으로 Object를 Inherit
		// - 
		// -
		// -
		// -
		
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		Object d = new Object();
		
		
		c=a;
		d=c;
		System.out.println(a.equals(b));
		System.out.println(c.equals(d));
		
	}

}
