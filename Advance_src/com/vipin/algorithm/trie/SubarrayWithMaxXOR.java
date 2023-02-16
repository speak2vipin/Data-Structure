package com.vipin.algorithm.trie;

import java.util.ArrayList;
import java.util.List;

public class SubarrayWithMaxXOR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {84460, 81645, 81237, 83710, 59300, 68378, 63873, 84399, 74950, 68243, 64014, 66366, 75630, 86847, 93976, 84721, 66737, 65315, 56230, 
				75977, 72037, 61715, 93578, 74994, 66236, 87627, 80818, 71091, 69689, 77554, 65977, 60152, 65967, 63404, 73081, 77068, 55623, 93608, 70547, 
				70434, 82616, 81958, 75524, 84200, 61621, 66195, 71957, 71779, 76723, 67932, 66091, 90674, 58193, 62942, 66636, 63327, 52040, 60853, 72426, 
				59310, 79578, 63078, 81147, 64999, 71698, 83799, 63460, 62713, 76340, 56627, 62361, 72268, 81707, 72452, 64511, 80049, 65856, 59399, 72925, 
				64866, 65478, 84797, 71335, 69746, 59427, 75870, 60678, 69804, 58351, 82719, 64729, 66409, 61912, 75483, 67466, 69593, 68851, 72285, 82845,
				64180, 77730, 68872, 56819, 73883, 56704, 78061, 52534, 80044, 91068, 86702, 69241, 78169, 78913, 60936, 69913, 92413, 64609, 80051, 84839, 
				74133, 68489, 86864, 79530, 96165, 62819, 81169, 52764, 58853, 85080, 78303, 66936, 69765, 60988, 78010, 87457, 55091, 58072, 63534, 64677, 
				81150, 83210, 63696, 64833, 78136, 81155, 78596, 84916, 73277, 90295, 62878, 59558, 72123, 87031, 83341, 90468, 79620, 53075, 83754, 73138, 
				66560, 72683, 73328, 70144, 62257, 78300, 73658, 81879, 62159, 66460, 71726, 65367, 81250, 86184, 86754, 73234, 61511, 76516, 62323, 60202, 
				63312, 80728, 81727, 92907, 66573, 65162, 83612, 65253, 62573, 62211, 69690, 83752, 89920, 70752, 70784, 77111, 75008, 84532, 67111, 85060, 
				59152, 75471, 71906, 78630, 74060, 87115, 72950, 81774, 64799, 67260, 61380, 89765, 95482, 71669, 91008, 60693, 87544, 64169, 61716, 63963, 
				66389, 64677, 84617, 54106, 56432, 88298, 73008, 77347, 75057, 95006, 85273, 83010, 82661, 69025, 84753, 89795, 55557, 75811, 65411, 67121, 
				64263, 89406, 73409, 75866, 89473, 73530, 91816, 82429, 79854, 76411, 69439, 75211, 61654, 78140, 57009, 83572, 66124, 71473, 65175, 87201, 
				87775, 72992, 70657, 63570, 65465, 74263, 68520, 57991, 73976, 65032, 69837, 85818, 83696, 75587, 61658, 58406, 57771, 77445, 61652, 79827, 
				73354, 82736, 68105, 61410, 66486, 68218, 65059, 79785, 79054, 85996, 66641, 71822, 70529, 70251, 70222, 64728, 71983, 63238, 81173, 62751, 
				84545, 60757, 77806, 77665, 63346, 70228, 65787, 68315, 88424, 72496, 59166, 77768, 57917, 77479, 85987, 63145, 76261, 85987, 74529, 59987, 
				66999, 69194, 74871, 65423, 57940, 63191, 79305, 90497, 80049, 74533, 63523, 74646, 65021, 79420, 62035, 84305, 59559, 75166, 56598, 58629, 
				70399, 62953, 58613, 54668, 88182, 62393, 66963, 66771, 76114, 60199, 72865, 79056, 69537, 79651, 68472, 64862, 85199, 66707, 88581, 78158, 
				65027, 76108, 85823, 58311, 78187, 82368, 62194, 77248, 77909, 62161, 81309, 63953, 80729, 74337, 80930, 61049, 72738, 77718, 64096, 57439, 
				73710, 65870, 55351, 81565, 91002, 83365, 60233, 58029, 75911, 76416, 60406, 80666, 68381, 69676, 85635, 80217, 64088, 89704, 68022, 84575, 
				63727, 89757, 79439, 75460, 56472, 81824, 64356, 58730, 81547, 71110, 91319, 82940, 86739, 85424, 62253, 68299, 87993, 72329, 78548, 89376, 
				77553, 67315, 86585, 54511, 54461, 64371, 67466, 78942, 93062, 58681, 58172, 92630, 72374, 75617, 68261, 56424, 82218, 58534, 87384, 81635, 
				80756, 63177, 70410, 77368, 61851, 83708, 83914, 65535, 61596, 58441, 87692, 87965, 71291, 55923, 80957, 61051, 81747, 62545, 87237, 63824, 
				86372, 83343, 75206, 58165, 61469, 75887, 65117, 51691, 76242, 89386, 58309, 87487, 79310, 75515, 80628, 81381, 61794, 59320, 76280, 71660, 
				78999, 62365, 73615, 56656, 88850, 81711, 86811, 82411, 67416, 59771, 75939, 84880, 76643, 63810, 85066, 74232, 61160, 64936, 76265, 87672, 
				65153, 70103, 92911, 68615, 75912, 82403};
		SubarrayWithMaxXOR s = new SubarrayWithMaxXOR();
		int ans[] = s.solve(A);
		System.out.println(ans[0] + " " + ans[1]);

	}

	 int[] solve(int A[]) {
			int maxXor = Integer.MIN_VALUE;
			int N = A.length;
			int ans[] = new int[2];
			// TAKE CARE - IF SINGLE ELEMENT IS BIGGEST THAN XOR OF OTHER ELEMENTS	
			for (int i = 0; i < N; i++) {
				if(A[i]>maxXor) {
					maxXor = A[i];
					ans[0] = i+1;
					ans[1] = i+1;
				}
			}
			
			int[] pxor = new int[N];
			
			for (int i = 0; i < N; i++) {
				if(i==0) {
					pxor[i] = A[0];
				} else {
					pxor[i] = pxor[i - 1] ^ A[i];
				}	
	            // TAKE CARE IF SUBARRAY FROM 0 INDEX IS THE HAVING MAXIMUM XOR
				if(pxor[i]>maxXor) {
					maxXor = pxor[i];
					ans[0] = 1;
					ans[1] = i+1;
				}
			}
			
			TrieXor root = new TrieXor();
			for (int i = 0; i < N; i++) {
	            // CREATE TRIE
				createTrie(root, pxor[i], i);
			}
			
			int diff = 0;
			for (int i = 0; i < N; i++) {
	            // EVALUATE XOR, 
	                // STORE VALUE TO COMPARE
	                // STORE INDEX TO CALCULATE SIZE OF SUBARRAY
	                // STORE ISEND TO TRACK WHETHER SAME NUMBER EXIST FOR OTHER INDEXES
	                // NO NEED TO STORE OTHER NUMBER AS WE WANT MINIMUM LENGTH SUBARRAY ONLY
				Response response = evaluate(root, pxor[i]);
	            // USE GREATER CONDITION ONLY TO GET RID OF 1- 2 and 2-1 scenario
				
				if(response.xorValue > maxXor) {
					System.out.println(i + " " + maxXor + " " + response.xorValue + " " + response.indexL);
					maxXor = response.xorValue;
					int tempDiff = response.indexL.get(0)+1-(i+2)+1;
					ans[0] = i + 2 ;
					ans[1] = response.indexL.get(0)+1;
					diff = tempDiff;
				} else if (response.xorValue == maxXor) {
					System.out.println(i + " " + maxXor + " " + response.xorValue + " " + response.indexL);
					maxXor = response.xorValue;
					int tempDiff = response.indexL.get(0)+1-(i+2)+1;
					
					if(tempDiff > 0 && diff>tempDiff) {
						ans[0] = i + 2 ;
						ans[1] = response.indexL.get(0)+1;
						diff = tempDiff;
					}
				}
			}
			return ans;
		
		}

		void createTrie(TrieXor trie, int data, int index) {
			
			TrieXor temp = trie;
			for (int i = 29; i > -1; i--) {
				int id = (data >> i) & 1;
				if (temp.children[id] == null) {
					temp.children[id] = new TrieXor();
				}
				temp = temp.children[id];
			}
			if(!temp.isEnd) {
				temp.isEnd = true;
			}
			temp.indexL.add(index);
		}

		Response evaluate(TrieXor trie, int data) {
	        
			TrieXor temp = trie;
			int val = 0;
			for (int i = 29; i > -1; i--) {
				int id = (data >> i) & 1;
				if (id == 0) {
					if (temp.children[1] != null) {
						val += 1 << i;
						temp = temp.children[1];
					} else {
						temp = temp.children[0];
					}
				} else {
					if (temp.children[0] != null) {
						val += 1 << i;
						temp = temp.children[0];
					} else {
						temp = temp.children[1];
					}
				}
			}
			Response response = new Response(val, temp.indexL);

			return response;
		
		}
	}

	class TrieXor {
		boolean isEnd;
		List<Integer> indexL;
		TrieXor children[];

		public TrieXor() {
			isEnd = false;
			indexL = new ArrayList<Integer>();
			children = new TrieXor[2];
		}
	}

	class Response {
		int xorValue;
		List<Integer> indexL;

		public Response(int xorValue, List<Integer> indexL) {
			this.xorValue = xorValue;
			this.indexL = indexL;
		}
	}