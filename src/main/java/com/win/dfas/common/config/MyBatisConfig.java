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

import java.sql.SQLException;

import javax.sql.DataSource;

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

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;


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
        
        /** sql监控配置*/
        String filters = env.getProperty("spring.datasource.filters");
        if (!StringUtils.isNotBlank(filters)) {
            filters = "stat";
        }
        dataSource.setFilters(filters);
        
        /** 慢sql监控配置
         * https://github.com/alibaba/druid/wiki/%E9%85%8D%E7%BD%AE_StatFilter
         * https://blog.csdn.net/sjm01234/article/details/79009545
         * */
        String connectionProperties = env.getProperty("spring.datasource.connectionProperties");
        if (!StringUtils.isNotBlank(connectionProperties)) {
           connectionProperties = "druid.stat.mergeSql=true;druid.stat.logSlowSql=true;druid.stat.slowSqlMillis=5000";
        }
        dataSource.setConnectionProperties(connectionProperties);
        
        
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
        bean.setTypeAliasesPackage("com.yhfin.**.model");
        
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath*:com/yhfin/**/dao/**/*.xml"));
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

    
    /**
     * druid监控
     * @return
     */
    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
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
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
