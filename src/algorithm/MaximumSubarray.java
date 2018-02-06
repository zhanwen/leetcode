package algorithm;

public class MaximumSubarray {
    /**
     * 子数组和最大值
     * 对于一个子数组求子数组的和最大，并不需要将所有的情况一一列举并计算，只需要将其依次相加并比较即可。
     * 对于和小于0的，将其重新赋值为0，若大于0的，则取和和最大值的最大值
     * @param nums  输入的数组
     * @return  最大子数组和
     */
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = {-2, -1};
        int result = ms.maxSubArray(nums2);
        System.out.println(result);
    }

}
