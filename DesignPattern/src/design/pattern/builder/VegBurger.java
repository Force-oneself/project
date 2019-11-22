package design.pattern.builder;

/**
 *
 * @Discription vegetable burger
 * @author John丶Woo
 * @date 2019年10月1日 下午2:23:18
 *
 */
public class VegBurger extends Burger {

	@Override
	public String name() {
		return "Veg Burger";
	}

	@Override
	public float price() {
		return 25.0f;
	}

}
