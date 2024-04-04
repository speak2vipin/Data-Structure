package com.vipin.algorithm.array;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPathCrossing("NESWW"));

	}
	public static boolean isPathCrossing(String path) {
        int n = path.length();
        Set<Dim> dimSet = new HashSet<>();
        int point[] = {0,0};
        for(int i=0; i<n; i++) {
            if(dimSet.contains(new Dim(point[0], point[1]))) {
                return true;
            }
            dimSet.add(new Dim(point[0], point[1]));
            char c = path.charAt(i);
            if(c=='N') {
                point[1]++;
            } else if(c=='E') {
                point[0]++;
            } else if(c=='S') {
                point[1]--;
            } else {
                point[0]--;
            }
            
        }
        return false;
    }

}

class Dim {
    int x;
    int y;
    public Dim(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int hashCode() {
    	return x+y;
    }
    @Override
	public boolean equals(Object o) {
    	Dim dim = (Dim)o;
    	return x==dim.x && y==dim.y;
    }
}
