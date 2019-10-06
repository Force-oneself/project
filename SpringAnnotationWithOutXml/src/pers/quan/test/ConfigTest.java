package pers.quan.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pers.quan.config.SpringConfig;

/**
 *
 * @Discription 纯注解配置测试类
 * @author John丶Woo
 * @date 2019年9月9日 下午12:47:05
 *
 */
public class ConfigTest {

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) throws Exception {
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
		Connection conn = ac.getBean("ds", DataSource.class).getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (conn != null) {
			ps = conn.prepareStatement("select * from demo");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(2));
			}
		}

	}
}
