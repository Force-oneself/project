package design.pattern.builder;

/**
 *
 * @Discription pepsi
 * @author John丶Woo
 * @date 2019年10月1日 下午2:26:58
 *
 */
public class Pepsi extends ColdDrink {

	@Override
	public float price() {
		return 35.0f;
	}

	@Override
	public String name() {
		return "Pepsi";
	}
}