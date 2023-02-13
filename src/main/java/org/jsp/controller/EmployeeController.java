package org.jsp.controller;

import org.jsp.dao.EmployeeDao;
import org.jsp.dto.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("all")
public class EmployeeController {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeDao dao = context.getBean(EmployeeDao.class);
		Employee e1 = new Employee();
		e1.setName("Sathish");
		e1.setPhone(888);
		dao.saveEmployee(e1);
	}
}
