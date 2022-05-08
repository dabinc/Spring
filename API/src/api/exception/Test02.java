package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test02 {
	
	public static void main(String[] args) {
		
		//���� ó��
		// - ������ �߻��Ǵ� ���� ��°�
		
		//1. try- catch block ���
		//2. throws - JVM���� ���ܸ� ó���ϰ� �ϴ� ���
		
//		****************** try���� �ϳ��� ���� �ͼ��� ĳġ ���� ���� �ʴϴ�********
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			try {
			System.out.println("���� �Է�:");
			int a = in.nextInt();
			
			System.out.println("���� �Է�:");
			int b = in.nextInt();
			
			System.out.println("�� : " + (a/b));
			System.out.println("������:" + (a%b));
			
			} catch (InputMismatchException e) {
				in.nextLine();
				System.err.println("������ �Է��ϼ���!! err");
			} catch ( ArithmeticException e ) {
				System.err.println("0���� ������ �����");
			}
		}
	}
}
