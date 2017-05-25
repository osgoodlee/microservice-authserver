package framework.lisi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/** 
* @author lisi
* @since 2017年5月4日 
*/
/**
 * springboot集成mybatis的基本入口
 * 1）创建数据源
 * 2）创建SqlSessionFactory
 */
@Configuration    //该注解类似于spring配置文件
@Order(0)
@MapperScan(basePackages="framework.lisi.dao")
public class MyBatisConfig {
//	 @Autowired
//	    private Environment env;
//	    
//	    /**
//	     * 创建数据源
//	     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错 
//	     */
//	    @Bean
//	    //@Primary
//	    public DataSource getDataSource() throws Exception{
//	        Properties props = new Properties();
//	        props.put("driverClassName", env.getProperty("jdbc.driverClassName"));
//	        props.put("url", env.getProperty("jdbc.url"));
//	        props.put("username", env.getProperty("jdbc.username"));
//	        props.put("password", env.getProperty("jdbc.password"));
////	        return DruidDataSourceFactory.createDataSource(props);
//	        return null;
//	    }
//
//	    /**
//	     * 根据数据源创建SqlSessionFactory
//	     */
//	    @Bean
//	    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception{
//	        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
//	        fb.setDataSource(ds);//指定数据源(这个必须有，否则报错)
//	        //下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
//	        fb.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));//指定基包
//	        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));//指定xml文件位置
//	        
//	        return fb.getObject();
//	    }
}