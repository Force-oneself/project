package pers.quan.factory;
/**
 * @description 创建Bean对象的工厂
 * 
 * @author 何永泉
 * @date 2019年8月8日 下午3:09:06
 *
 */

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@SuppressWarnings("rawtypes")
public class BeanFactory {

	// 定义一个properties对象
	private static Properties props;
	
	// 定义一个Map
	private static Map<String, Object> beans;
	
	// 使用静态代码块为Properties对象赋值
	static {
		try {
			// 实例化对象
			props = new Properties();
			// 获取properties文件的流对象
			InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
			props.load(in);
			// 实例化容器
			beans = new HashMap<String, Object>();
			// 取出配置文件中所有的key
			Enumeration keys = props.keys();
			// 遍历枚举
			while (keys.hasMoreElements()) {
				// 取出每个key
				String key = keys.nextElement().toString();
				// 根据key获取value
				String beanPath = props.getProperty(key);
				// 反射创建对象
				Object value = Class.forName(beanPath).newInstance();
				// 把key和value存入容器
				beans.put(key, value);
			}
		} catch (Exception e) {
			throw new ExceptionInInitializerError("初始化properties对象失败");
		}
	}
	
	/**
	 * 根据bean的名称获取bean对象（单例）
	 * 
	 * @author 何永泉
	 * @param beanName
	 * @return
	 */
	public static Object getBean(String beanName) {
		System.out.println(beans.get(beanName));
		return beans.get(beanName);
	}
	
	
	/**
	// 使用静态代码块为Properties对象赋值
	static {
		try {
			// 实例化对象
			props = new Properties();
			// 获取properties文件的流对象
			InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
			props.load(in);
		} catch (Exception e) {
			throw new ExceptionInInitializerError("初始化properties对象失败");
		}
	}
	*/
	
	/**
	 * 根据bean的名称获取bean对象（多例）
	 * 
	 * @author 何永泉
	 * @return
	 */
	/**
	public static Object getBean(String beanName) {
		Object bean = null;
		try {
			String beanPath = props.getProperty(beanName);
			bean = Class.forName(beanPath).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	*/
	
}
