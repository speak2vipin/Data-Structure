package com.vipin.algorithm.greedyalgorithms;

import java.util.Arrays;

public class MAximumBucketRequired {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MAximumBucketRequired m = new MAximumBucketRequired();
		int[] people = { 3, 2, 3, 2, 2 };
		System.out.println(m.numRescueBoats1(people, 6));
	}

	public int numRescueBoats(int[] people, int limit) {
		int temp[] = new int[limit + 1];
		for (int weight : people) {
			temp[weight] = temp[weight] + 1;
		}
		int count = 0;
		int tempWeight = 0;
		int tempLimit = 0;
		int index = limit;
		while (index > 0) {
			tempLimit = limit;
			tempWeight = index;
			if (temp[tempWeight] <= 0) {
				index--;
			} else {
				count++;
				temp[tempWeight]--;
				tempLimit = tempLimit - tempWeight;
				tempWeight = tempLimit;
				while (tempWeight > 0) {
					if (temp[tempWeight] > 0) {
						temp[tempWeight]--;
						break;
					} else {
						tempWeight--;
					}
				}
			}
		}
		return count;
	}

	public int numRescueBoats1(int[] people, int limit) {
		Arrays.sort(people);
		int i = 0, j = people.length - 1;
		int ans = 0;

		while (i <= j) {
			ans++;
			if (people[i] + people[j] <= limit)
				i++;
			j--;
		}

		return ans;
	}

}
