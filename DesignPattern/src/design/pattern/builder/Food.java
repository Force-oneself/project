package design.pattern.builder;

/**
 *
 * @Discription food information
 * @author John丶Woo
 * @date 2019年10月1日 下午2:05:59
 *
 */
public interface Food {

	/**
	 * 
	 * @Description name
	 * @return
	 */
	String name();

	/**
	 * 
	 * @Description price
	 * @return
	 */
	float price();

	/**
	 * 
	 * @Description packing
	 * @return
	 */
	Packing packing();
}
