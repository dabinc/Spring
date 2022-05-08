package org.choid.study;
import java.lang.reflect.Field;

import org.choid.study.anno.PracticeAnnotation;
import org.springframework.util.ReflectionUtils;
public class MyContainer {
	public <T> T getInstance(Class c) throws InstantiationException, IllegalAccessException {
		T obj = (T)c.newInstance();
		obj = runAnnotation(obj);
		
		return obj;
	}
	
	private <T> T runAnnotation(T obj) throws IllegalArgumentException, IllegalAccessException, InstantiationException {
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			PracticeAnnotation anno = field.getAnnotation(PracticeAnnotation.class);
			if (anno != null) {
				field.setAccessible(true);
				field.set(obj, field.getType().newInstance());
			}
		}
		return obj;
	}
	
}
