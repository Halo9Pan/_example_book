/**
 * Created on Sep 26, 2011
 */
package info.halo9pan.examples.prospring3.ch5.profile.kindergarten;

import info.halo9pan.examples.prospring3.ch5.profile.Food;
import info.halo9pan.examples.prospring3.ch5.profile.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Clarence
 *
 */
public class FoodProviderServiceImpl implements FoodProviderService {

	public List<Food> provideLunchSet() {
		List<Food> lunchSet = new ArrayList<Food>();
		lunchSet.add(new Food("Milk"));
		lunchSet.add(new Food("Biscuits"));

		return lunchSet;
	}

}
