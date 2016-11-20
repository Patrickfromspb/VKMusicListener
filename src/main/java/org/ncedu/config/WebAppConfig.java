package org.ncedu.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.sql.DataSource;
import java.io.IOException;

 @Configuration
 @ComponentScan("org.ncedu")
 @EnableWebMvc
 @EnableTransactionManagement
 @PropertySource("classpath:application.properties")
 public class WebAppConfig {
         private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
         private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
         private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
         private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
     
        private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
         private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
         private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
     
                 @Resource
         private Environment env;
     
                 @Bean
         public DataSource dataSource() {
                 DriverManagerDataSource dataSource = new DriverManagerDataSource();
         
                         dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
                 dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
                 dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
                 dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
         
                         return dataSource;
             }
     
                 @Bean
         public LocalSessionFactoryBean sessionFactory() {
                 LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
                 sessionFactoryBean.setDataSource(dataSource());
                 sessionFactoryBean.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
                 sessionFactoryBean.setHibernateProperties(hibProperties());
                 return sessionFactoryBean;
             }
     
                 private Properties hibProperties() {
                 Properties properties = new Properties();
                 properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
                 properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
                 return properties;
             }
     
                 @Bean
         public HibernateTransactionManager transactionManager() {
                 HibernateTransactionManager transactionManager = new HibernateTransactionManager();
                 transactionManager.setSessionFactory(sessionFactory().getObject());
                 return transactionManager;
             }
     

    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

<<<<<<< HEAD
    @Bean
    public DataSource dataSource () {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@192.168.0.108:1521/orcl");
        dataSource.setUsername("admin");
        dataSource.setPassword("1");
        return dataSource;
    }
    @Bean(name = "sessionFactory")
    public SessionFactory sessionFactory () throws Exception {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        //sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
        //sessionFactoryBean.setPackagesToScan("org.ncedu.entity");
        sessionFactoryBean.afterPropertiesSet();
        return sessionFactoryBean.getObject();

    }

    @Bean(name = "hibernateTemplate")
    public HibernateTemplate hibernateTemplate () throws Exception {
        HibernateTemplate hibernateTemplate = new HibernateTemplate();
        hibernateTemplate.setSessionFactory(sessionFactory());
        hibernateTemplate.afterPropertiesSet();
        return hibernateTemplate;
    }

    @Bean(name = "hibernateTransactionManager")
    public HibernateTransactionManager hibernateTransactionManager() throws Exception {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory());
        transactionManager.afterPropertiesSet();
        return transactionManager;
    }

    @Override
    public void addResourceHandlers (ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
=======
>>>>>>> 665591ca6b099976fa63acaecdae0d2fa52f106f
}
