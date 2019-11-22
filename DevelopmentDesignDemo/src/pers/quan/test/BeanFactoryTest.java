package pers.quan.test;

import java.util.List;

import pers.quan.model.Demo;
import pers.quan.service.DemoService;
import pers.quan.service.impl.DemoServiceImpl;
import pers.quan.uitls.BeanFactoryUtils;

/**
 *
 * @Discription BeanFactory test
 * @author John丶Woo
 * @date 2019年9月7日 下午10:53:02
 *
 */
public class BeanFactoryTest {

	public static void main(String[] args) {
		DemoService demoService = (DemoService) BeanFactoryUtils.getBean("demoService");
		
		List<Demo> list = demoService.getAll();
		for (Demo demo : list) {
			System.out.println(demo);
		}
	}
}
