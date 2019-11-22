package pers.quan.utils;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @Discription mongo database utils
 * @author John丶Woo
 * @date 2019年11月1日 下午2:53:43
 *
 */
public class MongoUtils {

	public static void getConnection() {
		try {
			// 连接到 mongodb 服务
			MongoClient mongoClient = new MongoClient("localhost", 27017);

			// 连接到数据库
			MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
			System.out.println("Connect to database successfully");
			mongoDatabase.createCollection("mycollection");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		getConnection();
	}
}
