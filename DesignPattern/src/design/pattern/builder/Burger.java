package design.pattern.builder;

/**
 *
 * @Discription burger
 * @author John丶Woo
 * @date 2019年10月1日 下午2:14:56
 *
 */
public abstract class Burger implements Food {

	@Override
	public abstract float price();

	@Override
	public Packing packing() {
		return new Wrapper();
	}

}
