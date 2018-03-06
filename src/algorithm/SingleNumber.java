package algorithm;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i],1);
            }else {
                map.put(nums[i],2);
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == 1) {
                return nums[i];
            }
        }
        return 0;
    }

    int singleNumber2(int A[], int n) {
        int result = 0;
        for (int i = 0; i<n; i++)
        {
            result ^=A[i];
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();
        int result = sn.singleNumber(new int[]{1});
        System.out.println(result);
    }


}
