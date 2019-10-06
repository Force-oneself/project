package pers.quan.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 *
 * @Discription 
 * @author John丶Woo
 * @date 2019年9月9日 下午12:25:07
 *
 */
@Configuration
@PropertySource("classpath:pers/quan/config/jdbc.properties")
public class JDBCConfig {

	@Value("${jdbc.driver}")
	private String driver;

	@Value("${jdbc.url}")
	private String url;

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.password}")
	private String password;

	@Bean(name = "ds")
	public DataSource createDataSource() {
		try {
			ComboPooledDataSource ds = new ComboPooledDataSource();
			ds.setDriverClass(driver);
			ds.setJdbcUrl(url);
			ds.setUser(username);
			ds.setPassword(password);
			return ds;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
