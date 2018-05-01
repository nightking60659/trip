package Trip.store.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
@EnableTransactionManagement
public class RootAppConfig {
//datasource 設定
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setUser("sa");
		ds.setPassword("sa123456");
		
		try {
			ds.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (PropertyVetoException e) {
			
			e.printStackTrace();
		}
		ds.setJdbcUrl("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Startrip");
		ds.setInitialPoolSize(4);
		ds.setMaxPoolSize(8);
		
		return ds;
	}
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		System.out.println("sessionfactory in rootAppConfig");
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(dataSource());
		//設定scan
		System.out.println("scan");
		factory.setPackagesToScan(new String[] {"_trip","travelPlan"});
		factory.setHibernateProperties(addininalProperties());
		return factory;
	}
	
//	sessionFactory設定
	@Bean(name="trasactionManager")
	@Autowired
	public HibernateTransactionManager txManager(SessionFactory sessionFactory) {
		System.out.println("txManager in rootAppConfig");
		HibernateTransactionManager txManager =new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}
	
	private Properties addininalProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", org.hibernate.dialect.SQLServer2012Dialect.class);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("default_batch_fetch_size", 10);
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
}
