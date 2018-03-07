package algorithm;

import java.util.HashMap;
import java.util.Map;

public class TwoSumII {

    /**
     * 从两边开始下手，一步一步的逼近结果，若找到结果循环结束，返回结果。
     * @param numbers   整型数组
     * @param target    目标数
     * @return  数组中的下标索引
     */
    public int[] twoSumII(int[] numbers, int target) {
        int[] index = new int[2];
        if(numbers == null || numbers.length < 2) return index;
        int left = 0, right = numbers.length - 1;
        while(left < right) {
            int res = numbers[left] + numbers[right];
            if(res == target) {
                index[0] = left + 1;
                index[1] = right + 1;
                break;
            }
            if(res > target) {
                right--;
            }else {
                left++;
            }
        }
        return index;
    }

    /**
     * 这种方法计算有误，没有考虑到有多种情况的时候
     * 比如1,2,3,4,5,6,7,8 target:7
     * 这种情况下有三种可能性，一种是1+6，另一种是2+5，还有一种是3+4
     * 若是使用map的情况，则会返回最后一种结果，这种方法适合在无序数组中求值
     * @param numbers   数组
     * @param target    目标数
     * @return  数组中的下标索引
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; numbers[i] < target; i++) {
            int res = target - numbers[i];
            if(map.containsKey(res)) {
                index[0] = map.get(res);
                index[1] = i+1;
                return index;
            }else {
                map.put(numbers[i], i+1);
            }
        }
        return index;
    }

    public static void main(String[] args) {
        TwoSumII ts = new TwoSumII();
        int[] input = new int[]{1,2,3,4,5,6,7,8};
        int[] res = ts.twoSumII(input, 9);
        System.out.println("first index: "+res[0]+"====second index: " + res[1]);
    }
}
