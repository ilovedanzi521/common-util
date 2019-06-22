/****************************************************
 * 创建人：  @author xiep
 * 创建时间: 2017-11-7/14:30:36
 * 项目名称: ycmp-api
 * 文件名称: MyBatisConfig.java
 * 文件描述: @Description
 * 公司名称: 深圳市赢和信息技术有限公司
 *
 * All rights Reserved, Designed By 深圳市赢和信息技术有限公司
 * @Copyright:2016-2017
 *
 ********************************************************/

package com.win.dfas.common.config;

import cn.hutool.core.util.StrUtil;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.LocalCacheScope;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.sql.SQLException;


/**
 * @Description: Mybatis基础配置
 */
@Configuration
@MapperScan(basePackages = "com.win.**.dao", sqlSessionFactoryRef = "defaultSqlSessionFactory")
@ConditionalOnProperty(value="mybatis.datasource.enable")
public class MyBatisConfig {

    /**
     * 日志.
     */
    private static final Logger logger = LoggerFactory.getLogger(MyBatisConfig.class);

    /**
     * env.
     */
    @Autowired
    private Environment env;

    /**
     * @Title: defaultDataSource
     * @Description: 创建数据源
     * @return DataSource
     * @throws SQLException
     */
    @Primary
    @Bean(name = "defaultDataSource")
    public DataSource defaultDataSource() throws SQLException {
        String sDriver = env.getProperty("spring.datasource.driver-class-name");
        if (StringUtils.isEmpty(sDriver)) {
            return null;
        }

        HikariDataSource dataSource = new HikariDataSource();
//        dataSource.setJdbcUrl();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        //心跳检查
        dataSource.setConnectionTestQuery(env.getProperty("spring.datasource.hikari.connection-test-query"));
        /** 配置获取连接等待超时的时间 毫秒 */
        String maxWait = env.getProperty("spring.datasource.hikari.connection-timeout");
        if (StrUtil.isNotBlank(maxWait)) {
            dataSource.setConnectionTimeout(Long.parseLong(maxWait));
        }
        /** 最大并发连接数 maximum-pool-size */
        String maxActive = env.getProperty("spring.datasource.hikari.maximum-pool-size");
        if (StrUtil.isNotBlank(maxActive)) {
            dataSource.setMaximumPoolSize(Integer.parseInt(maxActive));
        }
        /** 最小空闲连接数 minIdle 官方建议不设置*/
        String minIdle = env.getProperty("spring.datasource.hikari.minimum-idle");
        if (StrUtil.isNotBlank(minIdle)) {
            dataSource.setMinimumIdle(Integer.parseInt(minIdle));
        }
        /** idleTimeout 空闲连接释放最大时间-最大空闲连接时间*/
        String idleTimeout = env.getProperty("spring.datasource.hikari.idle-timeout");
        if (StrUtil.isNotBlank(idleTimeout)) {
            dataSource.setIdleTimeout(Long.parseLong(idleTimeout));
        }
        /** maxLifetime 连接的最大生命周期*/
        String maxLifetime = env.getProperty("spring.datasource.hikari.max-lifetime");
        if (StrUtil.isNotBlank(maxLifetime)) {
            dataSource.setMaxLifetime(Long.parseLong(maxLifetime));
        }
        /**设置连接池名*/
        String poolname = env.getProperty("spring.datasource.hikari.pool-name");
        if (StrUtil.isNotBlank(poolname)) {
            dataSource.setPoolName(poolname);
        }
        return dataSource;
    }

    /**
     * @Title: sqlSessionFactoryBean
     * @Description: 获取session工厂
     * @param defaultDataSource 默认的数据源
     * @return SqlSessionFactory
     */
    @Primary
    @Bean(name = "defaultSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("defaultDataSource") DataSource defaultDataSource) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        /**
         * 关于session的全局缓存，否则将导致同一微服务部署多台，缓存不同步问题，
         * 需要设置 CacheEnabled=false ，LocalCacheScope=Statement
         */
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setCacheEnabled(false);
        configuration.setLocalCacheScope(LocalCacheScope.STATEMENT);
        bean.setConfiguration(configuration);

        bean.setDataSource(defaultDataSource);
        bean.setTypeAliasesPackage("com.**.entity");

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath*:com/**/dao/**/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            logger.error("mybatis初始化sqlSessionFactoryBean失败", e);
        }
        return null;
    }

    /**
     * @Title: sqlSessionTemplate
     * @Description: sqlSessionTemplate实例
     * @param sqlSessionFactory session工厂
     * @return SqlSessionTemplate
     */
    @Primary
    @Bean("defaultSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * @Title: transactionManager
     * @Description: 事物管理
     * @param dataSource 数据源
     * @return DataSourceTransactionManager
     */
    @Primary
    @Bean(name = "defaultTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("defaultDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
