package com.vipin.algorithm.array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FoodRatingsSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String foods[] = { "skovfln","ogmswgbf","rkzlsspoqn","uowlsr",
				"oyqffozoe","tpipqa","ykox","fgjci",
				"tpbagnb","kwknwmcnx","pbkkw","ceb",
				"kxqenimgy","rqdbd","llqzdl","axfnxf",
				"qmhdctmig" };
		String cuisines[] = { "xxuij","xxuij","xxuij","xxuij",
				"c","c","xxuij","c",
				"c","c","c","xxuij",
				"c","xxuij","c","xxuij","c" };
		int ratings[] = {208,558,435,605,
				811,856,1000,749,
				605,349,236,464,
				927,701,715,175,993 };
		FoodRatingsSystem f = new FoodRatingsSystem();
		f.initialise(foods, cuisines, ratings);

		System.out.println(f.highestRated("c"));
		System.out.println(f.highestRated("c"));
		f.changeRating("kbaxapl", 8);
		// System.out.println(f.highestRated("japanese"));
		f.changeRating("lxoozsbh", 5);
		System.out.println(f.highestRated("dmnuqeatj"));

	}

	Map<String, PriorityQueue<Object[]>> cuisinesRatingsMap = null;
	Map<String, String> foodsCuisinesMap = null;
	Map<String, Integer> foodsRatingsMap = null;

	public void initialise(String[] foods, String[] cuisines, int[] ratings) {
		cuisinesRatingsMap = new HashMap<>();
		foodsCuisinesMap = new HashMap<>();
		foodsRatingsMap = new HashMap<>();

		int n = foods.length;
		for (int i = 0; i < n; i++) {
			foodsCuisinesMap.put(foods[i], cuisines[i]);
			foodsRatingsMap.put(foods[i], ratings[i]);
			cuisinesRatingsMap
					.computeIfAbsent(cuisines[i],
							val -> new PriorityQueue<Object[]>((x, y) -> (Integer) x[0] == (Integer) y[0]
									? (((String) x[1]).compareTo((String) y[1]))
									: (Integer) y[0] - (Integer) x[0]))
					.offer(new Object[] { ratings[i], foods[i] });
		}
		
	
	
		for (int i = 0; i < n; i++) {
			foodsCuisinesMap.put(foods[i], cuisines[i]);
			foodsRatingsMap.put(foods[i], ratings[i]);
			cuisinesRatingsMap
					.computeIfAbsent(cuisines[i],
							val -> new PriorityQueue<Object[]>((x, y) -> ((Integer) x[0]).compareTo((Integer) y[0]) == 0
									? (((String) x[1]).compareTo((String) y[1]))
									: ((Integer) y[0]).compareTo((Integer) x[0])))

					.offer(new Object[] { ratings[i], foods[i] });
		}
	}

	public void changeRating(String food, int newRating) {
		String cuisine = foodsCuisinesMap.get(food);
		cuisinesRatingsMap.get(cuisine).offer(new Object[] { newRating, food });
		foodsRatingsMap.put(food, newRating);
	}

	public String highestRated(String cuisine) {
		Object[] top = cuisinesRatingsMap.get(cuisine).peek();
		//foodsRatingsMap.get(top[1]) != (Integer)top[0]
		while (foodsRatingsMap.get(top[1]).compareTo((Integer)top[0])!=0) {
			cuisinesRatingsMap.get(cuisine).poll();
			top = cuisinesRatingsMap.get(cuisine).peek();
		}
		return (String) top[1];
	}

}



