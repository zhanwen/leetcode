package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

    /**
     * 充分利用HashMap,HashMap是基于HashTable，在性能上要优于暴力破解
     * @param nums  数组
     * @param target    目标值
     * @return  下标索引数组
     */
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            int num = target - nums[i];

            if(map.containsKey(num)) {
                index[0] = map.get(num);
                index[1] = i;

                return index; //找到就直接返回，可以减少运行时间。 运行时间为7ms 不加上的话运行时间为10ms
            }else {
                map.put(nums[i], i);
            }
        }
        return index;
    }

    /**
     * 首先想到的方法，也有点思维定式，暴力破解，切记使用排序
     * @param nums  数组
     * @param target  目标值
     * @return  下标索引数组
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] index = new int[2];
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                //超过target就直接结束掉本次循环，时间减少到67ms
                if(nums[i] + nums[j] > target) {
                    continue;
                }
                if(nums[i] + nums[j] == target) {
                    index[0] = i;
                    index[1] = j;
                    return index;       //找到就直接返回  程序运行49ms 不加的话72ms
                }
            }
        }
        return index;
    }

    /**
     * 运行时间为9ms
     * @param nums
     * @param target
     * @return
     */
    private int[] twoSum3(int[] nums, int target){
        int[] nums2 = new int[nums.length];
        System.arraycopy(nums, 0, nums2, 0, nums.length);
        Arrays.sort(nums);
        int[] index = new int[2];
        int left = 0, right = nums.length - 1;
        List<Integer> result = new ArrayList<Integer>();
        while(left < right){
            if(nums[left] + nums[right] == target){
                result.add(nums[left]);
                result.add(nums[right]);
                do {
                    left++;
                }while (left < nums.length && nums[left] == nums[left-1]);
                do {
                    right--;
                }while (right >= 0 && nums[right] == nums[right+1]);

            } else if (nums[left] + nums[right] > target){
                right--;
            } else {
                left++;
            }
        }
        boolean flag = true;
        for(int i = 0; i < nums2.length; i++) {
            if(result.get(0) == nums2[i] && flag) {
                index[0] = i;
                flag = false;
            }
            if(result.get(1) == nums2[i]) {
                index[1] = i;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] nums = new int[]{3, 3};
        int target = 6;
        int[] res = ts.twoSum3(nums, target);
        System.out.println(res[0] + "===" + res[1]);

    }


}
