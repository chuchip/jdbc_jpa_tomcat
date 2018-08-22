package chu.jdbc;

/**
 *
 * @author chuchip
 */

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableLoadTimeWeaving
@EnableJpaRepositories("chu.jdbc")
public class JpaConfig {

    @Autowired
    DataSource ds;
    
   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
      LocalContainerEntityManagerFactoryBean em  = new LocalContainerEntityManagerFactoryBean();
      em.setDataSource(ds);
      em.setPackagesToScan(new String[] { "chu.jdbc" });
 
      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      em.setJpaVendorAdapter(vendorAdapter);   
 
      return em;
   }
 
 
   @Bean
   public PlatformTransactionManager transactionManager( EntityManagerFactory emf){
       JpaTransactionManager transactionManager = new JpaTransactionManager();
       transactionManager.setEntityManagerFactory(emf); 
       return transactionManager;
   } 
  
}
