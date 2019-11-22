package design.pattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
*
* @Discription meal
* @author John丶Woo
* @date 2019年10月1日 下午2:28:27
*
*/
public class Meal {

	private List<Food> Foods = new ArrayList<Food>();

	public void addFood(Food Food) {
		Foods.add(Food);
	}

	public float getCost() {
		float cost = 0.0f;
		for (Food Food : Foods) {
			cost += Food.price();
		}
		return cost;
	}

	public void showFoods() {
		for (Food Food : Foods) {
			System.out.print("Food : " + Food.name());
			System.out.print(", Packing : " + Food.packing().pack());
			System.out.println(", Price : " + Food.price());
		}
	}
}