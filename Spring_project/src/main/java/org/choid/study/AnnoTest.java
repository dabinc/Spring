package org.choid.study;

public class AnnoTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		MyContainer container = new MyContainer();
		
		MyData data = container.getInstance(MyData.class);
		System.out.println("data1 : " + data.data1);
		System.out.println("data2 : " + data.data2);

	}

}
