package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test5 {
	
	public static void main(String[] args) {
		
		//예외 처리
		// - 실행중 발생되는 에러 잡는것
		
		//1. try- catch block 사용
		//2. throws - JVM에게 예외를 처리하게 하는 방식
	
		// ***********exception마다뭐가 나올지 몰라, 모든 익셉션 캐치하도록 넣어주기 가능*****
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			try {
			System.out.println("정수 입력:");
			int a = in.nextInt();
			
			System.out.println("정수 입력:");
			int b = in.nextInt();
			
			System.out.println("목 : " + (a/b));
			System.out.println("나머지:" + (a%b));
			
			} catch (Exception e) {
				in.nextLine();
				System.err.println("에러: " + e.getClass());
				// or e.toString() 써도 된다!
				// or e.getMessage() 써도 된다!
				
				//개발용 콘솔로그 e.printStackTrace();
			}
			
		}
	}
}
