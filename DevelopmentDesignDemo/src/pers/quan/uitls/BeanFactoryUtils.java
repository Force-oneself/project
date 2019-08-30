package pers.quan.uitls;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import pers.quan.factory.BeanFactory;

/**
 * @description bean工厂的工具类
 * @author 何永泉
 * @date 2019年8月12日 下午4:14:14
 *
 */
@SuppressWarnings("rawtypes")
public class BeanFactoryUtils {

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
			props.load(BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties"));
			// 实例化容器
			beans = new HashMap<String, Object>();
			// 取出配置文件中所有的key
			Enumeration keys = props.keys();
			// 遍历枚举
			while (keys.hasMoreElements()) {
				// 取出每个key
				String key = keys.nextElement().toString();
				// 根据key获取value
				// 反射创建对象
				Object value = Class.forName(props.getProperty(key)).newInstance();
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
		return beans.get(beanName);
	}

	/**
	 * 根据bean的名称获取bean对象（多例）
	 * 
	 * @author 何永泉
	 * @return
	 */

	public static Object getBeans(String beanName) {
		Object bean = null;
		try {
			bean = Class.forName(props.getProperty(beanName)).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

}
