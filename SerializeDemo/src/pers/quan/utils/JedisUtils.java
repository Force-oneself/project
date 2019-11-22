package pers.quan.utils;
/**
 *
 * @Discription redis database utils
 * @author John丶Woo
 * @date 2019年9月21日 下午3:29:48
 *
 */

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {

	private static JedisPool pool;
	private static String host = "localhost";
	private static String auth = "he970801";
	private static int port = 6379;
	private static int MAX_ACTIVE = 1024;
	private static int MAX_IDLE = 200;
	private static int MAX_WAIT = 10000;

	static {
		JedisPoolConfig config = new JedisPoolConfig();
		// 最大连接数
		config.setMaxTotal(MAX_ACTIVE);
		// 最大空闲连接数
		config.setMaxIdle(MAX_IDLE);
		// 获取可用连接的最大等待时间
		config.setMaxWaitMillis(MAX_WAIT);

		pool = new JedisPool(config, host, port);

	}

	/**
	 * 
	 * @Description get jedis connection
	 * @return
	 */
	public static Jedis getJedis() {
		Jedis jedis = pool.getResource();
		jedis.auth(auth);
		return jedis;
	}

	/**
	 * 
	 * @Description close
	 * @param jedis
	 */
	public static void close(Jedis jedis) {
		jedis.close();
	}
}
