package com.unipe.barros.studio.orh.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConfiguration
{

   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource)
   {
      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
      em.setDataSource(dataSource);
      em.setPackagesToScan(new String[] { "com.unipe.barros.studio.orh.models" });

      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      em.setJpaVendorAdapter(vendorAdapter);
      em.setJpaProperties(additionalProperties());

      return em;
   }

   @Bean
   public DataSource dataSource(Environment environment)
   {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName("org.hibernate.dialect.MySQLDialect");
//      dataSource.setUrl("jdbc:postgresql://localhost/studio22");
//      dataSource.setUsername("postgres");
//      dataSource.setPassword("123");
        dataSource.setUrl("jdbc:mysql://localhost/avaliabus");
		dataSource.setUsername("root");
		dataSource.setPassword("");
      return dataSource;
   }

   @Bean
   public PlatformTransactionManager transactionManager(EntityManagerFactory emf)
   {
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(emf);
      return transactionManager;
   }

   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation()
   {
      return new PersistenceExceptionTranslationPostProcessor();
   }

   Properties additionalProperties()
   {
      Properties properties = new Properties();
      properties.setProperty("hibernate.hbm2ddl.auto", "update");
      properties.setProperty("hibernate.show_sql", "true");
      properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
      return properties;
   }
}
