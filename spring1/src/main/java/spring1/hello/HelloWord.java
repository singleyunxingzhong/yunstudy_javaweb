package spring1.hello;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWord {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        //Greeting greeting = context.getBean("Greeting",Greeting.class);
        String content="where are you";
        FileWriterService fws = context.getBean("FileWriterService",FileWriterService.class);
        try {
			fws.writeContent(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
        ((ConfigurableApplicationContext) context).close();
	}

}
