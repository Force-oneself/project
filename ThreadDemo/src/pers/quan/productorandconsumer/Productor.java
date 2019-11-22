package pers.quan.productorandconsumer;
/**
 *
 * @Discription 生产者
 * @author John丶Woo
 * @date 2019年9月16日 下午12:29:45
 *
 */
public class Productor extends Thread{

	private ProductPool pool;
	
	public Productor(ProductPool pool) {
		this.pool = pool;
	}
	
	@Override
	public void run() {
		while(true) {
			String name = (int) (Math.random()*100) + "号产品";
			System.out.println("生产了一件产品：" + name);
			Product product = new Product(name);
			this.pool.push(product);
		}
	}
}
