package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test01 {
	
	
	public void sleep() /*InterruptedException*/ {
		try {
		Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
	}
	
	public void sleep3() /*throws InterruptedException*/ {
		sleep();
		sleep();
		sleep();
	}
	
	public static void main(String[] args) {
		
		//예외 처리
		// - 실행중 발생되는 에러 잡는것
		
		//1. try- catch block 사용
		//2. throws - JVM에게 예외를 처리하게 하는 방식
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			int a = 0;
			int b = 0;
			try {
			System.out.println("정수 입력:");
			a = in.nextInt();
			
			System.out.println("정수 입력:");
			b = in.nextInt();
			
			} catch (InputMismatchException e) {
				in.nextLine();
				System.err.println("정수만 입력하세요!! err");
			}
			try {
				System.out.println("목 : " + (a/b));
				System.out.println("나머지:" + (a%b));
			} catch ( ArithmeticException e ) {
				System.err.println("0으로 나눌수 없어요");
			}
		}
	}
}
