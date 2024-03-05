package com.demo.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
@Configuration
@PropertySource("classpath:db.properties")
public class JavaDatabaseConfiguration {

    // SPEL
    @Value("${driver}")
    private String driver;
    @Value("${url}")
    private String url;
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    @Bean
    public DataSource getDataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:8889/java");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        System.out.println("Data source created");
        return dataSource;
    }
    @Bean
    @Autowired
    public JdbcTemplate getTempalte(DataSource ds){
        return new JdbcTemplate(ds);
    }
}
