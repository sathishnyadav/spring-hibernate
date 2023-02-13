package org.jsp.dto;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class AddProperties {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		p.setProperty("hibernate.hbm2ddl.auto", "update");
		p.setProperty("hibernate.show_sql", "true");
		p.store(new FileOutputStream("D://hibernate.properties"), "Hibernate Properties");
		System.out.println("properties stored");
	}
}
