package design.pattern.builder;

/**
 *
 * @Discription cold drink
 * @author John丶Woo
 * @date 2019年10月1日 下午2:20:58
 *
 */
public abstract class ColdDrink implements Food {

	@Override
	public abstract float price();

	@Override
	public Packing packing() {
		return new Bottle();
	}

}
