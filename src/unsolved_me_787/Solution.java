package unsolved_me_787;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		k++;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(src, 0);
		HashMap<Integer, Integer> smap = (HashMap<Integer, Integer>) map.clone();
		HashMap<Integer, Integer> tempmap1 = (HashMap<Integer, Integer>) map.clone();
		HashMap<Integer, Integer> tempmap2 = new HashMap<>();
		while (k > 0) {
			for (int x : tempmap1.keySet()) {
				for (int i = 0; i < flights.length; i++) {
					if (flights[i][0] == x) {
						if (map.containsKey(flights[i][1])) {
							if (smap.get(flights[i][1]) > tempmap1.get(x) + flights[i][2]){
								smap.put(flights[i][1], map.get(x) + flights[i][2]);
								tempmap2.put(flights[i][1], map.get(x) + flights[i][2]);
							}
							else {
								tempmap2.put(flights[i][1], map.get(x) + flights[i][2]);
							}
						} else{
								smap.put(flights[i][1], map.get(x) + flights[i][2]);
								tempmap2.put(flights[i][1], map.get(x) + flights[i][2]);
						}
					}
				}

			}
			//map.putAll(tempmap2);
			map=(HashMap<Integer, Integer>) smap.clone();
			tempmap1 = (HashMap<Integer, Integer>) tempmap2.clone();
			tempmap2.clear();
			k--;
			System.out.println("tempmap    "+tempmap1.toString());
			System.out.println("\t");
			System.out.println("map    "+map.toString());
		}
		if (map.containsKey(dst))
			return smap.get(dst);
		else
			return -1;
	}

	public static void main(String[] args) {
		int flights[][] = 
				{{5,4,29},{11,9,41},{3,1,51},{5,3,94},{6,2,14},{4,6,27},{7,11,74},{3,11,79},{1,7,32},{3,2,99},{0,3,54},{4,8,76},{9,11,1},{5,2,2},{12,6,92},{3,4,83},{8,6,67},{3,6,23},{1,4,40},{3,10,53},{0,10,19},{6,4,47},{7,10,43},{4,10,45},{1,3,91},{9,12,86},{10,3,28},{10,11,62},{0,1,75},{12,9,14},{5,0,18},{0,11,81},{3,5,94},{11,5,53},{5,7,40},{9,1,18},{6,3,62},{5,8,67},{7,12,84},{1,10,64},{6,5,44},{12,2,30},{6,1,35},{5,11,90},{11,10,53},{11,6,87},{8,3,44},{10,2,2},{6,11,67},{9,2,97},{6,12,4},{0,4,15},{2,4,18},{8,5,30},{7,4,46},{2,1,96},{7,3,1},{6,9,74},{12,1,65},{2,6,15},{1,11,74},{10,4,47},{10,7,80},{3,8,11},{8,9,36},{2,11,1},{4,11,78},{1,8,63},{0,9,62},{5,12,60},{10,9,100},{4,2,73},{5,9,32},{0,8,43},{6,8,72},{11,1,23}}
						;
		System.out.println(new Solution().findCheapestPrice(2, flights, 5, 11, 3));
		for (int[] is : flights) {
			if(is[2]<=3) System.out.println(Arrays.toString(is));
		}
	}
}
