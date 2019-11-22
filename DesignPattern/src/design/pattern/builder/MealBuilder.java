package design.pattern.builder;

/**
 *
 * @Discription 
 * @author John丶Woo
 * @date 2019年10月1日 下午2:31:27
 *
 */
public class MealBuilder {

	public Meal prepareVegMeal() {
		Meal meal = new Meal();
		meal.addFood(new VegBurger());
		meal.addFood(new Coke());
		return meal;
	}

	public Meal prepareNonVegMeal() {
		Meal meal = new Meal();
		meal.addFood(new ChickenBurger());
		meal.addFood(new Pepsi());
		return meal;
	}
}
