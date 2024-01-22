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

//多資料源 (DB: custom)
//第二個資料源設定
//需透過MapperScan明確指定mapper位置(如果只有一組資料源就不用特別指定)
@Configuration
@MapperScan(basePackages = "com.example.mybatisdemo.mapper.custom", sqlSessionTemplateRef = "CustomSessionTemplate")
public class customSourceConfiguration {

    //對應的application設定
    @Bean("CustomDataSource")
//    @Primary  //精實測, @Primary不一定要加
    @ConfigurationProperties(prefix="spring.datasource.custom")
    public DataSource customDataSource() {
        return DataSourceBuilder.create().build();
    }

    //SessionFactory
    @Bean(name = "CustomSessionFactory")
//    @Primary
    public SqlSessionFactory customSessionFactory(@Qualifier("CustomDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    //TransactionManager
    @Bean(name = "CustomTransactionManager")
//    @Primary
    public DataSourceTransactionManager customTransactionManager(@Qualifier("CustomDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    //SessionTemplate
    @Bean(name = "CustomSessionTemplate")
//    @Primary
    public SqlSessionTemplate customSessionTemplate(@Qualifier("CustomSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
