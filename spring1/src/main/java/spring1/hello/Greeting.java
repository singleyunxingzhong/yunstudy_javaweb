package spring1.hello;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("Greeting")
public class Greeting {
	//@Value(value = "${greeting}")
	private String greeting;
	//@PostConstruct
	public void init() {
		System.out.println(say()+"欢迎进入我的程序");
	}
	//@PreDestroy
	public void destroy() {
		System.out.println(say()+",再见了");
	}
	public String say() {
		return greeting;
	}
}
