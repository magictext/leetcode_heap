package unsolved_me_264;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Solution2 {
	public int nthUglyNumber(int n) {
		int temp = 0;
		TreeSet<Integer> treeSet = new TreeSet<>();
		TreeSet<Integer> tempset1 = new TreeSet<>();
		TreeSet<Integer> tempset2 = new TreeSet<>();
		tempset1.add(1);
		tempset2.add(1);
		treeSet.add(1);
		int flag = 0;
		int min=0;
		while (n >= min) {
			for (Integer integer : tempset1) {
				if (flag == 0) {
					flag = 1;
					if (temp > integer * 2) {
						tempset2.add(integer * 2);
						// tempset2.remove(integer);
						flag = 0;
					}
					if (temp > integer * 3) {
						tempset2.add(integer * 3);
						// tempset2.remove(integer);
						flag = 0;
					}
					if (flag == 1) {
						min=integer;
						tempset2.add(integer * 5);
						// tempset2.remove(integer);
						flag = 0;
					}
				}

			}

			treeSet.addAll(tempset2);
			Object obj[] = treeSet.toArray();
			temp = (Integer) obj[obj.length - 1];
			tempset1 = (TreeSet<Integer>) tempset2.clone();
			// tempset2.clear();
		}
		ArrayList<Integer> arrayList = new ArrayList<>(treeSet);
		// System.out.println(arrayList);
		System.out.println(arrayList);
		return arrayList.get(n - 1);
	}

	public static void main(String[] args) {
		System.out.println(new Solution2().nthUglyNumber(18));
	}
}
