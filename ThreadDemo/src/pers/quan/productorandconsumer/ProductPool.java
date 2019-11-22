package pers.quan.productorandconsumer;
/**
 *
 * @Discription 产品池
 * @author John丶Woo
 * @date 2019年9月16日 下午12:17:11
 *
 */

import java.util.LinkedList;
import java.util.List;

public class ProductPool {

	// 存储所有产品的集合
	private List<Product> produceList;
	
	// 产品池中产品的最大数量
	private int maxSize = 0;
	
	public ProductPool(int maxSize) {
		// 对产品进行实例化
		this.produceList = new LinkedList<Product>();
		// 限定产品的最大数量
		this.maxSize = maxSize;
	}
	/**
	 * 
	 * @Description 生产者将生产好的商品放入商品池
	 * @param product
	 */
	public synchronized void push(Product product) {
		// 判断是否还需要生产产品
		if (this.produceList.size() == maxSize) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		// 将产品添加到集合中
		this.produceList.add(product);
		// 通过其他人，有产品可以消费了
		this.notify();
	}

	/**
	 * 
	 * @Description 消费者从商品池中取出一件商品消费
	 * @return
	 */
	public synchronized Product pop() {
		// 判断是否还有商品再去消费
		if (this.produceList.size() == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		// 从商品池中取出意见商品
		Product product = this.produceList.remove(0);
		// 通知其他人，我取出了一件商品
		this.notify();
		
		return product;
	}
}
