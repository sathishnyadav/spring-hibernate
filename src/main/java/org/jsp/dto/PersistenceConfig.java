package org.jsp.dto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("org.jsp")
public class PersistenceConfig {
	@Bean("source")
	public BasicDataSource getDataSource() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/springHibernate_demo");
		source.setUsername("root");
		source.setPassword("root");
		return source;
	}

	@Bean(value = "sessionFactory")
	public LocalSessionFactoryBean getLocalSessionFactoryBean() throws FileNotFoundException, IOException {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setAnnotatedClasses(User.class);
		bean.setDataSource(getDataSource());
		Properties p = new Properties();
		p.load(new FileInputStream("d://hibernate.properties"));
		bean.setHibernateProperties(p);
		return bean;
	}

	@Bean(value = "hibernateTemplate")
	@Autowired
	public HibernateTemplate getHibernateTemplate(SessionFactory factory) {
		HibernateTemplate template = new HibernateTemplate();
		template.setSessionFactory(factory);
		template.setCheckWriteOperations(false);
		return template;

	}
}
