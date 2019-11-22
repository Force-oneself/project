package design.pattern.builder;

/**
 *
 * @Discription Coke
 * @author John丶Woo
 * @date 2019年10月1日 下午2:26:01
 *
 */
public class Coke extends ColdDrink {

	@Override
	public float price() {
		return 30.0f;
	}

	@Override
	public String name() {
		return "Coke";
	}
}
