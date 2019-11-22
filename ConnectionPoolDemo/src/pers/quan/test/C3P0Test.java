package pers.quan.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import pers.quan.c3p0.C3P0DataSource;

/**
 *
 * @Discription c3p0的测试类
 * @author John丶Woo
 * @date 2019年9月6日 下午8:26:16
 *
 */
public class C3P0Test {

	public static void main(String[] args) throws Exception {
		DataSource ds = C3P0DataSource.getDataSourceByProperties();
//		DataSource ds = C3P0DataSource.getDataSourceByCode();
//		DataSource ds = C3P0DataSource.getDataSourceByXml();
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
