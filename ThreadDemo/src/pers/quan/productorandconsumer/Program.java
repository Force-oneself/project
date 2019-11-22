package pers.quan.productorandconsumer;
/**
 *
 * @Discription 
 * @author John丶Woo
 * @date 2019年9月16日 下午12:15:57
 *
 */
public class Program {

	public static void main(String[] args) {
		// 实例化一个产品池
		ProductPool pool = new ProductPool(15);
		
		// 实例化一个生产者
		new Productor(pool).start();
		
		// 实例化一个消费者
		new Consumer(pool).start();
	}
}
