package org.jsp.dao;

import org.jsp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao  {
	@Autowired
	HibernateTemplate hibernateTemplate;

	public void saveUser(User user) {
		hibernateTemplate.save(user);
		System.out.println("user saved");
	}
}
