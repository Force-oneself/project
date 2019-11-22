package pers.quan.singleton;
/**
 *
 * @Discription 单例模式
 * @author John丶Woo
 * @date 2019年9月16日 下午12:44:25
 *
 */
public class SingletonTest {

	public static void main(String[] args) {
		
		Runnable runnable = () -> {
			Boss.getBoss();
		};
		
		for (int i = 0; i < 100; i++) {
			new Thread(runnable).start();
		}
	}
}

class Boss {
	
	private static Boss instance = null;
	
	private Boss() {
		System.out.println("一个Boss对象被实例化了");
	}
	
//	public synchronized static Boss getBoss() {
//		if (instance == null) {
//			instance = new Boss();
//		}
//		
//		return instance;
//	}
	
	public static Boss getBoss() {
		synchronized ("") {
			if (instance == null) {
				instance = new Boss();
			}
		}
		return instance;
	}
}