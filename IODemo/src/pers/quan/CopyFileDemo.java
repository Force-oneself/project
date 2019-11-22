package pers.quan;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @Discription 
 * @author John丶Woo
 * @date 2019年10月3日 上午8:58:14
 *
 */
public class CopyFileDemo {

	/**
	 * 
	 * @Description 文件复制
	 * @throws Exception
	 */
	public static void copyFile() throws Exception {
		// 输入流对象 读取的数据源
		FileInputStream fis = new FileInputStream("a.txt");
		// 输出流对象 写入目的地
		FileOutputStream fos = new FileOutputStream("file\\a.txt");
		/*
		 * int len = -1; while ((len = fis.read()) != -1) { fos.write(len); }
		 */
		// 使用数组缓冲读取多个字节，写入多个字节
		byte[] bytes = new byte[1024];
		int len = -1;
		while ((len = fis.read(bytes)) != -1) {
			fos.write(bytes, 0, len);
		}
		fos.close();
		fis.close();
	}

	public static void main(String[] args) throws Exception {

		copyFile();
	}
}
