package org.choid.study.hello;

import org.choid.study.IHello.IHelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloService implements IHelloService{

	public String hello(String name) {
		return "hello " + name + "!";
	}
}
