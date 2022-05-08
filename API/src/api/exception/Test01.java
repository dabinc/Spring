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
		
		//���� ó��
		// - ������ �߻��Ǵ� ���� ��°�
		
		//1. try- catch block ���
		//2. throws - JVM���� ���ܸ� ó���ϰ� �ϴ� ���
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			int a = 0;
			int b = 0;
			try {
			System.out.println("���� �Է�:");
			a = in.nextInt();
			
			System.out.println("���� �Է�:");
			b = in.nextInt();
			
			} catch (InputMismatchException e) {
				in.nextLine();
				System.err.println("������ �Է��ϼ���!! err");
			}
			try {
				System.out.println("�� : " + (a/b));
				System.out.println("������:" + (a%b));
			} catch ( ArithmeticException e ) {
				System.err.println("0���� ������ �����");
			}
		}
	}
}
