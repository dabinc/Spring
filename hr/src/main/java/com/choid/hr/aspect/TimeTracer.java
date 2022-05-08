package com.choid.hr.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeTracer {

//	Ŭ������ �ε�, �ν��Ͻ� ����, �޼��� ȣ��, ���� �߻� �� Ư�� �۾� ������ ��������Ʈ�̴�.
//	�����̽��� ������ �� �ִ� ����
//
//	�ֽ���Ʈ�� ������ �ڵ带 ���� �ۼ�
//
//	advice��  ������������ ����Ǵ� ���� �ڵ�� ���� before, after ��
//
//	pointcut�� ��������Ʈ�� �κ�����, advice�� ��� ���� ���ϴ� ��
//
//	aop library �ֱ�� server.xml
	@Pointcut(value="within(com.choid.hr.service.EmpService)")
	// �Ǵ� ......IEmpService+ �� ����ؼ� IEmp �������̽��� �����ϴ� ��� �Ʒ���鿡�� �����Ѵ�.
	private void tracePointCut() {
	}
	// around value = tracePointCut()�޼ҵ忡 , �� �޼ҵ忣 package���� �ְ� �ɾ��ټ��ִµ� 
	// ������ ���� ������ ���� ���� package�� �־��� �� �ִ� .
	// @Around(value = "within(com.choid.hr.service.EmpService)")
	@Around(value = "tracePointCut()")
	
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		Signature method = joinPoint.getSignature();
		String methodName = method.getName();
		System.out.println(methodName + " ����.");
		System.out.println("���� �ð� : " + new java.util.Date());
		
		long startTime = System.nanoTime();
		Object result = null;
		try {
			result = joinPoint.proceed();
		} catch(Exception e) {
			System.out.println("���� �߻� : " + e.getMessage());
		} finally {
			System.out.println(methodName + " ����.");
			System.out.println("���� �ð� : " + new java.util.Date());
		}
		long endTime = System.nanoTime();
		System.out.println("���� �ð� : " + (endTime - startTime) + " ns.");
		return result;
		
		
	}

	
}
