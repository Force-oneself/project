package pers.quan.test;

import java.util.List;

import pers.quan.model.Demo;

/**
 * 
 * @Description 测试类
 * @author 何永泉
 * @date 2019年8月12日 下午7:58:37
 *
 */
@SuppressWarnings("unused")
public class DemoTest {

	public static void main(String[] args) {
		Demo demo = new Demo(1, "li", "123456");
		Design design = new Design();
		System.out.println(design.getUpdateSql(demo, "iddd"));
	}
}
