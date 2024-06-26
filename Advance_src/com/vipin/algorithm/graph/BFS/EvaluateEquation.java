package com.vipin.algorithm.graph.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class EvaluateEquation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EvaluateEquation e = new EvaluateEquation();
		List<String> l1 = new ArrayList<>();
		l1.add("a");
		l1.add("b");
		List<String> l2 = new ArrayList<>();
		l2.add("b");
		l2.add("c");
		List<List<String>> eq = new ArrayList<>();
		eq.add(l1);
		eq.add(l2);

		double[] values = { 2.0, 3.0 };

		List<String> l3 = new ArrayList<>();
		l3.add("a");
		l3.add("c");
		List<String> l4 = new ArrayList<>();
		l4.add("b");
		l4.add("a");
		List<String> l5 = new ArrayList<>();
		l5.add("a");
		l5.add("e");
		List<String> l6 = new ArrayList<>();
		l6.add("a");
		l6.add("a");
		List<List<String>> qe = new ArrayList<>();
		qe.add(l3);
		qe.add(l4);
		qe.add(l5);
		qe.add(l6);
		// String queries[][] = {{"a","c"},{"b","a"},{"a","e"},{"a","a"},{"x","x"}};
		for (double val : e.calcEquation(eq, values, qe)) {
			System.out.println(val);
		}

	}

	Map<String, Map<String, Double>> map = new HashMap<>();
	double res[] = null;

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		int index = 0;
		int size = queries.size();
		res = new double[size];
		for (List<String> eq : equations) {
			map.putIfAbsent(eq.get(0), new HashMap<>());
			map.get(eq.get(0)).put(eq.get(1), values[index]);

			map.putIfAbsent(eq.get(1), new HashMap<>());
			map.get(eq.get(1)).put(eq.get(0), 1.0 / values[index]);
			index++;
		}
		for (int i = 0; i < size; i++) {
			List<String> query = queries.get(i);
			String source = query.get(0);
			String dest = query.get(1);
			HashSet<String> visit = new HashSet<>();

			dfs(visit, source, dest, 1.0, i);
		}
		return res;

	}

	void dfs(HashSet<String> visit, String source, String target, double val, int index) {
		if(map.get(target)==null || map.get(source)==null) {
			res[index] = -1.0;
			return;
		}
		if (target.equals(source)) {
			res[index] = val;
			return;
		}
		if(visit.contains(source)) {
			return;
		}
		
		visit.add(source);
		
		Map<String, Double> temp = map.get(source);
		if (temp != null) {
			for (String key : temp.keySet()) {
				String k = key;
				Double v = temp.get(k);
				dfs(visit, key, target, val * v, index);
			}
		} 
	}

}
