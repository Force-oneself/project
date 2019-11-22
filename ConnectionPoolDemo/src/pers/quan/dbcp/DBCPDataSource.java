package pers.quan.dbcp;

import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 *
 * @Discription DBCP连接池数据源
 * @author John丶Woo
 * @date 2019年8月29日 下午3:47:37
 *
 */
public class DBCPDataSource {

	/**
	 * 
	 * @Description 手动编码配置获取
	 * @return
	 */
	public static DataSource getDataSourceByCode() {
		BasicDataSource dbcp = new BasicDataSource();
		dbcp.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dbcp.setUrl("jdbc:mysql://localhost:3306/connection_pool?useSSL=false&serverTimezone=UTC");
		dbcp.setUsername("root");
		dbcp.setPassword("he970801");
		dbcp.setInitialSize(20);
		dbcp.setMaxActive(10);
		return dbcp;
	}

	/**
	 * 
	 * @Description 加载properties配置文件获取
	 * @return
	 * @throws Exception
	 */
	public static DataSource getDataSourceByProperties() throws Exception {
		DataSource dbcp = null;
		Properties props = new Properties();
		InputStream input = new DBCPDataSource().getClass().getClassLoader()
				.getResourceAsStream("dbcpconfig.properties");
		props.load(input);
		// 只需要记住以下一句
		dbcp = BasicDataSourceFactory.createDataSource(props);
		return dbcp;
	}

}
