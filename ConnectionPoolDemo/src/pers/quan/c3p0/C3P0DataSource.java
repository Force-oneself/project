package pers.quan.c3p0;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 *
 * @Discription c3p0连接池
 * @author John丶Woo
 * @date 2019年8月29日 下午8:21:40
 *
 */
public class C3P0DataSource {

	/**
	 * 
	 * @Description 加载properties配置文件获取
	 * @return
	 */
	public static DataSource getDataSourceByProperties() {
	    Properties props = new Properties();  
	    InputStream in = new C3P0DataSource().getClass().getClassLoader().getResourceAsStream("c3p0.properties");  
	    ComboPooledDataSource cpds = null;
		try {
			props.load(in);  
			in.close();  
			  
			cpds = new ComboPooledDataSource();  
			cpds.setDriverClass(props.getProperty("driverClass"));
		} catch (IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    cpds.setJdbcUrl(props.getProperty("jdbcUrl"));  
	    cpds.setUser(props.getProperty("user"));  
	    cpds.setPassword(props.getProperty("password"));  
		return cpds;
	}
	
	/**
	 * 
	 * @Description 手动代码配置获取
	 * @return
	 */
	public static DataSource getDataSourceByCode(){
        ComboPooledDataSource c3p0 = new ComboPooledDataSource();
        try {
            c3p0.setDriverClass("com.mysql.cj.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        c3p0.setJdbcUrl("jdbc:mysql://localhost:3306/connection_pool?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8");
        c3p0.setUser("root");
        c3p0.setPassword("he970801");

        return c3p0 ;
    }

	/**
	 * 
	 * @Description 加载xml配置文件获取
	 * @return
	 */
    public static DataSource getDataSourceByXml(){
        ComboPooledDataSource c3p0 = new ComboPooledDataSource();
        return c3p0 ;
    }
    
}
