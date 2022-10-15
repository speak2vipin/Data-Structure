package com.vipin.algorithms.bitmanipulations;

public class SumOfSubarraysOrResult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []A = {1, 2, 3, 4, 5};
		//System.out.println(solve(A));
		int B[] = {7, 8, 9, 10};
		//System.out.println(solve(B));
		int [] C= {28189, 77911, 598231, 298338, 137953, 77258, 271663, 218021, 49069, 11276, 55056, 465305, 799261, 213889, 593476, 50233, 243457, 119757, 323318, 26821, 255113, 6976, 392341, 329077, 83917, 372513, 30169, 111111, 16966, 235231, 50276, 154883, 148501, 101309, 32830, 55233, 58097, 179983, 19903, 12769, 53953, 71622, 36253, 1, 123445, 207751, 321105, 11029, 297088, 7123, 440373, 299547, 164281, 13847, 290440, 20203, 20953, 214, 440146, 9569, 451606, 547723, 130637, 237171, 380275, 79689, 383088, 79036, 328154, 272601, 444745, 105656, 429826, 91171, 111457, 160229, 60351, 401017, 785201, 333592, 25186, 58981, 57525, 626165, 486585, 105, 237391, 31350, 145153, 561601, 133836, 79255, 94612, 227636, 56101, 427805, 129901, 42238, 6881, 35985 };
	System.out.println(solve(C));
	}

	public static int solve(int[] A) {
		long sum = 0;
		int N = A.length;
		int modulus = 1000000007;
		for (int i = 31; i > -1; i--) {
			int tempBinary[] = new int[N];
			for (int j = 0; j < N; j++) {
				tempBinary[j] = (A[j] >> i) & 1;
			}
			long TotalArray = (long)(N*1l * (N + 1)) / 2;
			long binaryArrayWithOnes = TotalArray - binaryArrayWithZeroes(tempBinary);
			sum = (sum%modulus + ((1 << i))%modulus * binaryArrayWithOnes%modulus) % modulus;
		}
		return (int) sum;
	}

	static long binaryArrayWithZeroes(int[] X) {
		long count = 0;
		long total = 0;
		for (int i = 0; i < X.length; i++) {
			if (X[i] == 0) {
				count++;
			} else {
				total += (count * (count + 1)) / 2;
				count = 0;
			}
		}
		return total + (count * (count+1)/2);
	}

}
