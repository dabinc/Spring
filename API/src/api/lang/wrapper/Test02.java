package api.lang.wrapper;

public class Test02 {
	
	
	public static void main(String args[]) {
		//API���� integer Ŭ���� ã��
		//1 a�� b��� ��ü 100���� ����
		//2 ȭ�鿡 a,b�� ���
		//3 a��b�� ���� ������ ���
		//4 a�� 16������ ��ȯ�� ���
		//5 b�� 2������ ��ȯ�� ���
		//6 int�� �ƽ��ѹ��� ���
		//7 String x = "12321" , String y = "32123"�̶�� ������ ������
			//x+y�� 1232132123�� ���´�. 44444�� ���ü� �յ��� ������ ��ȯ�Ͽ� �����ϱ�
		
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
