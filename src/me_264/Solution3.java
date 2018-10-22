package me_264;

import java.util.TreeSet;

public class Solution3 {
	public int nthUglyNumber(int n) {
		int temp = 0;
		TreeSet<Integer> treeSet = new TreeSet<>();
		TreeSet<Integer> tempset1 = new TreeSet<>();
		TreeSet<Integer> tempset2 = new TreeSet<>();
		TreeSet<Integer> tempset12 = new TreeSet<>();
		TreeSet<Integer> tempset22 = new TreeSet<>();
		tempset1.add(1);
		tempset2.add(1);
		treeSet.add(1);
		int flag=1,max=1;
		while (true) {
			flag=0;
			for (Integer integer : tempset1) {
				if(integer*2<max){
					tempset12.add(integer*2);
					tempset1.remove(integer);
					flag=1;
				}else {
					break;
				}
			}
			treeSet.addAll(tempset12);
			tempset1.addAll(tempset12);
			tempset12.clear();
			for (Integer integer : tempset2) {
				if(integer*2<max){
					tempset22.add(integer*2);
					tempset2.remove(integer);
					flag=1;
				}else {
					break;
				}
			}
			treeSet.addAll(tempset22);
			tempset1.addAll(tempset22);
			tempset22.clear();
			if(flag==0){
				Object t[]=treeSet.toArray();
				if((int) t[t.length-1]>n){
					return (int)t[n];
				}
				max=(int) t[t.length-1]*5;
				treeSet.add(max);
				treeSet.add(max/5);
				tempset1.add(max/5);
				tempset2.add(max/5);
			}
			
		}
	}
	public static void main(String[] args) {
		System.out.println(new Solution3().nthUglyNumber(10));
	}
}
