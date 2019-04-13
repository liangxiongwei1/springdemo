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
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
///**
// * @author liang.xiongwei
// * @Title: DataSourceFaceConfig
// * @Package com.intellif.smart.config
// * @Description
// * @date 2018/12/14 14:21
// */
//@Configuration
//@MapperScan(basePackages = "com.intellif.smart.dao.faceDao", sqlSessionTemplateRef  = "faceSqlSessionTemplate")
//public class DataSourceFaceConfig {
//    @Bean(name = "faceDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.face")
//    public DataSource faceDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "faceSqlSessionFactory")
//    public SqlSessionFactory faceSqlSessionFactory(@Qualifier("faceDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/face/*.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "faceTransactionManager")
//    public DataSourceTransactionManager faceTransactionManager(@Qualifier("faceDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "faceSqlSessionTemplate")
//    public SqlSessionTemplate faceSqlSessionTemplate(@Qualifier("faceSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//}
