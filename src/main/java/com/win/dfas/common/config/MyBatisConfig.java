/****************************************************
<<<<<<< HEAD
 * 创建人：  @author xiep
=======
 * 创建人：  @author xiep    
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
 * 创建时间: 2017-11-7/14:30:36
 * 项目名称: ycmp-api
 * 文件名称: MyBatisConfig.java
 * 文件描述: @Description
 * 公司名称: 深圳市赢和信息技术有限公司
 *
 * All rights Reserved, Designed By 深圳市赢和信息技术有限公司
 * @Copyright:2016-2017
<<<<<<< HEAD
 *
=======
 * 
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
 ********************************************************/

package com.win.dfas.common.config;

import java.sql.SQLException;
<<<<<<< HEAD
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;
=======

import javax.sql.DataSource;

>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
import org.apache.commons.lang.StringUtils;
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
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

<<<<<<< HEAD

=======
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066


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
<<<<<<< HEAD
     * @Title: defaultDataSource
     * @Description: 创建数据源
     * @return DataSource
     * @throws SQLException
=======
     * @Title: defaultDataSource 
     * @Description: 创建数据源
     * @return DataSource
     * @throws SQLException 
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
     */
    @Primary
    @Bean(name = "defaultDataSource")
    public DataSource defaultDataSource() throws SQLException {
        String sDriver = env.getProperty("spring.datasource.driver-class-name");
        if (StringUtils.isEmpty(sDriver)) {
            return null;
        }
<<<<<<< HEAD

        HikariDataSource dataSource = new HikariDataSource();
//        dataSource.setJdbcUrl();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        //心跳检查
        dataSource.setConnectionTestQuery(env.getProperty("spring.datasource.validationQuery"));
        /** 配置获取连接等待超时的时间 毫秒 */
        String maxWait = env.getProperty("spring.datasource.maxWait");
        if (StringUtils.isNotBlank(maxWait)) {
            dataSource.setConnectionTimeout(Long.parseLong(maxWait));
        }
        /** 最大并发连接数 maxActive */
        String maxActive = env.getProperty("spring.datasource.maxActive");
        if (StringUtils.isNotBlank(maxActive)) {
            dataSource.setMaximumPoolSize(Integer.parseInt(maxActive));
        }
        /** 最小空闲连接数 minIdle 官方建议不设置*/
        String minIdle = env.getProperty("spring.datasource.minIdle");
        if (StringUtils.isNotBlank(minIdle)) {
            dataSource.setMinimumIdle(Integer.parseInt(minIdle));
        }
        /** idleTimeout 空闲连接释放最大时间-最大空闲连接时间*/
        String idleTimeout = env.getProperty("spring.datasource.idleTimeout");
        if (StringUtils.isNotBlank(idleTimeout)) {
            dataSource.setIdleTimeout(Long.parseLong(idleTimeout));
        }
        /** maxLifetime 连接的最大生命周期*/
        String maxLifetime = env.getProperty("spring.datasource.maxLifetime");
        if (StringUtils.isNotBlank(maxLifetime)) {
            dataSource.setMaxLifetime(Long.parseLong(maxLifetime));
        }
        /**设置连接池名*/
        String poolname = env.getProperty("spring.datasource.poolname");
        if (StringUtils.isNotBlank(poolname)) {
            dataSource.setPoolName(poolname);
        }


=======
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        dataSource.setValidationQuery(env.getProperty("spring.datasource.validationQuery"));
        /** 配置获取连接等待超时的时间 毫秒 */
        String maxWait = env.getProperty("spring.datasource.maxWait");
        if (StringUtils.isNotBlank(maxWait)) {
            dataSource.setMaxWait(Long.parseLong(maxWait));
        }
        
        /** 最大并发连接数 maxActive */
        String maxActive = env.getProperty("spring.datasource.maxActive");
        if (StringUtils.isNotBlank(maxActive)) {
            dataSource.setMaxActive(Integer.parseInt(maxActive));
        }
        /** 初始化连接数量 initialSize */
        String initialSize = env.getProperty("spring.datasource.initialSize");
        if (StringUtils.isNotBlank(initialSize)) {
            dataSource.setInitialSize(Integer.parseInt(initialSize));
        }
        /** 最小空闲连接数 minIdle*/
        String minIdle = env.getProperty("spring.datasource.minIdle");
        if (StringUtils.isNotBlank(minIdle)) {
            dataSource.setMinIdle(Integer.parseInt(minIdle));
        }
        
        /** poolPreparedStatements */
        String poolPreparedStatements = env.getProperty("spring.datasource.poolPreparedStatements");
        if (StringUtils.isNotBlank(poolPreparedStatements)) {
            dataSource.setPoolPreparedStatements(Boolean.parseBoolean(poolPreparedStatements));
        }
        
        /** maxOpenPreparedStatements */
        String maxOpenPreparedStatements = env.getProperty("spring.datasource.maxOpenPreparedStatements");
        if (StringUtils.isNotBlank(maxOpenPreparedStatements)) {
            dataSource.setMaxOpenPreparedStatements(Integer.parseInt(maxOpenPreparedStatements));
        }
        
        /** timeBetweenEvictionRunsMillis 监控间隔时间毫秒*/
        String timeBetweenEvictionRunsMillis = env.getProperty("spring.datasource.timeBetweenEvictionRunsMillis");
        if (StringUtils.isNotBlank(timeBetweenEvictionRunsMillis)) {
            dataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(timeBetweenEvictionRunsMillis));
        }
        
        /** minEvictableIdleTimeMillis 连接池保持最小时间*/
        String minEvictableIdleTimeMillis = env.getProperty("spring.datasource.minEvictableIdleTimeMillis");
        if (StringUtils.isNotBlank(minEvictableIdleTimeMillis)) {
            dataSource.setMinEvictableIdleTimeMillis(Long.parseLong(minEvictableIdleTimeMillis));
        }
        
        /** testWhileIdle */
        String testWhileIdle = env.getProperty("spring.datasource.testWhileIdle");
        if (StringUtils.isNotBlank(testWhileIdle)) {
            dataSource.setTestWhileIdle(Boolean.parseBoolean(testWhileIdle));
        }
        
        /** 1.0.28版本之后，新加入keepAlive配置，缺省关闭
         * 参见: https://github.com/alibaba/druid/wiki/KeepAlive_cn
         **/
        dataSource.setKeepAlive(true);
        
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
        /** sql监控配置*/
        String filters = env.getProperty("spring.datasource.filters");
        if (!StringUtils.isNotBlank(filters)) {
            filters = "stat";
        }
<<<<<<< HEAD
//        dataSource.setFilters(filters);health-check-registry
        dataSource.setHealthCheckRegistry(filters);
        dataSource.setMetricRegistry(filters);
=======
        dataSource.setFilters(filters);
        
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
        /** 慢sql监控配置
         * https://github.com/alibaba/druid/wiki/%E9%85%8D%E7%BD%AE_StatFilter
         * https://blog.csdn.net/sjm01234/article/details/79009545
         * */
        String connectionProperties = env.getProperty("spring.datasource.connectionProperties");
        if (!StringUtils.isNotBlank(connectionProperties)) {
           connectionProperties = "druid.stat.mergeSql=true;druid.stat.logSlowSql=true;druid.stat.slowSqlMillis=5000";
        }
<<<<<<< HEAD
//        dataSource.setConnectionProperties(connectionProperties);
        dataSource.setHealthCheckProperties(new Properties());
=======
        dataSource.setConnectionProperties(connectionProperties);
        
        
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
        return dataSource;
    }

    /**
<<<<<<< HEAD
     * @Title: sqlSessionFactoryBean
=======
     * @Title: sqlSessionFactoryBean 
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
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
<<<<<<< HEAD

        bean.setDataSource(defaultDataSource);
        bean.setTypeAliasesPackage("com.**.model");

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath*:com/**/dao/**/*.xml"));
=======
        
        bean.setDataSource(defaultDataSource);
        bean.setTypeAliasesPackage("com.yhfin.**.model");
        
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath*:com/yhfin/**/dao/**/*.xml"));
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
            return bean.getObject();
        } catch (Exception e) {
            logger.error("mybatis初始化sqlSessionFactoryBean失败", e);
        }
        return null;
    }

    /**
<<<<<<< HEAD
     * @Title: sqlSessionTemplate
=======
     * @Title: sqlSessionTemplate 
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
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
<<<<<<< HEAD
     * @Title: transactionManager
=======
     * @Title: transactionManager 
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
     * @Description: 事物管理
     * @param dataSource 数据源
     * @return DataSourceTransactionManager
     */
    @Primary
    @Bean(name = "defaultTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("defaultDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

<<<<<<< HEAD

=======
    
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
    /**
     * druid监控
     * @return
     */
    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean();
<<<<<<< HEAD
//        reg.setServlet(new StatViewServlet());
        //TODO
=======
        reg.setServlet(new StatViewServlet());
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
        reg.addUrlMappings("/druid/*");
        //reg.addInitParameter("allow", "127.0.0.1");
        //reg.addInitParameter("deny","");
        reg.addInitParameter("loginUsername", "ycmpadmin");
        reg.addInitParameter("loginPassword", "ycmpadmin");
        return reg;
    }

    /**
     * druid监控过滤
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
<<<<<<< HEAD
//        filterRegistrationBean.setFilter(new WebStatFilter());
        //TODO
=======
        filterRegistrationBean.setFilter(new WebStatFilter());
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
