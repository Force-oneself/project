package pers.quan;

import java.io.FileWriter;

/**
 *
 * @Discription 
 * @author John丶Woo
 * @date 2019年10月3日 上午9:31:36
 *
 */
public class WriterDemo {

	public static void useWriter() throws Exception {
		FileWriter fw = new FileWriter("a.txt");

		fw.write(97);

		fw.close();
	}

	public static void main(String[] args) throws Exception {
		useWriter();
	}
}
