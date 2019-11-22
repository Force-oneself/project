package pers.quan.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @Discription serialize util
 * @author John丶Woo
 * @date 2019年10月6日 下午5:21:28
 *
 */
public class SerializeUtils {

	/**
	 * 
	 * @Description 序列化
	 * @param object
	 * @return
	 */
	public static byte[] serialize(Object object) {
		// 序列化流 （输出流） --> 表示向一个目标 写入数据
		ObjectOutputStream oos = null;
		// 字节数组输出流
		ByteArrayOutputStream baos = null;
		try {
			// 创建一个缓冲区
			baos = new ByteArrayOutputStream();
			// 将 对象 序列化成 字节后 输入缓冲区中
			oos = new ObjectOutputStream(baos);
			// 序列化 对象
			oos.writeObject(object);
			// 得 到 序列化字节
			byte[] bytes = baos.toByteArray();
			// 清空输出流
			oos.flush();
			// 释放资源
			oos.close();
			return bytes;
		} catch (Exception e) {
			System.out.println("出现异常:" + e.getMessage());
		} finally {
			try {
				if (baos != null) {
					baos.close();
				}
				if (oos != null) {
					oos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 
	 * @Description 反序列化（反射）
	 * @param <T>
	 * @param bytes
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T deserialize(byte[] bytes, Class<T> clazz) {
		// 字节数组
		ByteArrayInputStream bais = null;
		try {
			// 将 得到的序列化字节 丢进 缓冲区
			bais = new ByteArrayInputStream(bytes);
			// 反序列化流 （输入流）--> 表示着从 一个 源头 读取 数据 ， （读取 缓冲区中 的字节）
			ObjectInputStream ois = new ObjectInputStream(bais);
			// 反序化成 一个对象
			return (T) ois.readObject();
		} catch (Exception e) {
			System.out.println("出现异常:" + e.getMessage());
		} finally {
			try {
				if (bais != null) {
					bais.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 
	 * @Description 反序列化
	 * @param bytes
	 * @return
	 */
	public static Object unserialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		try {
			// 反序列化  
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bais != null) {
					bais.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
