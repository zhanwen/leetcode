package algorithm;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesfromSortedArray {

    /**
     *  使用双指针来移动数字，这里返回的长度是去重之后的，但是并没有将后面多余的移除，程序会截取返回长度的数组
     *  例如：原数组 {1,1,1,2}
     *  函数执行之后的数组为 {1,2,1,2}
     *  返回长度为2，所以是前面的两个元素
     *
     * @param nums  输入的数组
     * @return  去重之后的数组长度
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        int len = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                if(nums[i] != nums[len]) {
                    nums[len] = nums[i];
                }
                len++;
            }
        }
        return len;
    }

    /**
     * 题目明确要求只能替换，所以这种做法只是计算出了最终的数组的长度，但是没有将元素从数组移除，是错误的
     * @param nums  输入数组
     * @return  去重之后的数组长度
     */
    public int removeDuplicates2(int[] nums) {

        if(nums.length == 0 || nums == null) return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                continue;
            }
            map.put(nums[i], i);
        }
        return map.size();
    }


    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray test = new RemoveDuplicatesfromSortedArray();
        int[] array = {1, 1, 1, 2};
        int len = test.removeDuplicates(array);
        System.out.println(len);
    }



}
