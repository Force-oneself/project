package pers.quan;

import java.io.FileOutputStream;

/**
 *
 * @Discription OutputStream Demo
 * @author John丶Woo
 * @date 2019年10月3日 上午7:55:07
 *
 */
public class OutputStreamDemo {

	/**
	 * 
	 * @Description 使用文件字节输入流
	 * @throws Exception
	 */
	public static void useFileOutputStream() throws Exception {

//		FileOutputStream fos = new FileOutputStream(new File("a.txt"));
		// 使用追加文件
		FileOutputStream fos = new FileOutputStream("a.txt", true);

		// 十进制数将转化成二进制数写入文件
		// 使用字节写入文件
		fos.write(97);

		/*
		 * 如果写的第一个字节是正数(0-127),那么显示的时候会查询ASCII表
		 * 如果写的第一个字节是负数,那第一个字节会和第二个字节,两个字节组成一个中文显示,查询系统默认码表(GBK)
		 */

		// 使用字节数组写入文件
		fos.write(new byte[] { 97, 98, 99 });
		// 使用字符转化成字节输入
		fos.write("Hello\r\n".getBytes());
		// 释放资源
		fos.close();
	}

	public static void main(String[] args) throws Exception {

		useFileOutputStream();
	}

}
