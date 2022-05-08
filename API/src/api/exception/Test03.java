package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test03 {
	
	public static void main(String[] args) {
		
		//���� ó��
		// - ������ �߻��Ǵ� ���� ��°�
		
		//1. try- catch block ���
		//2. throws - JVM���� ���ܸ� ó���ϰ� �ϴ� ���
	
		// ****finaly
		
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
				System.err.println("����: " + "��ǲ�� �߸���");
			} catch (Exception e) {
				
				System.err.println("����: " + e.getClass());
				// or e.toString() �ᵵ �ȴ�!
				// or e.getMessage() �ᵵ �ȴ�!
				
				//���߿� �ַܼα� e.printStackTrace();
			} finally {
				//try, catch ����ǰ� ������������ ����Ǿ�� �ϴ� ������
				//���⿡ ���ϴ°� default line�� �������
				in.nextLine();
			}
			
		}
	}
}
