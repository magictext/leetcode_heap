package me_264;

import java.util.Arrays;
import java.util.TreeSet;

public class Solution4 {
	public int nthUglyNumber(int n) {
		TreeSet<Integer> treeSet = new TreeSet<>();
		TreeSet<Integer> set = new TreeSet<>();
		treeSet.add(1);
		set.add(1);
		TreeSet<Integer> tempSet = (TreeSet<Integer>) treeSet.clone();
		int temp=0,flag=1;
		while (temp<n) {
			// tempSet = (TreeSet<Integer>) treeSet.clone();
			for (Integer integer : treeSet) {
				if(flag==1) {temp=integer*2; flag=0;}
				if(integer * 2>0){
					tempSet.add(integer * 2);
					set.add(integer * 2);
				}
				if(integer * 3>0){
					tempSet.add(integer * 3);
					set.add(integer * 3);
				}
				if(integer * 5>0){
					tempSet.add(integer * 5);
					set.add(integer * 5);
				}
			}
			flag=1;
			Object t[] = set.toArray();
			temp=Arrays.binarySearch(t, temp);
			System.out.println(temp);
			treeSet = (TreeSet<Integer>) tempSet.clone();
			tempSet.clear();
		}
		Object t[] = set.toArray();
		//System.out.println(Arrays.toString(t));
		System.out.println(t.length+"\t"+temp);
		return (int) t[n - 1];
	}

	public static void main(String[] args) {
		System.out.println(new Solution4().nthUglyNumber(1352));
	}
}
