package org.jsp.controller;

import org.jsp.dao.UserDao;
import org.jsp.dto.PersistenceConfig;
import org.jsp.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SuppressWarnings("all")
public class UserController {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(PersistenceConfig.class);
		UserDao dao = context.getBean(UserDao.class);
		User user = new User();
		user.setName("Sathish");
		user.setPhone(88888);
		dao.saveUser(user);
	}
}
