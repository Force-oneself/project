package pers.quan;

import java.io.FileInputStream;

/**
 *
 * @Discription InputStreamDemo
 * @author John丶Woo
 * @date 2019年10月3日 上午8:24:02
 *
 */
public class InputStreamDemo {

	/**
	 * 
	 * @Description 使用文件字节输出流
	 * @throws Exception
	 */
	public static void useFileInputStream() throws Exception {

		FileInputStream fis = new FileInputStream("a.txt");
		// 使用字节循环遍历读取文件
		int len = -1;
		while ((len = fis.read()) != -1) {
			System.out.println(len);
		}
		// 使用字节数组读取文件
//		byte[] bytes = new byte[2];
//		int readBytes = fis.read(bytes);
//		System.out.println(Arrays.toString(bytes));
//		System.out.println(new String(bytes));
		// 循环读入字节数组大小的文件
//		int len = -1;
//		while ((len = fis.read(bytes)) != -1) {
//			System.out.println(len);
//		}
		fis.close();

	}

	public static void main(String[] args) throws Exception {

		useFileInputStream();
	}

}
