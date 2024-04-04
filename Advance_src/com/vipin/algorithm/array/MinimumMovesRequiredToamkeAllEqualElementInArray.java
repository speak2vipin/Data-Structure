package com.vipin.algorithm.array;

import java.util.Arrays;

public class MinimumMovesRequiredToamkeAllEqualElementInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 3, 5, 2 };
		int[] cost = { 2, 3, 1, 14 };
		MinimumMovesRequiredToamkeAllEqualElementInArray m = new MinimumMovesRequiredToamkeAllEqualElementInArray();
		System.out.println(m.minCost(nums, cost));

	}

	public long minCost(int[] nums, int[] cost) {
		int n = nums.length;
		int numsAndCost[][] = new int[n][2];
		for (int i = 0; i < n; i++) {
			numsAndCost[i][0] = nums[i];
			numsAndCost[i][1] = cost[i];
		}
		Arrays.sort(numsAndCost, (a, b) -> a[0] - b[0]);

		long total = 0;
		long prefixCost[] = new long[n];
		prefixCost[0] = numsAndCost[0][1];
		for (int i = 1; i < n; i++) {
			total += 1l * numsAndCost[i][1] * (numsAndCost[i][0] - numsAndCost[0][0]);
			prefixCost[i] = prefixCost[i - 1] + numsAndCost[i][1];
		}
		long answer = total;
		for (int i = 1; i < n; i++) {
			int gap = numsAndCost[i][0] - numsAndCost[i - 1][0];
			total = total + 1l * gap * prefixCost[i - 1];
			total = total - 1l * gap * (prefixCost[n - 1] - prefixCost[i - 1]);
			answer = Math.min(answer, total);
		}
		return answer;
	}

}

	public static int solve(ArrayList<Integer> A) {

		int n = Collections.max(A);

		int primeInFactorialCount[] = populatePrimeInFactorialCount(n);

		int B[] = new int[A.size()];

		for (int i = 0; i < A.size(); i++) {

			B[i] = primeInFactorialCount[A.get(i)];

		}

		Map<Integer, Integer> frequencyMap = new HashMap<>();

		for (int j = 0; j < A.size(); j++) {

			if (B[j] == 0) {

				continue;

			}

			if (frequencyMap.containsKey(B[j])) {

				frequencyMap.put(B[j], 1 + frequencyMap.get(B[j]));

			} else {

				frequencyMap.put(B[j], 1);

			}

		}

		int m = 100010001000 + 7;

		int ans = 0;

		int maxPower = Collections.max(frequencyMap.values());

		int[] powArr = new int[maxPower + 1];

		powArr[0] = 1;

		for (int i = 1; i <= maxPower; i++) {

			powArr[i] = powArr[i - 1] << 1;

		}

		for (Integer key : frequencyMap.keySet()) {

			ans = (ans + powArr[frequencyMap.get(key)] - 1) % m;

		}

		return ans;

	}

	private static int[] populatePrimeInFactorialCount(int n) {

		int sieve[] = getSieve(n);

		int factorialPrimeCount[] = new int[n + 1];

		for (int i = 2; i <= n; i++) {

			if (sieve[i] != 0) {

				factorialPrimeCount[i] = 1 + factorialPrimeCount[i - 1];

			} else {

				factorialPrimeCount[i] = factorialPrimeCount[i - 1];

			}

		}

		return factorialPrimeCount;

	}
}
