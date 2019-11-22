package pers.quan;

import java.io.FileReader;

/**
 *
 * @Discription 
 * @author John丶Woo
 * @date 2019年10月3日 上午9:13:45
 *
 */
public class ReaderDemo {

	public static void useReaderStream() throws Exception {
		FileReader fr = new FileReader("a.txt");
		int len = -1;
		while ((len = fr.read()) != -1) {
			System.out.println((char) len);
		}
		fr.close();
	}

	public static void main(String[] args) throws Exception {
		useReaderStream();
	}
}
