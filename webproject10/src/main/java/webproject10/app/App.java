package webproject10.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import webproject10.dao.UserDao;
import webproject10.entity.User;

public class App {

	public static void main(String[] args) {
		//Loading Spring/IOC Container
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		
		UserDao dao = (UserDao) ctx.getBean("userDao");
		
		User user = new User();
		user.setUsername("vaibhav");
		user.setPassword("123456");
		user.setEmail("vaibhav@gmail");
		dao.add(user);
	}

}

