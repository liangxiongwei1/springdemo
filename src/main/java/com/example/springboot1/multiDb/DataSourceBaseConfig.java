//package com.example.springboot1.multiDb;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
///**
// * @author liang.xiongwei
// * @Title: DataSourceBaseConfig
// * @Package com.intellif.smart.config
// * @Description
// * @date 2018/12/14 14:21
// */
//@Configuration
//@MapperScan(basePackages = "com.intellif.smart.dao.baseDao", sqlSessionTemplateRef  = "baseSqlSessionTemplate")
//public class DataSourceBaseConfig {
//    @Bean(name = "baseDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.base")
//    @Primary
//    public DataSource baseDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "baseSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory baseSqlSessionFactory(@Qualifier("baseDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/base/*.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "baseTransactionManager")
//    @Primary
//    public DataSourceTransactionManager baseTransactionManager(@Qualifier("baseDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "baseSqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate baseSqlSessionTemplate(@Qualifier("baseSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//}
