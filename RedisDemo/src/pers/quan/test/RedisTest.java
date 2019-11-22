package pers.quan.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import pers.quan.entity.User;
import pers.quan.utils.JedisUtils;
import pers.quan.utils.SerializeUtils;
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

	/**
	 * 
	 * @Description 使用序列化和反序列化操作Java对象
	 */
	@Test
	public void useSerialize() {
		jedis.set("user:2".getBytes(), SerializeUtils.serialize(new User(1, "张三")));

		byte[] bytes = jedis.get("user:2".getBytes());
		User user = (User) SerializeUtils.unserialize(bytes);
		System.out.println(user);
	}

	/**
	 * 
	 * @Description 使用FastJSON操作Java对象
	 */
	@Test
	public void useJSON() {
		// 以json格式存储
		jedis.set("json", JSON.toJSONString(new User(2, "李四")));
		// 返回Java对象
		System.out.println(JSON.parseObject(jedis.get("json"), User.class));
	}

	/**
	 * 
	 * @Description 使用hash操作Java对象
	 */
	@Test
	public void useHash() {
		jedis.hset("user:3", "id", "3");
		jedis.hset("user:3", "name", "xiaoming");

		System.out.println(new User(Integer.valueOf(jedis.hget("user:3", "id")), jedis.hget("user:3", "name")));
	}

	@After
	public void close() {
		JedisUtils.close(jedis);
	}
}
