package org.jsp.dao;

import org.jsp.dto.Employee;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class EmployeeDao extends HibernateDaoSupport {
	@Transactional
	public void saveEmployee(Employee employee) {
		getHibernateTemplate().saveOrUpdate(employee);
	}
}
