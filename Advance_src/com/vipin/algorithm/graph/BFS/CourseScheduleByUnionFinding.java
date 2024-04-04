package com.vipin.algorithm.graph.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CourseScheduleByUnionFinding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCourse = 3;
		int pre[][] = {{0,1 }, {0,2},{1,2}};
		
		
		CourseScheduleByUnionFinding c = new CourseScheduleByUnionFinding();
		System.out.println(c.canFinish1(numCourse, pre));
	}

	int parent[] = null;
	int rank[] = null;

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		parent = new int[numCourses];
		rank = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			parent[i] = i;
		}

		for (int x[] : prerequisites) {
			int u = x[0];
			int v = x[1];
			if (!getUnion(u, v)) {
				return false;
			}
		}
		return true;
	}

	boolean getUnion(int u, int v) {
		int uParent = getParent(u);
		int vParent = getParent(v);

		if (uParent == vParent) {
			return false;
		}
		if (rank[uParent] > rank[vParent]) {
			parent[vParent] = uParent;
			rank[uParent]++;
		}
		if (rank[uParent] < rank[vParent]) {
			parent[uParent] = vParent;
			rank[vParent]++;
		} else {
			parent[vParent] = uParent;
			rank[uParent]++;
		}
		return true;
	}

	int getParent(int i) {
		if (parent[i] != i) {
			parent[i] = getParent(parent[i]);
		}
		return parent[i];
	}
	boolean visit[] = null;
	public boolean canFinish1(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for(int[] p : prerequisites) {
            adj.computeIfAbsent(p[0], val->new ArrayList<Integer>()).add(p[1]);
        }
        visit = new boolean[numCourses];
        for(int i=0; i<numCourses; i++) {
            boolean path[] = new boolean[numCourses];
            if(!visit[i] && isCycle(i, adj, path)) {
                return false;
            }
        }
        return true;
    }
    
    boolean isCycle(int node, Map<Integer, ArrayList<Integer>> adj, boolean path[]) {
        visit[node] = true;
        path[node] = true;
        if(adj.get(node)!=null) {
            for(int neighbor : adj.get(node)) {
                if(path[neighbor]) {
                    return true;
                }
                if(!visit[neighbor] && isCycle(neighbor, adj, path)) {
                    return true;
                }
            }
        }
        return false;
    }
}
