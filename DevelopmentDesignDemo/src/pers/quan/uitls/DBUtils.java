package pers.quan.uitls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @Description: 数据库的工具类
 * @author: 何永泉
 * @date:   2019年7月29日 下午7:24:19
 *
 */
public class DBUtils {

	// JDBC加载驱动包
	private static String driver = "com.mysql.jdbc.Driver";
	// 数据库URL
	private static String url = "jdbc:mysql://localhost:3306/demo";
	// 数据库用户名
	private static String user = "root";
	// 数据库用户密码
	private static String password = "root";
	
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
		if (connection != null) {
			return connection;
		}
		try {
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
