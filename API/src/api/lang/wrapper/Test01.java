package api.lang.wrapper;

import javax.net.ssl.SSLEngineResult.Status;

public class Test01 {

	public static void main(String[] args) {
		//Wrapper class
		// - 기본형을 참조형으로 만든 자료형
		// Boolean - boolean을 랩핑한 클래스
		
		Boolean a = new Boolean("True");
		Boolean b = new Boolean("trUe");
		Boolean c = new Boolean("FALse");
		Boolean d = new Boolean("faLsE");
		
		// 문자열로 지정할떄 스펠링만 맏으면 다 똑같음
		Boolean.parseBoolean("True");
		System.out.println(a);

		

		
		
		
	}

}
