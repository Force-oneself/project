package pers.quan.resource;

/**
 *
 * @Discription 临界资源操作的演示
 * @author John丶Woo
 * @date 2019年9月17日 下午1:21:55
 *
 */
public class Demo {

	public static void main(String[] args) {

		// 实例化四个线程，模拟卖票
		Runnable r = () -> {
			while (Ticket.count > 0) {
		
				synchronized (Ticket.class) {
					if (Ticket.count <= 0) {
						return;
					}
					System.out.println(Thread.currentThread().getName() + "卖出一张票，剩余：" + --Ticket.count + "张票");
				}
			}

		};

		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		Thread t3 = new Thread(r);
		Thread t4 = new Thread(r);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
