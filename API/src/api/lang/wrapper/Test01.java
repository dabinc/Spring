package api.lang.wrapper;

import javax.net.ssl.SSLEngineResult.Status;

public class Test01 {

	public static void main(String[] args) {
		//Wrapper class
		// - �⺻���� ���������� ���� �ڷ���
		// Boolean - boolean�� ������ Ŭ����
		
		Boolean a = new Boolean("True");
		Boolean b = new Boolean("trUe");
		Boolean c = new Boolean("FALse");
		Boolean d = new Boolean("faLsE");
		
		// ���ڿ��� �����ҋ� ���縵�� ������ �� �Ȱ���
		Boolean.parseBoolean("True");
		System.out.println(a);

		

		
		
		
	}

}
