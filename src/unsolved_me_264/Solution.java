package unsolved_me_264;

import java.util.HashSet;

public class Solution {
	public int nthUglyNumber(int n) {
       HashSet<Integer> hashSet=new HashSet<>();
       hashSet.add(1);
       int count=1,x=0;
       while (count!=n) {
    	   x++;
    	   if(x%2==0&&hashSet.contains(x/2)){
    		   hashSet.add(x);
    		   System.out.println(x);
    		   count++;
    	   }
    	   else if(x%3==0&&hashSet.contains(x/3)){
    		   System.out.println(x);
    		   hashSet.add(x);
    		   count++;
    		   //continue;
    	   }
    	   else if(x%5==0&&hashSet.contains(x/5)){
    		   System.out.println(x);
    		   hashSet.add(x);
    		   count++;
    		   //continue;
    	   }
       }
       return x;
    }
	public static void main(String[] args) {
		System.out.println(new Solution().nthUglyNumber(169));
	}
}
