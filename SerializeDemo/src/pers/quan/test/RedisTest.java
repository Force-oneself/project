package pers.quan.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pers.quan.utils.JedisUtils;
import redis.clients.jedis.Jedis;

/**
 *
 * @Discription connection redis test
 * @author John丶Woo
 * @date 2019年9月21日 下午3:30:10
 *
 */
public class RedisTest {

	private static Jedis jedis = null;

	@Before
	public void getConnection() {
		jedis = JedisUtils.getJedis();
	}

	@Test
	public void useMySQLAndRedisTest() {
		String key = "Hello";
		if (jedis.exists(key)) {
			System.out.println("Redis中取值：" + jedis.get(key));
		} else {
			System.out.println("MySQL中取值并且添加进Redis中");
			jedis.set(key, "World");
		}
	}

	@After
	public void close() {
		JedisUtils.close(jedis);
	}
}
