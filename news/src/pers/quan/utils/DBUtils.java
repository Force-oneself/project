package pers.quan.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description 数据库的工具类
 * @author 何永泉
 * @date 2019年8月20日 下午4:25:51
 *
 */
public class DBUtils {

	// JDBC加载驱动包
	private static String driver = "com.mysql.cj.jdbc.Driver";
	// 数据库URL
	private static String url = "jdbc:mysql://localhost:3306/news?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT";
	// 数据库用户名
	private static String user = "root";
	// 数据库用户密码
	private static String password = "he970801";

	private static Connection connection = null;

	/**
	 * 
	 * @Description: 获取数据库连接
	 * @author: 何永泉
	 * @param:       
	 * @return: Connection      
	 * @throws
	 *
	 */
	public static Connection getConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				return connection;
			}
			// 加载驱动
			System.out.println("加载驱动中......");
			Class.forName(driver);
			System.out.println("加载驱动成功");
			// 打开链接
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("连接数据库成功");
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动失败!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库连接失败!");
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 
	 * @Description: 释放资源
	 * @author: 何永泉
	 * @param: conn
	 * @param: ps
	 * @param: rs      
	 * @return: void      
	 * @throws
	 *
	 */
	public static void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("ResultSet对象关闭失败!");
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				System.out.println("PreparedStatement对象关闭失败!");
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Connection对象关闭失败!");
				e.printStackTrace();
			}
		}
	}
}
