package algorithm;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public int climbStairs(int n) {

        if(n == 1 || n == 0) {
            return 1;
        }

        int one = 1, two = 1;
        int res = 0;
        for(int i = 2; i <= n; i++) {
            res = one + two;
            one = two;
            two = res;
        }
        return res;
    }

    //一定要放在方法外，不然就没有任何意义了
    Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
    public int climbStairs2(int n) {
        if(n <= 1) {
            return 1;
        }
        if(cache.containsKey(n))
            return cache.get(n);
        int result = climbStairs2(n-1) + climbStairs2(n-2);
        cache.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        int result = cs.climbStairs(4);
        System.out.println(result);
    }
}

