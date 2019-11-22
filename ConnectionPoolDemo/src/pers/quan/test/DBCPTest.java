package pers.quan.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;

import pers.quan.dbcp.DBCPDataSource;

/**
 *
 * @Discription dbcp连接池的测试类
 * @author John丶Woo
 * @date 2019年9月6日 下午10:52:01
 *
 */
public class DBCPTest {

	public static void main(String[] args) throws Exception {
		DataSource ds = DBCPDataSource.getDataSourceByCode();
//		DataSource ds = DBCPDataSource.getDataSourceByProperties();
		Connection conn = ds.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (conn != null) {
			ps = conn.prepareStatement("select * from demo");
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(2));
			}
		}
	}
}
