package design.pattern.builder;

/**
 *
 * @Discription BuilderPatternDemo
 * @author John丶Woo
 * @date 2019年10月1日 下午2:32:51
 *
 */
public class BuilderPatternDemo {

	public static void main(String[] args) {

		MealBuilder mealBuilder = new MealBuilder();

		Meal vegMeal = mealBuilder.prepareVegMeal();
		System.out.println("Veg Meal");
		vegMeal.showFoods();
		System.out.println("Total Cost: " + vegMeal.getCost());

		Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
		System.out.println("\n\nNon-Veg Meal");
		nonVegMeal.showFoods();
		System.out.println("Total Cost: " + nonVegMeal.getCost());
	}
}
