package pers.quan.productorandconsumer;
/**
 *
 * @Discription 
 * @author John丶Woo
 * @date 2019年9月16日 下午12:35:49
 *
 */
public class Consumer extends Thread{

private ProductPool pool;
	
	public Consumer(ProductPool pool) {
		this.pool = pool;
	}
	
	@Override
	public void run() {
		while(true) {
			Product product = this.pool.pop();
			System.out.println("消费者消费了一件产品：" + product.getName());
		}
	}
}
