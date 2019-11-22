package design.pattern.builder;

/**
 *
 * @Discription ChickenBurger
 * @author John丶Woo
 * @date 2019年10月1日 下午2:24:41
 *
 */
public class ChickenBurger extends Burger {

	@Override
	public String name() {
		return "Chicken Burger";
	}

	@Override
	public float price() {
		return 50.5f;
	}

}
