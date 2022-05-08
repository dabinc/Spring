package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test5 {
	
	public static void main(String[] args) {
		
		//���� ó��
		// - ������ �߻��Ǵ� ���� ��°�
		
		//1. try- catch block ���
		//2. throws - JVM���� ���ܸ� ó���ϰ� �ϴ� ���
	
		// ***********exception���ٹ��� ������ ����, ��� �ͼ��� ĳġ�ϵ��� �־��ֱ� ����*****
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			try {
			System.out.println("���� �Է�:");
			int a = in.nextInt();
			
			System.out.println("���� �Է�:");
			int b = in.nextInt();
			
			System.out.println("�� : " + (a/b));
			System.out.println("������:" + (a%b));
			
			} catch (Exception e) {
				in.nextLine();
				System.err.println("����: " + e.getClass());
				// or e.toString() �ᵵ �ȴ�!
				// or e.getMessage() �ᵵ �ȴ�!
				
				//���߿� �ַܼα� e.printStackTrace();
			}
			
		}
	}
}
