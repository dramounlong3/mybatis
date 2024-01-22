package com.example.mybatisdemo.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


//多資料源 (DB: demo)
//第一個資料源設定
//需透過MapperScan明確指定mapper位置(如果只有一組資料源就不用特別指定)
@Configuration
@MapperScan(basePackages = "com.example.mybatisdemo.mapper.demo", sqlSessionTemplateRef = "DemoSessionTemplate")
public class demoSourceConfiguration {

    //對應的application設定
    @Bean("DemoDataSource")
//    @Primary  //精實測, @Primary不一定要加
    @ConfigurationProperties(prefix="spring.datasource.demo")
    public DataSource demoDataSource() {
        return DataSourceBuilder.create().build();
    }

    //SessionFactory
    @Bean(name = "DemoSessionFactory")
//    @Primary
    public SqlSessionFactory demoSessionFactory(@Qualifier("DemoDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    //TransactionManager
    @Bean(name = "DemoTransactionManager")
//    @Primary
    public DataSourceTransactionManager demoTransactionManager(@Qualifier("DemoDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    //SessionTemplate
    @Bean(name = "DemoSessionTemplate")
//    @Primary
    public SqlSessionTemplate demoSessionTemplate(@Qualifier("DemoSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
